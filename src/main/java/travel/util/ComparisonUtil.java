package travel.util;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import travel.beans.Destination;

public class ComparisonUtil {

    public static Destination findCheapestDestination(List<Destination> destinations) {
        return Collections.min(destinations, Comparator.comparingDouble(Destination::getPrice));
    }

    public static Destination findMostExpensiveDestination(List<Destination> destinations) {
        return Collections.max(destinations, Comparator.comparingDouble(Destination::getPrice));
    }

    // Add other comparison methods as needed
}
