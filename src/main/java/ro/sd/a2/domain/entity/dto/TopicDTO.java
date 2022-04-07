package ro.sd.a2.domain.entity.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TopicDTO {

    private String topicId;

    private String topicName;

    private Integer credits;

    private String examinationType;
}
