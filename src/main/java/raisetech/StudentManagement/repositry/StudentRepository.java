package raisetech.StudentManagement.repositry;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;

/**
 * 受講生情報を扱うリポジトリ。 全件検索や単一条件での検索、コース情報の検索が行えるクラスです。
 */
@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> searchStudents();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchByIdStudent(String id);

  @Select("SELECT * from students_courses")
  List<StudentCourses> searchCourses();

  @Select("SELECT * from students_courses WHERE student_id = #{studentId}")
  List<StudentCourses> searchCoursesByStudentId(String studentId);

  @Insert("INSERT INTO students (id, name, kana, nickname, email, area, age, gender, remark, is_deleted) VALUES (#{id},#{name},#{kana},#{nickname},#{email},#{area},#{age},#{gender},#{remark},#{isDeleted})")
  void registerStudent(Student student);

  @Insert(
      "INSERT INTO students_courses (id, student_id, course_name, course_start_date, expected_end_date_of_the_course) VALUES "
          + "(#{id},#{studentId}, #{courseName}, #{courseStartDate}, #{expectedEndDateOfTheCourse})"
  )
  void registerStudentCourse(StudentCourses studentCourses);

  @Update("UPDATE students SET name = #{name}, kana = #{kana}, nickname = #{nickname}, email = #{email}, area = #{area}, age = #{age}, gender = #{gender}, remark = #{remark}, is_deleted = #{isDeleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE students_courses SET  course_name = #{courseName} WHERE student_id = #{studentId}")
  void updateStudentCourse(StudentCourses studentCourses);
}
