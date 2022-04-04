package ro.sd.a2.domain.entity;

import lombok.*;
import ro.sd.a2.domain.compositeKey.CompositeKeyTeacherTopic;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
@Table(name = "TEACHER_TOPIC")
public class TeacherTopic {

  @EmbeddedId
  @Column(name = "TEACHER_TOPIC_ID")
  private CompositeKeyTeacherTopic teacherTopicId;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("teacherId")
  @JoinColumn(name = "TEACHER_ID")
  private Teacher teacher;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("topicId")
  @JoinColumn(name = "TOPIC_ID")
  private Topic topic;

}
