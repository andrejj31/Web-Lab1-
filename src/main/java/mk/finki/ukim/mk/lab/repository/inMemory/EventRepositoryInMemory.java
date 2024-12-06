package mk.finki.ukim.mk.lab.repository.inMemory;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EventRepositoryInMemory {

    public List<Event> findAll(){
            return DataHolder.eventsList;
    }
    public List<Event> searchEvents(String text){
        return DataHolder.eventsList.stream()
                .filter(e -> e.getName().toLowerCase().contains(text.toLowerCase())
                        || e.getDescription().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Event> findById(Long id) {
        return DataHolder.eventsList.stream().filter(e -> e.getId() == id).findFirst();
    }

    public void update(Event event, String name, String description, float popularityScore, Location location) {
        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(location);
    }

    public void add(String name, String description, float popularityScore,Location location){
        DataHolder.eventsList.add(new Event(name,description,popularityScore,location));
    }
    public void deleteById(long id){
        DataHolder.eventsList = DataHolder.eventsList.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
    }

}
