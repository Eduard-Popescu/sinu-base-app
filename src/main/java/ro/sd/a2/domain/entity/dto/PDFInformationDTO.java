package ro.sd.a2.domain.entity.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class PDFInformationDTO {

  private String studentName;

  private String studentEmail;

  private String specializationName;

  private String classYear;

  private String faculty;

  private int grade;


}
