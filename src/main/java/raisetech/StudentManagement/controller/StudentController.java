package raisetech.StudentManagement.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.domain.StudentForm;
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

  @GetMapping("newStudent")
  public String newStudent(Model model) {
    StudentForm studentForm = new StudentForm();
    model.addAttribute("studentForm", studentForm);
    return "registerStudent";
  }

  @GetMapping("/student/{id}")
  public String getStudentById(@PathVariable String id, Model model) {
    StudentDetail studentDetail = service.getStudentDetailById(id);
    model.addAttribute("studentDetail", studentDetail);
    return "updateStudent";
  }


  @PostMapping("/registerStudent")
  public String registerStudent(@Valid @ModelAttribute StudentForm studentForm,
      BindingResult result) {

    if (result.hasErrors()) {
      System.out.println("バリデーションエラーあり");
      result.getFieldErrors().forEach(error -> {
            System.out.println("エラー項目：" + error.getField());
            System.out.println("メッセージ：" + error.getDefaultMessage());
          }
      );
      return "/registerStudent";
    }
    service.registerStudent(studentForm);
    return "redirect:/studentList";
  }

  @PostMapping("/updateStudent")
  public String updateStudent(@Valid @ModelAttribute StudentDetail studentDetail,
      BindingResult result) {

    if (result.hasErrors()) {
      System.out.println("バリデーションエラーあり");
      result.getFieldErrors().forEach(error -> {
            System.out.println("エラー項目：" + error.getField());
            System.out.println("メッセージ：" + error.getDefaultMessage());
          }
      );
      return "/updateStudent";
    }

    service.updateStudent(studentDetail);
    return "redirect:/studentList";
  }
}
