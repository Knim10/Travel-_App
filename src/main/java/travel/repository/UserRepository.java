package travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import travel.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
