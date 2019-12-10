package chatter.repos;

import org.springframework.data.repository.CrudRepository;
import chatter.domain.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
