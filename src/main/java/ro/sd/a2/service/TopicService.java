package ro.sd.a2.service;

import ro.sd.a2.domain.entity.dto.TeacherDTO;

import java.util.Collection;

public interface TopicService {

    Collection<TeacherDTO> getAllTopicTeachers(String topicId);
}
