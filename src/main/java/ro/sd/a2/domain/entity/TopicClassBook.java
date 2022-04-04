package ro.sd.a2.domain.entity;

import lombok.*;
import ro.sd.a2.domain.compositeKey.CompositeKeyTopicClassBook;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
@Table(name = "TOPIC_CLASS_BOOK")
public class TopicClassBook {

  @EmbeddedId
  @Column(name = "TOPIC_CLASS_BOOK_ID")
  private CompositeKeyTopicClassBook topicClassBookId;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("topicId")
  @JoinColumn(name = "TOPIC_ID")
  private Topic topic;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("classBookId")
  @JoinColumn(name = "CLASS_BOOK_ID")
  private ClassBook classBook;

  @Column(name = "GRADE")
  private Integer grade;
}
