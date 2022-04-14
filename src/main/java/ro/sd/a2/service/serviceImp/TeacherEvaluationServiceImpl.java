package ro.sd.a2.service.serviceImp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.sd.a2.domain.entity.PersonalInfo;
import ro.sd.a2.domain.entity.Teacher;
import ro.sd.a2.domain.entity.TeacherEvaluation;
import ro.sd.a2.domain.entity.Topic;
import ro.sd.a2.domain.entity.dto.TeacherEvaluationDTO;
import ro.sd.a2.mapper.TeacherEvaluationMapper;
import ro.sd.a2.mapper.TeacherMapper;
import ro.sd.a2.mapper.TopicMapper;
import ro.sd.a2.repository.TeacherEvaluationRepository;
import ro.sd.a2.repository.TeacherRepository;
import ro.sd.a2.service.PersonalInfoService;
import ro.sd.a2.service.TeacherEvaluationService;
import ro.sd.a2.service.TeacherService;
import ro.sd.a2.service.TopicService;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class TeacherEvaluationServiceImpl implements TeacherEvaluationService {

  private final TeacherEvaluationRepository teacherEvaluationRepository;
  private final TopicServiceImpl topicService;
  private final TeacherServiceImpl teacherService;
  private final PersonalInfoServiceImpl personalInfoService;

  public TeacherEvaluationServiceImpl(TeacherEvaluationRepository teacherEvaluationRepository, TopicServiceImpl topicService, TeacherServiceImpl teacherService, PersonalInfoServiceImpl personalInfoService) {
    this.teacherEvaluationRepository = teacherEvaluationRepository;
    this.topicService = topicService;
    this.teacherService = teacherService;
    this.personalInfoService = personalInfoService;
  }

  /**
   *
   * @param teacherEvaluationDTO
   * @return String
   */
  @Override
  @Transactional
  public String addEvaluation(TeacherEvaluationDTO teacherEvaluationDTO) {
    log.debug("TeacherEvaluationDTO from client:{}",teacherEvaluationDTO.toString());
    String resultMessage;
    Optional<TeacherEvaluation> teacherEvaluationOptional = teacherEvaluationRepository.
        getTeacherEvaluationByEvaluationCode(teacherEvaluationDTO.getEvaluationCode(),teacherEvaluationDTO.getTeacherName(),teacherEvaluationDTO.getTopicName());
    if(teacherEvaluationOptional.isPresent()){
      resultMessage = "You have already evaluated this teacher";
      log.debug("Result message from addEvaluationTeacher:{}",resultMessage);
      return resultMessage;
    }
    teacherEvaluationDTO.setTeacherEvaluationId(UUID.randomUUID().toString());
    PersonalInfo personalInfo = personalInfoService.getPersonalInfoByName(teacherEvaluationDTO.getTeacherName());
    Topic topic = TopicMapper.topicDtoToTopic(topicService.getTopicByTopicName(teacherEvaluationDTO.getTopicName()));
    Teacher teacher = TeacherMapper.teacherDtoToTeacher(teacherService.getTeacherByName(teacherEvaluationDTO.getTeacherName()),teacherEvaluationDTO.getTeacherName(),personalInfo);
    TeacherEvaluation teacherEvaluation = TeacherEvaluationMapper.teacherEvaluationDtoToTeacherEvaluation(teacherEvaluationDTO,topic,teacher);
    teacherEvaluationRepository.save(teacherEvaluation);
    resultMessage = "Evaluation was saved";
    log.debug("Result message from addEvaluationTeacher:{}",resultMessage);
    return resultMessage;
  }

}
