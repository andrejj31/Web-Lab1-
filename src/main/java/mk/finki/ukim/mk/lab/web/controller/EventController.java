package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }


    @GetMapping({"", "/"})
    public String getEventsPage(@RequestParam(required = false) String search, @RequestParam(required = false) String rating,@RequestParam(required = false) String error, Model model){
        int ratingInteger = (rating != null && !rating.isEmpty()) ? Integer.parseInt(rating) : 1;
        System.out.println(ratingInteger);
        System.out.println(search);
        if(search != null && !search.isEmpty()) {
            model.addAttribute("search", search);
            model.addAttribute("searchRating", ratingInteger);

            model.addAttribute("events", eventService.filterByRating(ratingInteger, eventService.searchEvents(search)));
            System.out.println(eventService.searchEvents(search));
        }else {
            model.addAttribute("events", eventService.listAll());

        }
        System.out.println(eventService.listAll());
        return "listEvents";
    }
    @GetMapping("/add-form")
    public String addForm(Model model){
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        return "addEvent";
    }
    @GetMapping("/edit-form/{id}")
    public String editForm(@PathVariable("id") long id, Model model) {
        Event event = eventService.findById(id).orElse(null);
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        model.addAttribute("event", event);

        System.out.println(locations);
        return "editEvent";
    }

    // /events/edit/${event.getId()}
    @PostMapping("/edit/{id}")
    public String editEvent(@PathVariable("id") long id,String name, String description, String popularityScore , String location, Model model) {

        Location newLocation = locationService.findById(Long.parseLong(location));
        eventService.update(id, name, description, Float.parseFloat(popularityScore), newLocation);
        return "redirect:/events/";
    }

    @PostMapping("add")
    public String addEvent(String name, String description, String popularityScore,String location, Model model) {
        Location newLocation = locationService.findById(Long.parseLong(location));
        System.out.println(newLocation);
        eventService.add(name, description, Float.parseFloat(popularityScore), newLocation);

        return "redirect:/events/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable String id){
        eventService.deleteById(Long.parseLong(id));
        return "redirect:/events/";
    }
}
