package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import travel.beans.Destination;

import travel.beans.Booking;
import travel.service.BookingService;
import travel.service.DestinationService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private DestinationService destinationService;
    
    @GetMapping("/bookings/{id}")
    public String showBookingConfirmation(@PathVariable Long id, Model model) {
        // Retrieve booking details by ID
        Booking booking = bookingService.getBookingById(id);

        if (booking != null) {
            model.addAttribute("booking", booking);
            return "bookingConfirmation";
        } else {
            // Handle not found scenario
            return "redirect:/"; // Redirect to the home page
        }
    }
    
    @GetMapping("/book")
    public String showBookingForm(Model model) {
        // Retrieve available destinations for the form
        List<Destination> destinations = destinationService.getAllDestinations();
        model.addAttribute("destinations", destinations);

        // Create a new Booking object to bind form data
        model.addAttribute("booking", new Booking());

        return "bookingForm";
    }
    
    @PostMapping("/book")
    public String submitBookingForm(@ModelAttribute("booking") Booking booking) {
        // Process the booking and save to the database using BookingService
        bookingService.bookTrip(booking);

        // Redirect to the booking confirmation page
        return "redirect:/bookings/" + booking.getId();
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }
    

    
}
