package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.a2.domain.compositeKey.CompositeKeyTeacherTopic;
import ro.sd.a2.domain.entity.Teacher;
import ro.sd.a2.domain.entity.TeacherTopic;

import java.util.Collection;

@Repository
public interface TeacherTopicRepository extends JpaRepository<TeacherTopic, CompositeKeyTeacherTopic> {

    Collection<TeacherTopic> getTeacherTopicByTeacher_TeacherId(String teacherId);

    Collection<TeacherTopic> getTeacherTopicByTopic_TopicId(String topicId);
}
