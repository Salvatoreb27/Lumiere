package lumiere.central.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lumiere.central.dto.FilmDTO;
import lumiere.central.model.Film;
import lumiere.central.services.FilmService;

@CrossOrigin
@RestController 
@RequestMapping("/lumiere/films")
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
			filmDTO.setTitolo(film.getTitolo());
			filmDTO.setAnno(film.getAnno());
			filmDTO.setDurata(film.getDurata());
			filmDTO.setRegista(film.getRegista());
			filmDTO.setPaese(film.getPaese());
			filmDTO.setLingua(film.getLingua());
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

}


