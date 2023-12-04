package travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travel.beans.Destination;
import travel.repository.DestinationRepository;

import java.util.List;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public Destination getDestinationById(Long id) {
        return destinationRepository.findById(id).orElse(null);
    }

    public Destination saveDestination(Destination destination) {
        // Additional business logic, validation, etc. can be added before saving
        return destinationRepository.save(destination);
    }

    public Destination updateDestination(Long id, Destination updatedDestination) {
        // Check if the destination with the given id exists
        Destination existingDestination = destinationRepository.findById(id).orElse(null);

        if (existingDestination != null) {
            // Update the fields of the existing destination
            //existingDestination.setName(updatedDestination.getName());
            existingDestination.setLocation(updatedDestination.getLocation());
            existingDestination.setPrice(updatedDestination.getPrice());
            existingDestination.setRating(updatedDestination.getRating());
            existingDestination.setDetails(updatedDestination.getDetails());
            existingDestination.setAmenities(updatedDestination.getAmenities());

            // Save the updated destination
            return destinationRepository.save(existingDestination);
        }

        return null; // Or throw an exception indicating that the destination does not exist
    }

    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }

    
}
