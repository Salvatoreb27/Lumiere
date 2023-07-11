package lumiere.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lumiere.central.model.Amico;

public interface AmicoRepository extends JpaRepository <Amico, Long> {

}
