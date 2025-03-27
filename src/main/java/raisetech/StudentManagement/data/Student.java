package raisetech.StudentManagement.data;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

  private String id = UUID.randomUUID().toString();
  private String name;
  private String kana;
  private String nickname;
  private String email;
  private String area;
  private int age;
  private String gender;
  private String remark;
  private boolean idDeleted = false;

}
