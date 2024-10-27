package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> eventsList;
    public static EventBooking booking;
    @PostConstruct
    public void init(){
        eventsList = new ArrayList<>();

        eventsList.add(new Event("Koncert", "Muzički nastan vo gradskiot park", 4.5));
        eventsList.add(new Event("Teatarska predstava", "Drama za ljubov i zaguba", 4.0));
        eventsList.add(new Event("Sportski nastan", "Futbalski natprevar", 3.8));
        eventsList.add(new Event("Festival", "Godišen kulturni festival", 4.2));
        eventsList.add(new Event("Izložba", "Umetnička izložba na lokalni umetnici", 4.3));
        eventsList.add(new Event("Konferencija", "Konferencija za inovacii", 4.6));
        eventsList.add(new Event("Seminar", "Obrazoven seminar za mladi", 3.9));
        eventsList.add(new Event("Koncert na klasična muzika", "Nastan so orkestar", 4.7));
        eventsList.add(new Event("Kino", "Prikaz na nov film", 4.1));
        eventsList.add(new Event("Muzicki festival", "Festival na pop i rok muzika", 4.4));



    }
}
