package ro.sd.a2.service.serviceImp;

import org.springframework.stereotype.Service;
import ro.sd.a2.domain.entity.Teacher;
import ro.sd.a2.domain.entity.TeacherTopic;
import ro.sd.a2.domain.entity.Topic;
import ro.sd.a2.domain.entity.dto.TeacherDTO;
import ro.sd.a2.domain.entity.dto.TopicDTO;
import ro.sd.a2.repository.TeacherRepository;
import ro.sd.a2.repository.TeacherTopicRepository;
import ro.sd.a2.repository.TopicRepository;
import ro.sd.a2.service.TeacherTopicService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TeacherTopicServiceImpl implements TeacherTopicService {

    private final TeacherTopicRepository teacherTopicRepository;
    private final TeacherRepository teacherRepository;
    private final TopicRepository topicRepository;

    public TeacherTopicServiceImpl(TeacherTopicRepository teacherTopicRepository, TeacherRepository teacherRepository, TopicRepository topicRepository) {
        this.teacherTopicRepository = teacherTopicRepository;
        this.teacherRepository = teacherRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public Collection<Topic> getAllTeachingTopics(String teacherId) {
        Collection<TeacherTopic> teacherTopics = teacherTopicRepository.getTeacherTopicByTeacher_TeacherId(teacherId);

        Collection<Topic> teachingTopics = new ArrayList<>();
        for (TeacherTopic teacherTopic : teacherTopics) {
            teachingTopics.add(topicRepository.getById(teacherTopic.getTeacherTopicId().getTopicId()));
        }

        return teachingTopics;
    }

    @Override
    public Collection<Teacher> getAllTopicTeachers(String topicId) {
        Collection<TeacherTopic> teacherTopics = teacherTopicRepository.getTeacherTopicByTopic_TopicId(topicId);

        Collection<Teacher> topicTeachers = new ArrayList<>();
        for (TeacherTopic teacherTopic : teacherTopics) {
            topicTeachers.add(teacherRepository.getById(teacherTopic.getTeacherTopicId().getTeacherId()));
        }

        return topicTeachers;
    }
}
