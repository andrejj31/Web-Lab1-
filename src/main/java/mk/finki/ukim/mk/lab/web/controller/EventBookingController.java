package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventBookingController {

    private final EventBookingService eventBookingService;

    public EventBookingController(EventBookingService eventBookingService) {
        this.eventBookingService = eventBookingService;
    }

    @GetMapping("/eventBooking")
    public String getBookings(Model model) {
        model.addAttribute("bookings", DataHolder.bookings);
        return "bookingConfirmation";
    }

    @PostMapping("/eventBooking")
    public String placeBooking(@RequestParam String selectedEvent,
                               @RequestParam String numTickets,
                               HttpServletRequest request, // Capture HttpServletRequest to get the remote address and local name
                               Model model) {
        System.out.println(selectedEvent);

        String remoteAddr = request.getRemoteAddr();

        String localName = request.getLocalName();

        eventBookingService.placeBooking(selectedEvent, localName, remoteAddr, Integer.parseInt(numTickets));

        return "redirect:/eventBooking";
    }
}