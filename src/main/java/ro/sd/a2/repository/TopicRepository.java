package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.sd.a2.domain.entity.Topic;

import java.util.Collection;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String> {

    Topic getTopicByTopicId(String topicId);

    @Query("SELECT T FROM Topic T WHERE T.topicName=?1")
    Topic getTopicByTopicName(String topicName);
}
