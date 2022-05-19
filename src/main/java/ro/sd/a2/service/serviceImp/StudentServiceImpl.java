package ro.sd.a2.service.serviceImp;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.sd.a2.domain.entity.*;
import ro.sd.a2.domain.entity.Class;
import ro.sd.a2.domain.entity.dto.*;
import ro.sd.a2.mapper.StudentMapper;
import ro.sd.a2.repository.AdminRepository;
import ro.sd.a2.repository.ClassRepository;
import ro.sd.a2.repository.StudentRepository;
import ro.sd.a2.repository.TeacherRepository;
import ro.sd.a2.service.StudentService;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final ClassRepository classRepository;
  private final AdminRepository adminRepository;
  private final TeacherRepository teacherRepository;

  private UserDetails userDetails;

  @Autowired
  public StudentServiceImpl(StudentRepository studentRepository, ClassRepository classRepository, AdminRepository adminRepository, TeacherRepository teacherRepository) {
    this.studentRepository = studentRepository;
    this.classRepository = classRepository;
    this.adminRepository = adminRepository;
    this.teacherRepository = teacherRepository;
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
  public Student getStudentByEmail(String email) {
    return studentRepository.getStudentByEmail(email);
  }

  @Override
  public void save(UserRegistrationDTO userRegistrationDTO) {
    Optional<Class> theClass = classRepository.findById(userRegistrationDTO.getClassId());
    if (theClass.isEmpty())
      return;

    Student newStudent = StudentMapper.userRegistrationDTOtoStudent(userRegistrationDTO);

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

  @SneakyThrows
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Student student = studentRepository.getStudentByEmail(username);
    Administrator administrator = adminRepository.getAdministratorByEmail(username);
    Teacher teacher = teacherRepository.getTeacherByEmail(username);

    if(student != null && administrator == null && teacher == null){
      Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority("STUDENT USER"));
      this.userDetails = new org.springframework.security.core.userdetails.User(student.getStudentId(),
          student.getPersonalInfo().getPassword(), authorities);
      return this.userDetails;
    }
    if(administrator != null && student == null && teacher == null){
      Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority("ADMIN USER"));
      this.userDetails = new org.springframework.security.core.userdetails.User(administrator.getAdministratorId(),
          administrator.getPersonalInfo().getPassword(), authorities);
      return this.userDetails;
    }
    if(teacher != null && administrator == null && student == null){
      Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority("TEACHER USER"));
      this.userDetails = new org.springframework.security.core.userdetails.User(teacher.getTeacherId(),
          teacher.getPersonalInfo().getPassword(), authorities);
      return this.userDetails;
    }
    throw new UsernameNotFoundException("Invalid username or password.");
  }

  public UserDetails getUserDetails(){
    return this.userDetails;
  }

}
