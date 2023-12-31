package lumiere.central.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lumiere.central.dto.FilmDTO;
import lumiere.central.dto.FilmDTO2;
import lumiere.central.model.Film;
import lumiere.central.services.FilmService;

@CrossOrigin
@RestController 
@RequestMapping("/api/v1/lumiere/films")
public class FilmController {

	@Autowired
	private FilmService filmService; 
	
	@GetMapping("/all")
	/*public List<Film> getAllFilms() {
		return filmService.getFilms();
	}*/
	public List <FilmDTO> getAllFilms() {
		List <Film> films = filmService.getFilms();
		List <FilmDTO> filmsDTO = new ArrayList <>();
		for (Film film: films) {
			FilmDTO filmDTO = new FilmDTO();
			filmDTO.setId(film.getId());
			filmDTO.setTrama(film.getTrama());
			filmDTO.setLocandina(film.getLocandina());
			filmDTO.setTitolo(film.getTitolo());
			filmDTO.setAnno(film.getAnno());
			filmDTO.setDurata(film.getDurata());
			filmDTO.setRegista(film.getRegista());
			filmDTO.setPaese(film.getPaese());
			filmDTO.setLingua(film.getLingua());
			filmDTO.setAttori(film.getAttori());
			filmDTO.setGeneri(film.getGeneri());
			filmDTO.setRecensioni(film.getRecensioni());
			filmDTO.setVisualizzazioni(film.getVisualizzazioni());
			filmsDTO.add(filmDTO);
		}
		return filmsDTO;
	}

	@GetMapping("/{id}")
	public Film getFilmById(@PathVariable Long id) {
		Film film = filmService.getFilm(id);
		if (film == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trovato");
		}
		return film;
	}
	@GetMapping("/titolo/{titolo}")
	public List<Film> getFilmsByTitolo(@PathVariable String titolo) {
		List<Film> film = filmService.getFilmByTitolo(titolo);
		if (film == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trovato");
		}
		return film;
	}
	@GetMapping("/genere/{nomeGenere}")
	public List <Film> getFilmsByGenere(@PathVariable String nomeGenere) {
		List<Film> film = filmService.getAllFilmsByNameOfGenere(nomeGenere);
		if (film == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessun film trovato per questo genere");
		}
		return film;
	}
	@GetMapping("/attore/{nomeAttore}")
	public List <Film> getFilmsByAttore(@PathVariable String nomeAttore) {
		List<Film> film = filmService.getAllFilmsByNameOfAttore(nomeAttore);
		if (film == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessun film disponibile in cui recita questo attore");
		}
		return film;
	}
	@GetMapping("/voti/BestVotes")
	public List <Film> getFilmsWithBestVotes() {
		List<Film> film = filmService.getAllFilmsByVotoOfRecensioni();
		if (film == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessun film è stato ancora recensito");
		}
		return film;
	}
	@GetMapping("/regista/{nomeRegista}")
	public List <Film> getFilmsByRegista(@PathVariable String nomeRegista) {
		List<Film> film = filmService.getFilmByRegista(nomeRegista);
		if (film == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessun film disponibile diretto da questo regista");
		}
		return film;
	}
	@GetMapping("/paese/{nomePaese}")
	public List <Film> getFilmsByPaese(@PathVariable String nomePaese) {
		List<Film> film = filmService.getFilmByPaese(nomePaese);
		if (film == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessun film disponibile girato in questo paese");
		}
		return film;
	}
	//Chiedere: ma quindi in questo modo riusciamo a risalire solo ai film rilasciati solo un determinato giorno?
	@GetMapping("/anno/{anno}")
	public List <Film> getFilmsByAnno(@PathVariable Date anno) {
		List<Film> film = filmService.getFilmByAnno(anno);
		if (film == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessun film disponibile girato in questo anno");
		}
		return film;
	}
	@GetMapping("/lingua/{lingua}")
	public List <Film> getFilmsByLingua(@PathVariable String lingua) {
		List<Film> film = filmService.getFilmByLingua(lingua);
		if (film == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessun film disponibile in questa lingua");
		}
		return film;
	}
	//Aggiunta di film ---> Admin
		@PostMapping("/film/addFilm") 
		public Long saveFilm(@RequestBody Film film) {
			Long idFilm = filmService.addFilm(film);
			return idFilm;
		}
		//Aggiunta di film ---> Admin
				@PostMapping("/film/addFilm2") 
				public Long saveFilm2(@RequestBody FilmDTO2 film) {
					Film f = new Film();
					f.setTitolo(film.getTitolo());
					f.setAnno(film.getAnno());
					f.setDurata(film.getDurata());
					f.setRegista(film.getRegista());
					f.setPaese(film.getPaese());
					f.setLingua(film.getLingua());
					Long idFilm = filmService.addFilm(f);
					return idFilm;
				}

}


