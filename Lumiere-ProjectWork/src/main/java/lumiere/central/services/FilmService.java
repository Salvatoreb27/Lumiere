package lumiere.central.services;

import java.sql.Date;
import java.util.List;

import lumiere.central.model.Film;

public interface FilmService {

	//visualizzazione di tutti i film
		List<Film> getFilms();
		//visualizzazione di un film specifico
		Film getFilm(Long id);
		//inserimento di un nuovo film
		Long addFilm(Film film);
		//modifica di un film esistente
		Film updateFilm(Film film, Long id);
		//cancellazione di un film esistente
		boolean deleteFilm(Long id);
		//Visualizzazione di un film ricercando il titolo
		public List<Film> getFilmByTitolo(String titolo);
		//Visualizzazione di un film ricercando il regista
		public List<Film> getFilmByRegista(String regista);
		//Visualizzazione di un film ricercando l'anno
		public List<Film> getFilmByAnno(Date anno);
		//Visualizzazione di un film ricercando il paese
		public List<Film> getFilmByPaese(String paese);
		//Visualizzazione di tutti i film in base al nome di un genere
		public List<Film> getAllFilmsByNameOfGenere(String nome);
		//Visualizzazione di tutti i film in base al nome di un attore
		public List<Film> getAllFilmsByNameOfAttore(String nome);
		//Visualizzazione di tutti i film ordinati per voto delle recensioni
		public List<Film> getAllFilmsByVotoOfRecensioni();
		//Visualizzazione di tutti i film in base alla lingua disponibile
		public List<Film> getFilmByLingua(String lingua);
}
