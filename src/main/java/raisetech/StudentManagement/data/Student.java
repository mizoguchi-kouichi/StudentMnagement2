package raisetech.StudentManagement.data;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

  private String id;
  @NotBlank(message = "名前は必須です。")
  private String name;
  @NotBlank(message = "フリガナは必須です。")
  private String kana;
  private String nickname;
  @NotBlank(message = "メールアドレスは必須です。")
  private String email;
  private String area;
  private int age;
  private String gender;
  private String remark;
  private boolean isDeleted = false;

  public Student() {
  }

  public Student(String id, Student student) {
    this.id = id;
    this.name = student.getName();
    this.kana = student.getKana();
    this.nickname = student.getNickname();
    this.email = student.getEmail();
    this.area = student.getArea();
    this.age = student.getAge();
    this.gender = student.getGender();
    this.remark = student.getRemark();
  }
}
