package travel.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travel.beans.TravelPlan;
import travel.repository.TravelPlanRepo;


/**
 * @author Kenneth Nimmo - Knimmo
 * CIS175 - Fall 2023
 * Dec 02, 2023
 */
@Service
public class TravelPlanService {

    @Autowired
    private TravelPlanRepo travelPlanRepository;

    public void createPlan(TravelPlan plan) {

    }

    public TravelPlan getTravelPlanById(Long id) {
        return travelPlanRepository.findById(id).orElse(null);
    }

    public List<TravelPlan> getAllTravelPlans() {
        return travelPlanRepository.findAll();
    }

    public void deleteTravelPlan(long id) {
        travelPlanRepository.deleteById(id);
    }

    public void updateAccess(List<Long> planIds, String accessType, List<String> newUsers) {
        for (Long planId : planIds) {
            Optional<TravelPlan> optionalTravelPlan = travelPlanRepository.findById(planId);
            optionalTravelPlan.ifPresent(travelPlan -> {
                // Update access type
                travelPlan.setAccessType(accessType);

                // Add new users to the list of allowed users for private plans
                if ("private".equalsIgnoreCase(accessType)) {
                    List<String> allowedUsers = travelPlan.getAllowedUsers();
                    if (allowedUsers == null) {
                        allowedUsers = new ArrayList<>();
                    }
                    allowedUsers.addAll(newUsers);
                    travelPlan.setAllowedUsers(allowedUsers);
                }

                // Save the updated plan
                travelPlanRepository.save(travelPlan);
            });
        }
    }
}
