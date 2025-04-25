package raisetech.StudentManagement.domain;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;

@Getter
@Setter
public class StudentForm {

  @Valid
  private Student student;
  @Valid
  private StudentCourses studentCourses;

  public StudentForm() {
    this.student = new Student();
    this.studentCourses = new StudentCourses();
  }
}
