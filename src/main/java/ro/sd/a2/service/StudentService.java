package ro.sd.a2.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ro.sd.a2.domain.entity.Student;
import ro.sd.a2.domain.entity.dto.*;

import java.util.List;

public interface StudentService extends UserDetailsService {

  List<StudentClassBookDTO> getClassBookByUser(String userId);

  StudentDTO getStudentById(String studentId);

  Student getStudentByEmail(String email);

  void save(UserRegistrationDTO userRegistrationDTO);

  void modifyStudent(ModifiedStudentDTO modifiedStudentDTO);

  void deleteStudent(String studentId);

  void addNewStudent(NewStudentDTO newStudentDTO);

  List<Student> getAllStudents();
}
