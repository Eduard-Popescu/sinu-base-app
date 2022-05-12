package ro.sd.a2.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.domain.entity.ClassBook;
import ro.sd.a2.domain.entity.Student;
import ro.sd.a2.domain.entity.dto.ModifiedStudentDTO;
import ro.sd.a2.domain.entity.dto.NewStudentDTO;
import ro.sd.a2.domain.entity.dto.StudentClassBookDTO;
import ro.sd.a2.domain.entity.dto.StudentDTO;
import ro.sd.a2.mapper.StudentMapper;
import ro.sd.a2.repository.ClassRepository;
import ro.sd.a2.repository.StudentRepository;
import ro.sd.a2.service.StudentService;
import ro.sd.a2.domain.entity.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final ClassRepository classRepository;

  @Autowired
  public StudentServiceImpl(StudentRepository studentRepository, ClassRepository classRepository) {
    this.studentRepository = studentRepository;
    this.classRepository = classRepository;
  }


  /**
   *
   * @param userId
   * @return List<StudentClassBookDTO>
   */
  @Override
  public List<StudentClassBookDTO> getClassBookByUser(String userId) {
    Student student = studentRepository.getById(userId);
    return StudentMapper.studentToStudentClassBookDTO(student);
  }

  @Override
  public StudentDTO getStudentById(String studentId) {
    return StudentMapper.studentToStudentDTO(studentRepository.getById(studentId));
  }

  @Override
  public void modifyStudent(ModifiedStudentDTO modifiedStudentDTO) {
    Optional<Class> theClass = classRepository.findById(modifiedStudentDTO.getClassId());
    if (theClass.isEmpty())
      return;

    Student student = studentRepository.getById(modifiedStudentDTO.getStudentId());

    student.getPersonalInfo().setName(modifiedStudentDTO.getName());
    student.getPersonalInfo().setEmail(modifiedStudentDTO.getEmail());
    student.getPersonalInfo().setNpc(modifiedStudentDTO.getNpc());
    student.getPersonalInfo().getAddressList().get(0).setCity(modifiedStudentDTO.getCity());
    student.getPersonalInfo().getAddressList().get(0).setStreet(modifiedStudentDTO.getStreet());
    student.getPersonalInfo().getAddressList().get(0).setCountry(modifiedStudentDTO.getCountry());
    student.getPersonalInfo().getAddressList().get(0).setPostalCode(modifiedStudentDTO.getPostalCode());
    student.setAClass(theClass.get());

    studentRepository.save(student);
  }

  @Override
  public void deleteStudent(String studentId) {
    studentRepository.deleteById(studentId);
  }

  @Override
  public void addNewStudent(NewStudentDTO newStudentDTO) {
    Optional<Class> theClass = classRepository.findById(newStudentDTO.getClassId());
    if (theClass.isEmpty())
      return;

    Student newStudent = StudentMapper.newStudentDTOtoStudent(newStudentDTO);

    ClassBook classBook = new ClassBook();
    classBook.setClassBookId(UUID.randomUUID().toString());
    classBook.setClassBookYear(1);
    classBook.setClassBookSemester(1);
    classBook.setStudent(newStudent);

    newStudent.setClassBooks(new ArrayList<>());
    newStudent.getClassBooks().add(classBook);

    newStudent.setAClass(theClass.get());

    studentRepository.save(newStudent);
  }

  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }
}
