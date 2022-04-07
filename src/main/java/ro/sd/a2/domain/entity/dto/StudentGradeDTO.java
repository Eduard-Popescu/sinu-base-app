package ro.sd.a2.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentGradeDTO {

 private String topicName;

 private int semester;

 private int year;

 private int grade;

 private String examinationMethod;

}
