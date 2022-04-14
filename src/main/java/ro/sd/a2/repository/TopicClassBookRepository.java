package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.sd.a2.domain.compositeKey.CompositeKeyTopicClassBook;
import ro.sd.a2.domain.entity.TopicClassBook;

import java.util.List;

@Repository
public interface TopicClassBookRepository
    extends JpaRepository<TopicClassBook, CompositeKeyTopicClassBook> {

  @Query("SELECT TCB FROM TopicClassBook TCB WHERE TCB.topicClassBookId.classBookId = ?1")
  TopicClassBook getTopicClassBookByClassBookId(String classBookId);

}
