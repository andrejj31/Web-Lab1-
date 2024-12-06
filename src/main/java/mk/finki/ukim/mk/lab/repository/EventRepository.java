package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByNameContainingOrDescriptionContaining(String name, String description);
    List<Event> findAllByLocation_id(Long locationId);
//    void deleteAllByLocation_id(Long locationId);
    void deleteAllByLocation_id(Long locationId);
    List<Event> findByPopularityScoreGreaterThan(int popularityScore);
}
