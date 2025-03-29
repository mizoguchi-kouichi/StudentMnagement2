package raisetech.StudentManagement.service;

import java.util.List;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.repositry.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> getStudents() {
    return repository.search();
  }

  public List<StudentCourses> getStudentCourses() {
    return repository.searchCourses();
  }

  public void registerStudent(Student student, StudentCourses studentCourses) {
    repository.registerStudent(student);
    repository.registerStudentCourse(studentCourses.getId(), student.getName(),
        studentCourses.getCourseName(), studentCourses.getCourseStartDate(),
        studentCourses.getExpectedEndDateOfTheCourse());
  }


}
