package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
    public Optional<Event> findById(Long id);
    public List<Event> filterByRating(int rating, List<Event> events);
    public void update(long id, String name, String description, float popularityScore, Location location);
    public void add(String name, String description, float popularityScore,Location location);
    public void deleteById(long id);
}
