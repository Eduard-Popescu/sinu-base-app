package ro.sd.a2.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.domain.entity.Student;
import ro.sd.a2.domain.entity.dto.StudentClassBookDTO;
import ro.sd.a2.mapper.StudentMapper;
import ro.sd.a2.repository.StudentRepository;
import ro.sd.a2.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }


  @Override
  public List<StudentClassBookDTO> getClassBookByUser(String userId) {
    Student student = studentRepository.getById(userId);
    return StudentMapper.studentToStudentClassBookDTO(student);
  }
}
