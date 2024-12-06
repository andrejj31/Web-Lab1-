package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.findByNameContainingOrDescriptionContaining(text,text);
    }

    @Override
    public List<Event> filterByRating(int rating, List<Event> events) {
        return events.stream()
                .filter(e -> e.getPopularityScore() >= rating)
                .collect(Collectors.toList());
    }

    @Override
    public void update(long id, String name, String description, float popularityScore, Location location) {
        Event event = eventRepository.findById(id).orElse(null);
        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(location);
        eventRepository.save(event);
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public void add(String name, String description, float popularityScore,Location location){
        Event event = new Event(name,description,popularityScore,location);
        eventRepository.save(event);
    }
    public void deleteById(long id){

        eventRepository.deleteById(id);
    }

}
