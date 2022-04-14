package ro.sd.a2.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
@Table(name = "TEACHER_EVALUATION")
public class TeacherEvaluation {

  @Id
  @Column(name = "TEACHER_EVALUATION_ID")
  private String teacherEvaluationId;

  @Column(name = "SUBJECT_PRESENTATION")
  private Double subjectPresentationGrade;

  @Column(name = "DOCUMENTS_MADE_AVAILABLE")
  private Double documentsMadeAvailableGrade;

  @Column(name = "FINAL_GRADE")
  private Double finalGrade;

  @Column(name = "OTHER_COMMENTS")
  private String otherComments;

  @Column(name = "EVALUATION_CODE")
  private String evaluationCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TEACHER_ID", nullable = false)
  private Teacher teacher;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TOPIC_ID", nullable = false)
  private Topic topic;

}
