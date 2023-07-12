package lumiere.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lumiere.central.model.Utente;

public interface UtenteRepository extends JpaRepository <Utente, Long> {

	Utente findByEmail(String email);
}
