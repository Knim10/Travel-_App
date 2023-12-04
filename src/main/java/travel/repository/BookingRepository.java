package travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import travel.beans.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	 // Custom query to find bookings by destination ID
    @Query("SELECT b FROM Booking b WHERE b.destination.id = :destinationId")
    List<Booking> findByDestinationId(@Param("destinationId") Long destinationId);
}