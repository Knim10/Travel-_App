package travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.beans.TravelPlan;

/**
 * @author Kenneth Nimmo - Knimmo
 * CIS175 - Fall 2021
 * Nov 14, 2023
 */
public interface TravelPlanRepo extends JpaRepository<TravelPlan, Long>{

}
