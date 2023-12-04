package travel.util;

import java.util.List;
import java.util.stream.Collectors;

import travel.beans.Destination;

public class SearchUtil {

    public static List<Destination> searchByLocation(List<Destination> destinations, String location) {
        return destinations.stream()
                .filter(destination -> destination.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    public static List<Destination> searchByPriceRange(List<Destination> destinations, double minPrice, double maxPrice) {
        return destinations.stream()
                .filter(destination -> destination.getPrice() >= minPrice && destination.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    // Add other search methods as needed
}
