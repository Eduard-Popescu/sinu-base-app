package ro.sd.a2.service;

import ro.sd.a2.domain.entity.Teacher;
import ro.sd.a2.domain.entity.Topic;
import ro.sd.a2.domain.entity.dto.TeacherDTO;
import ro.sd.a2.domain.entity.dto.TopicDTO;

import java.util.Collection;

public interface TeacherTopicService {

    Collection<Topic> getAllTeachingTopics(String teacherId);

    Collection<Teacher> getAllTopicTeachers(String topicId);
}
