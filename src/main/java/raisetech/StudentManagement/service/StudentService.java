package raisetech.StudentManagement.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.domain.StudentForm;
import raisetech.StudentManagement.repositry.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> getStudents() {
    return repository.searchStudents();
  }

  public List<StudentCourses> getStudentCourses() {
    return repository.searchCourses();
  }

  public StudentDetail getStudentDetailById(String id) {

    StudentDetail studentDetail = new StudentDetail();
    Student student = repository.searchByIdStudent(id);
    List<StudentCourses> studentCourses = repository.searchCoursesByStudentId(id);
    studentDetail.setStudent(student);
    studentDetail.setStudentCourses(studentCourses);
    return studentDetail;
  }

  public void registerStudent(StudentForm studentForm) {

    Student registerStudent = new Student(UUID.randomUUID().toString(), studentForm.getStudent());
    StudentCourses registerStudentCourses = new StudentCourses(UUID.randomUUID().toString(),
        registerStudent, studentForm.getStudentCourses());

    repository.registerStudent(registerStudent);
    repository.registerStudentCourse(registerStudentCourses);
  }

  public void updateStudent(StudentDetail studentDetail) {

    repository.updateStudent(studentDetail.getStudent());
    for (StudentCourses studentCourses : studentDetail.getStudentCourses()) {
      studentCourses.setStudentId(studentDetail.getStudent().getId());
      repository.updateStudentCourse(studentCourses);
    }
  }
}
