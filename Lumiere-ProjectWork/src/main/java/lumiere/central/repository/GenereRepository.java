package lumiere.central.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lumiere.central.model.Genere;

public interface GenereRepository extends JpaRepository <Genere, Long> {

	Optional<Genere> findByGenereNome (String nome);
}
