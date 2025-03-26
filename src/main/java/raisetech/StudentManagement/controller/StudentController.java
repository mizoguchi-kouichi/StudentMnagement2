package raisetech.StudentManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;

  private final StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public List<StudentDetail> getStudent() {
    List<Student> students = service.getStudents();
    List<StudentCourses> studentCourses = service.getStudentCourses();

    return converter.convertStudentDetails(students, studentCourses);
  }

  @GetMapping("/studentsCoursesList")
  public List<StudentCourses> getStudentcoursesList() {
    return service.getStudentCourses();
  }
}
