package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {
    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        EventBooking newBooking = new EventBooking(eventName,attendeeName,attendeeAddress,numberOfTickets);
        DataHolder.bookings.add(newBooking);
        return newBooking;
    }
}
