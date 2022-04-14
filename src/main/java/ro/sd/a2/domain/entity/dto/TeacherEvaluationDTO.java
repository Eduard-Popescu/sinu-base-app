package ro.sd.a2.domain.entity.dto;

import lombok.*;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherEvaluationDTO {

  private String teacherEvaluationId;

  private Double subjectPresentationGrade;

  private Double documentsMadeAvailableGrade;

  private Double finalGrade;

  private String otherComments;

  private String evaluationCode;

  private String topicName;

  private String teacherName;

}
