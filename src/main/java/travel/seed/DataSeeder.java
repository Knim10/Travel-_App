package travel.seed;

import java.util.ArrayList;
import java.util.List;
import travel.beans.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import travel.repository.DestinationRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DataSeeder {

    @Autowired
    private DestinationRepository destinationRepository;

    @PostConstruct
    public void seedData() {
        // Check if data already exists
        if (destinationRepository.count() == 0) {
            // Seed data only if the destination repository is empty

            // Create sample destinations
            List<Destination> destinations = new ArrayList<>();
            destinations.add(new Destination("Paris", "France", 1000, "City of Love", 10, "amenities"));
            destinations.add(new Destination("Tokyo", "Japan", 1500, "Vibrant Metropolis", 8, "amenities"));
            destinations.add(new Destination("New York", "USA", 1200, "The Big Apple", 7.8, "amenities"));

            // Save destinations to the database
            destinationRepository.saveAll(destinations);
        }
    }
}
