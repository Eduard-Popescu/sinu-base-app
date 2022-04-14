package ro.sd.a2.service.serviceImp;

import liquibase.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.sd.a2.controller.FirstController;
import ro.sd.a2.domain.entity.Teacher;
import ro.sd.a2.domain.entity.Topic;
import ro.sd.a2.domain.entity.dto.TeacherDTO;
import ro.sd.a2.domain.entity.dto.TopicDTO;
import ro.sd.a2.mapper.TeacherMapper;
import ro.sd.a2.mapper.TopicMapper;
import ro.sd.a2.repository.TopicRepository;
import ro.sd.a2.service.TeacherTopicService;
import ro.sd.a2.service.TopicService;

import java.util.Collection;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    private final TeacherTopicService teacherTopicService;

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    public TopicServiceImpl(TopicRepository topicRepository, TeacherTopicService teacherTopicService) {
        this.topicRepository = topicRepository;
        this.teacherTopicService = teacherTopicService;
    }

    /**
     *
     * @param topicId
     * @return
     */
    @Override
    public Collection<TeacherDTO> getAllTopicTeachers(String topicId) {
        if (StringUtil.isEmpty(topicId)) {
            log.error("Topic Id is empty");
            return null;
        }

        Collection<Teacher> teachers = teacherTopicService.getAllTopicTeachers(topicId);
        if (teachers.size() == 0) {
            log.warn("Was not found any teacher to teaching the topic with id=" + topicId);
            return null;
        }

        Collection<TeacherDTO> teacherDTOS = TeacherMapper.getTeacherDTOs(teachers);

        return teacherDTOS;
    }

    /**
     *
     * @param topicId
     * @return
     */
    @Override
    public TopicDTO getTopicById(String topicId) {
        Topic topic = topicRepository.getTopicByTopicId(topicId);
        return TopicMapper.getTopicDTO(topic);
    }

    /**
     *
     * @param topicName
     * @return
     */
    @Override
    public TopicDTO getTopicByTopicName(String topicName) {
        Topic topic = topicRepository.getTopicByTopicName(topicName);
        return TopicMapper.getTopicDTO(topic);
    }
}
