package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.repository.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> eventsList;
    public static List<EventBooking> bookings;
    public static List<Location> locations;
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public DataHolder(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @PostConstruct
    public void init(){
        eventsList = new ArrayList<>();
        bookings = new ArrayList<>();
        locations = new ArrayList<>();

           // public Location(String name, String address, String capacity, String description) {
        locations.add(new Location("US", "New York", "800", "A bustling city with diverse culture"));
        locations.add(new Location("GB", "London", "300", "Historic city with iconic landmarks"));
        locations.add(new Location("FR", "Paris", "450", "Known for its art, fashion, and landmarks"));
        locations.add(new Location("DE", "Berlin", "600", "A city with a rich history and modern architecture"));

        eventsList.add(new Event("Koncert", "Muzički nastan vo gradskiot park", 4.5, locations.get(0)));
        eventsList.add(new Event("Teatarska predstava", "Drama za ljubov i zaguba", 4.0, locations.get(1)));
        eventsList.add(new Event("Sportski nastan", "Futbalski natprevar", 3.8, locations.get(3)));
        eventsList.add(new Event("Festival", "Godišen kulturni festival", 4.2, locations.get(2)));
        eventsList.add(new Event("Izložba", "Umetnička izložba na lokalni umetnici", 4.3, locations.get(3)));
        eventsList.add(new Event("Konferencija", "Konferencija za inovacii", 4.6, locations.get(0)));
        eventsList.add(new Event("Seminar", "Obrazoven seminar za mladi", 3.9, locations.get(2)));
        eventsList.add(new Event("Koncert na klasična muzika", "Nastan so orkestar", 4.7, locations.get(1)));
        eventsList.add(new Event("Kino", "Prikaz na nov film", 4.1, locations.get(2)));
        eventsList.add(new Event("Muzicki festival", "Festival na pop i rok muzika", 4.4, locations.get(3)));

        locationRepository.saveAll(locations);
        eventRepository.saveAll(eventsList);


    }
}
