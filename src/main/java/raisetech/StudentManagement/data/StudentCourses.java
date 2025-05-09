package raisetech.StudentManagement.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class StudentCourses {

  private String id;
  private String studentId;
  @NotBlank(message = "コース名は必須です。")
  private String courseName;

  @NotNull(message = "受講開始日は必須です。")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate courseStartDate;

  @NotNull(message = "コース終了予定日は必須です。")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate expectedEndDateOfTheCourse;

  public StudentCourses() {
  }

  public StudentCourses(String id, Student student, StudentCourses studentCourses) {
    this.id = id;
    this.studentId = student.getId();
    this.courseName = studentCourses.getCourseName();
    this.courseStartDate = studentCourses.getCourseStartDate();
    this.expectedEndDateOfTheCourse = studentCourses.getExpectedEndDateOfTheCourse();
  }
}
