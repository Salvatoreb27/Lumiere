package lumiere.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import lumiere.central.model.Film;


public interface FilmRepository extends JpaRepository <Film, Long> {

}
