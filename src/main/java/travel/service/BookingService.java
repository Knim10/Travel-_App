package travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travel.beans.Booking;
import travel.repository.BookingRepository;
import travel.repository.DestinationRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    public void bookTrip(Booking booking) {
        booking.setDestination(destinationRepository.findById(booking.getDestination().getId()).orElse(null));
        bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    
    public void cancelBooking(Long bookingId) {
        // Assuming you have a method in BookingRepository to delete a booking by ID
        bookingRepository.deleteById(bookingId);
    }

	public List<Booking> getUserBookingHistory() {
		// TODO Auto-generated method stub
		return null;
	}

}
