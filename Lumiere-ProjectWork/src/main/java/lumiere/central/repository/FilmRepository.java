package lumiere.central.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lumiere.central.model.Film;


public interface FilmRepository extends JpaRepository <Film, Long> {
	
@Query(value= "SELECT F.* FROM film F, genere G, film_genere FG WHERE F.id_film = FG.id_film AND FG.id_genere = G.id_genere AND G.nome = ?1", nativeQuery = true)

List <Film> FindFilmByNameOfGenre (String nome); 

@Query(value= "SELECT F.* FROM film F, attore A, film_attore FA WHERE F.id_film = FA.id_film AND FA.id_genere = A.id_genere AND A.nome = ?1", nativeQuery = true)

List <Film> FindFilmByNameOfActor (String nome); 
	
@Query(value= "SELECT F.*, R.voto FROM film F, recensione R WHERE F.id_film = R.id_film ORDER BY R.voto DESC, F.titolo", nativeQuery = true)

List <Film> OrderFilmByVotoOfRecensione ();

@Query(value= "SELECT F.*, V.numero FROM film F, visualizzazione V WHERE F.id_film = V.id_film ORDER BY V.numero DESC, F.titolo", nativeQuery = true)

List <Film> OrderFilmByNumberOfVisualizzazioni ();


}
