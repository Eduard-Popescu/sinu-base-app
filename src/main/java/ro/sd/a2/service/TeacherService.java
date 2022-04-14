package ro.sd.a2.service;

import ro.sd.a2.domain.entity.Teacher;
import ro.sd.a2.domain.entity.Topic;
import ro.sd.a2.domain.entity.dto.NewTeacherDTO;
import ro.sd.a2.domain.entity.dto.TeacherDTO;
import ro.sd.a2.domain.entity.dto.TopicDTO;

import java.util.Collection;

public interface TeacherService {

    void addTeacher(NewTeacherDTO newTeacherDTO);

    TeacherDTO getTeacherById(String teacherId);

    TeacherDTO getTeacherByName(String teacherName);

    Collection<TopicDTO> getAllTeachingTopics(String teacherId);
}
