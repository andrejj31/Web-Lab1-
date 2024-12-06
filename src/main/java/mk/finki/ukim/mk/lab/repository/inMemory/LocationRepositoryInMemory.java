package mk.finki.ukim.mk.lab.repository.inMemory;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LocationRepositoryInMemory {
    public List<Location> findAll() {
        return DataHolder.locations;
    }

    public Location findById(Long id) {
        return DataHolder.locations.stream().filter(location -> location.getId() == id).findFirst().orElse(null);
    }

    public void deleteById(Long id) {
        DataHolder.eventsList = DataHolder.eventsList.stream().filter(event -> event.location.getId() != id).collect(Collectors.toList());
        DataHolder.locations.removeIf(location -> location.getId() == id);
    }

    public void add(String name, String address, String capacity, String description) {
        DataHolder.locations.add(new Location(name, address, capacity, description));
    }
}