package ro.sd.a2.domain.entity;

import lombok.*;
import ro.sd.a2.domain.compositeKey.CompositeKeyTopicClass;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
@Table(name = "TOPIC_CLASS")
public class TopicClass {

  @EmbeddedId
  @Column(name = "TOPIC_CLASS_ID")
  private CompositeKeyTopicClass topicClassId;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("topicId")
  @JoinColumn(name = "TOPIC_ID")
  private Topic topic;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("classId")
  @JoinColumn(name = "CLASS_ID")
  private Class aClass;
}
