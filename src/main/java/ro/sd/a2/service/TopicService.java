package ro.sd.a2.service;

import ro.sd.a2.domain.entity.dto.TeacherDTO;
import ro.sd.a2.domain.entity.dto.TopicDTO;

import java.util.Collection;

public interface TopicService {

    Collection<TeacherDTO> getAllTopicTeachers(String topicId);

    TopicDTO getTopicById(String topicId);

    TopicDTO getTopicByTopicName(String topicName);
}
