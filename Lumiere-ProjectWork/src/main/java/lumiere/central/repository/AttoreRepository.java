package lumiere.central.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lumiere.central.model.Attore;

public interface AttoreRepository extends JpaRepository <Attore, Long> {

	
}
