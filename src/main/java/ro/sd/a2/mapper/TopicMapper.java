package ro.sd.a2.mapper;

import ro.sd.a2.domain.entity.Topic;
import ro.sd.a2.domain.entity.dto.TopicDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class TopicMapper {

    public static TopicDTO getTopicDTO(Topic topic) {
        return TopicDTO.builder()
                .topicId(topic.getTopicId())
                .topicName(topic.getTopicName())
                .credits(topic.getCredits())
                .examinationType(topic.getExaminationType())
                .build();
    }

    public static Collection<TopicDTO> getTopicDTOs(Collection<Topic> topics) {
        return topics.stream().map(TopicMapper::getTopicDTO).collect(Collectors.toList());
    }

    public static Topic topicDtoToTopic(TopicDTO topicDTO){
        return Topic.builder()
            .credits(topicDTO.getCredits())
            .examinationType(topicDTO.getExaminationType())
            .topicId(topicDTO.getTopicId())
            .topicName(topicDTO.getTopicName())
            .build();
    }
}
