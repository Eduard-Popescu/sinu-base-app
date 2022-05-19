package ro.sd.a2.mapper;

import org.springframework.stereotype.Component;
import ro.sd.a2.domain.entity.Student;
import ro.sd.a2.domain.entity.dto.PDFInformationDTO;

@Component
public class PDFMapper {

  public static PDFInformationDTO studentToPDFInformationDTO(Student student){
    int min = 4;
    int max = 10;
    int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
    return PDFInformationDTO.builder()
        .studentName(student.getPersonalInfo().getName())
        .studentEmail(student.getPersonalInfo().getEmail())
        .classYear(student.getAClass().getClassYear())
        .faculty(student.getAClass().getSpecialization().getFaculty().getFacultyName())
        .specializationName(student.getAClass().getSpecialization().getSpecializationName())
        .grade(random_int)
        .build();
  }


}
