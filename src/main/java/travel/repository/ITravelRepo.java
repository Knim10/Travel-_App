/**
 * @author Tate - tlpadilla
 * CIS175 - Fall 2023
 * Nov 15, 2023
 */
package travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import travel.beans.Destination;

@Repository
public interface ITravelRepo extends JpaRepository<Destination, Long> {
	// Takes the place of helper methods/CRUD methods
}
