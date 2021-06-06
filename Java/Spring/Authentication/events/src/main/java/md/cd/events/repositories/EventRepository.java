package md.cd.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import md.cd.events.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByState(String state);
    List<Event> findByStateNot(String state);
}
