package travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import travel.beans.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

}
    
