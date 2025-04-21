package raisetech.StudentManagement.data;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

  private String id = UUID.randomUUID().toString();
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
}
