package ro.sd.a2.mapper;

import org.springframework.stereotype.Component;
import ro.sd.a2.domain.entity.Teacher;
import ro.sd.a2.domain.entity.TeacherEvaluation;
import ro.sd.a2.domain.entity.Topic;
import ro.sd.a2.domain.entity.dto.TeacherEvaluationDTO;

@Component
public class TeacherEvaluationMapper {

  public static TeacherEvaluation teacherEvaluationDtoToTeacherEvaluation(TeacherEvaluationDTO teacherEvaluationDTO, Topic topic, Teacher teacher){
    return TeacherEvaluation.builder()
        .teacher(teacher)
        .topic(topic)
        .evaluationCode(teacherEvaluationDTO.getEvaluationCode())
        .teacherEvaluationId(teacherEvaluationDTO.getTeacherEvaluationId())
        .documentsMadeAvailableGrade(teacherEvaluationDTO.getDocumentsMadeAvailableGrade())
        .finalGrade(teacherEvaluationDTO.getFinalGrade())
        .otherComments(teacherEvaluationDTO.getOtherComments())
        .subjectPresentationGrade(teacherEvaluationDTO.getSubjectPresentationGrade())
        .build();
  }

}
