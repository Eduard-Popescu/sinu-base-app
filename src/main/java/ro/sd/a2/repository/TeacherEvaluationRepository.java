package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.sd.a2.domain.entity.TeacherEvaluation;

import java.util.Optional;

@Repository
public interface TeacherEvaluationRepository extends JpaRepository<TeacherEvaluation, String> {

  @Query("SELECT TE FROM TeacherEvaluation TE WHERE TE.evaluationCode=?1 and TE.teacher.personalInfo.name=?2 and TE.topic.topicName=?3")
  Optional<TeacherEvaluation> getTeacherEvaluationByEvaluationCode(String evaluationCode,String name,String topicName);

}
