package raisetech.StudentManagement.domain;

import lombok.Getter;
import lombok.Setter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;

@Getter
@Setter
public class StudentEnrollment {

  private Student student;
  private StudentCourses studentCourses;
}
