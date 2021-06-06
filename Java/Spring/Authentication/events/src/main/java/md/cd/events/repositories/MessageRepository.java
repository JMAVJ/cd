package md.cd.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import md.cd.events.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    
}
