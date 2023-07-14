package lumiere.central.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lumiere.central.model.Attore;
import lumiere.central.model.Film;
import lumiere.central.model.Genere;

public interface FilmRepository extends JpaRepository <Film, Long> {

	Optional<Film> findByGenere (Genere genere);
	Optional<Film> findByAttore (Attore attore);
	Optional<Film> findByAnno (Date anno);
	Optional<Film> findByTitolo (String titolo);
	Optional<Film> findByPaese (String paese);
}
