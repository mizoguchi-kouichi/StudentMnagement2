package raisetech.StudentManagement.domain;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;

@Getter
@Setter
public class StudentEnrollment {

  @Valid
  private Student student;
  @Valid
  private StudentCourses studentCourses;
}
