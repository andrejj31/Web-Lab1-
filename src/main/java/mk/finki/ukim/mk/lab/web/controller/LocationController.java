package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping({"", "/"})
    public String getLocationsPage(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "locationsList";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable String id){
        locationService.deleteById(Long.parseLong(id));
        return "redirect:/locations/";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        return "addLocation";
    }

    @PostMapping("add")
    public String addEvent(String name, String address, String capacity, String description) {
        locationService.add(name, address, capacity, description);

        return "redirect:/locations/";
    }
}
