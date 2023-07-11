package lumiere.central.services;

import java.util.List;

import lumiere.central.model.Film;

public interface FilmService {

	//visualizzazione di tutti i film
		List<Film> getFilms();
		//visualizzazione di un film specifico
		Film getFilm(Long id);
		//inserimento di un nuovo film
		Integer addFilm(Film film);
		//modifica di un film esistente
		Film updateFilm(Film film, Long id);
		//cancellazione di un film esistente
		boolean deleteFilm(Long id);
}
