package nl.novi.techiteasy1121.repositories;

import nl.novi.techiteasy1121.models.PassengerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerProfileRepository extends JpaRepository<PassengerProfile, Long> {
}
