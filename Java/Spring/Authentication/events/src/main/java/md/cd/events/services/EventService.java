package md.cd.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import md.cd.events.models.Event;
import md.cd.events.repositories.EventRepository;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event findById(Long id) {
        Optional<Event> e = eventRepository.findById(id);
        return e.isPresent() ? e.get() : null;
    }

    public List<Event> findByState(String state) {
        return eventRepository.findByState(state);
    }

    public List<Event> findByStateNot(String state) {
        return eventRepository.findByStateNot(state);
    }

    public Event create(Event event) {
        return eventRepository.save(event);
    }

    public Event editEvent(Event editedEvent, Event e) {
        e.setName(editedEvent.getName());
        e.setDate(editedEvent.getDate());
        e.setLocation(editedEvent.getLocation());
        e.setState(editedEvent.getState());
        return eventRepository.save(e);
    }
}
