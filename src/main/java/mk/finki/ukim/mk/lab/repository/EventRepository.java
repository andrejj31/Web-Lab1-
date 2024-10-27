package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventRepository {

    public List<Event> findAll(){
            return DataHolder.eventsList;
    }
    public List<Event> searchEvents(String text){
        return DataHolder.eventsList.stream()
                .filter(e -> e.getName().contains(text) || e.getDescription().contains(text))
                .collect(Collectors.toList());
    }


}