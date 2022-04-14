package ro.sd.a2.service.serviceImp;

import liquibase.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.sd.a2.controller.FirstController;
import ro.sd.a2.domain.entity.Teacher;
import ro.sd.a2.domain.entity.Topic;
import ro.sd.a2.domain.entity.dto.NewTeacherDTO;
import ro.sd.a2.domain.entity.dto.TeacherDTO;
import ro.sd.a2.domain.entity.dto.TopicDTO;
import ro.sd.a2.mapper.TeacherMapper;
import ro.sd.a2.mapper.TopicMapper;
import ro.sd.a2.repository.TeacherRepository;
import ro.sd.a2.service.TeacherService;
import ro.sd.a2.service.TeacherTopicService;

import java.util.Collection;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherTopicService teacherTopicService;

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherTopicService teacherTopicService) {
        this.teacherRepository = teacherRepository;
        this.teacherTopicService = teacherTopicService;
    }

    /**
     *
     * @param newTeacherDTO
     */
    @Override
    public void addTeacher(NewTeacherDTO newTeacherDTO) {
        Teacher teacher = TeacherMapper.getTeacherFromNewTeacherDTO(newTeacherDTO);
        teacherRepository.save(teacher);
    }

    /**
     *
     * @param teacherId
     * @return TeacherDTO
     */
    @Override
    public TeacherDTO getTeacherById(String teacherId) {
        Teacher teacher = teacherRepository.getById(teacherId);
        return TeacherMapper.getTeacherDTO(teacher);
    }

    /**
     *
     * @param teacherName
     * @return TeacherDTO
     */
    @Override
    public TeacherDTO getTeacherByName(String teacherName) {
        Teacher teacher = teacherRepository.getTeacherByName(teacherName);
        return TeacherMapper.getTeacherDTO(teacher);
    }

    /**
     *
     * @param teacherId
     * @return Collection<TopicDTO>
     */
    @Override
    public Collection<TopicDTO> getAllTeachingTopics(String teacherId) {
        if (StringUtil.isEmpty(teacherId)) {
            log.error("Teacher Id is empty");
            return null;
        }

        Collection<Topic> topics = teacherTopicService.getAllTeachingTopics(teacherId);
        if (topics.size() == 0) {
            log.warn("Was not found any topic teaching by teacher with id=" + teacherId);
            return null;
        }

        Collection<TopicDTO> topicDTOS = TopicMapper.getTopicDTOs(topics);

        return topicDTOS;
    }
}
