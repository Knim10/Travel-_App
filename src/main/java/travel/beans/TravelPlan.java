package travel.beans;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Kenneth Nimmo - Knimmo
 * CIS175 - Fall 2023
 * Nov 14, 2023
 */
@Data
@NoArgsConstructor
@Entity
public class TravelPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//@NotNull(message = "Must contain data")
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Destination> destinations = new ArrayList<Destination>();
	//@NotNull(message = "Must contain data")
	private double planPrice;
	//@NotNull(message = "Must contain data")
	private boolean isPrivate;
	//@NotNull(message = "Must contain data")
	private double avgRating;
	//@NotNull(message = "Must contain data")
	//private List<User> allowedUser;
	//@NotNull(message = "Must contain data")
	private String name;

	public TravelPlan(List<Destination> destinations, boolean isPrivate) {
		this.destinations = destinations;
		this.isPrivate = isPrivate;
		setPlanPrice();
	}

	public void setPlanPrice() {
		int price = 0;
		for(int i = 0; i < destinations.size(); i++) {
			price += destinations.get(i).getPrice();
		}
		this.planPrice = price;
	}

	public void setAvgRating() {
		int rating = 0;
		for(int i = 0; i < destinations.size(); i++) {
			rating += destinations.get(i).getRating();
		}
		rating = rating / destinations.size();
		this.avgRating = rating;
	}

	/**
	 * @param accessType
	 */
	public void setAccessType(String accessType) {
		if(accessType.equalsIgnoreCase("PRIVATE")) {
			this.isPrivate = true;
		}
		else {
			this.isPrivate = false;
		}
		
	}

	/**
	 * @return
	 */
	public List<String> getAllowedUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param allowedUsers
	 */
	public void setAllowedUsers(List<String> allowedUsers) {
		// TODO Auto-generated method stub
		
	}

}
