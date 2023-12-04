/**
 * @author Tate - tlpadilla
 * CIS175 - Fall 2023
 * Nov 15, 2023
 */
package travel.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Destination {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//@NotNull(message = "Must contain data")
	private String name;
	//@NotNull(message = "Must contain data")
	private String location;
	//@NotNull(message = "Must contain data")
	private double price;
	//@NotNull(message = "Must contain data")
	private double rating;
	//@NotNull(message = "Must contain data")
	private String details;
	//@NotNull(message = "Must contain data")
	private String amenities;

	public Destination(String name, String location, double price, String description, double rating, String amenities) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.details = description;
		this.rating = rating;
		this.amenities = amenities;
    }
}
