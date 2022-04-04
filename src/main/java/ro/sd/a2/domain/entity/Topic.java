package ro.sd.a2.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
@Table(name = "TOPIC")
public class Topic {

  @Id
  @Column(name = "TOPIC_ID")
  private String topicId;

  @Column(name = "TOPIC_NAME")
  private String topicName;

  @Column(name = "CREDITS")
  private Integer credits;

  @Column(name = "EXAMINATION_TYPE")
  private String examinationType;

}
