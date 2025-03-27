package raisetech.StudentManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.service.StudentService;

@Controller
public class StudentController {

  private StudentService service;

  private final StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public String getStudent(Model model) {
    List<Student> students = service.getStudents();
    List<StudentCourses> studentCourses = service.getStudentCourses();

    model.addAttribute("studentList", converter.convertStudentDetails(students, studentCourses));
    return "studentList";
  }

  @GetMapping("/studentsCoursesList")
  public List<StudentCourses> getStudentcoursesList() {
    return service.getStudentCourses();
  }

  @GetMapping("newStudent")
  public String newStudent(Model model) {
    model.addAttribute("student", new Student());
    return "registerStudent";
  }

  @PostMapping("/registerStudent")
  public String registerStudent(@ModelAttribute Student student, BindingResult result) {
    if (result.hasErrors()) {
      return "registerStudent";
    }
    service.registerStudent(student);
    return "redirect:/studentList";
  }
}
