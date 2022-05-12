package ro.sd.a2.mapper;

import org.springframework.stereotype.Component;
import ro.sd.a2.domain.entity.*;
import ro.sd.a2.domain.entity.dto.NewStudentDTO;
import ro.sd.a2.domain.entity.dto.StudentClassBookDTO;
import ro.sd.a2.domain.entity.dto.StudentDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

  public static List<StudentClassBookDTO> studentToStudentClassBookDTO(Student student){
    List<StudentClassBookDTO> classBookDTOS = new ArrayList<>();
    for(ClassBook classBook: student.getClassBooks()){
      StudentClassBookDTO studentClassBookDTO = StudentClassBookDTO.builder()
          .studentId(student.getStudentId())
          .classBookId(classBook.getClassBookId())
          .classBookSemester(classBook.getClassBookSemester())
          .classBookYear(classBook.getClassBookYear())
          .build();
      classBookDTOS.add(studentClassBookDTO);
    }
    return classBookDTOS;
  }

  public static StudentDTO studentToStudentDTO(Student s) {
    StudentDTO studentDTO = StudentDTO.builder()
            .studentId(s.getStudentId())
            .personalInfo(s.getPersonalInfo())
            .aClass(s.getAClass())
            .classBooks(s.getClassBooks())
            .build();

    studentDTO.getPersonalInfo().setPassword("");

    return studentDTO;
  }

  public static List<StudentDTO> studentsToStudentDTOs(Collection<Student> students) {
    return students.stream().map(StudentMapper::studentToStudentDTO).collect(Collectors.toList());
  }

  public static Student newStudentDTOtoStudent(NewStudentDTO newStudentDTO) {

    Address address = Address.builder()
            .addressId(UUID.randomUUID().toString())
            .street(newStudentDTO.getStreet())
            .city(newStudentDTO.getCity())
            .country(newStudentDTO.getCountry())
            .postalCode(newStudentDTO.getPostalCode())
            .build();

    List<Address> addressList = new ArrayList<>();
    addressList.add(address);

    PersonalInfo personalInfo = PersonalInfo.builder()
            .personalInfoId(UUID.randomUUID().toString())
            .name(newStudentDTO.getName())
            .password(newStudentDTO.getPassword())
            .email(newStudentDTO.getEmail())
            .npc(newStudentDTO.getNpc())
            .addressList(addressList)
            .build();
    address.setPersonalInfo(personalInfo);

    return Student.builder()
            .studentId((UUID.randomUUID().toString()))
            .personalInfo(personalInfo)
            .build();
  }

}
