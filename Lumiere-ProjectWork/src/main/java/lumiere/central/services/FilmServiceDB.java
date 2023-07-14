package lumiere.central.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lumiere.central.dto.FilmDTO;
import lumiere.central.model.Film;
import lumiere.central.model.Genere;
import lumiere.central.model.Utente;
import lumiere.central.repository.FilmRepository;
import lumiere.central.repository.GenereRepository;

@Service
public class FilmServiceDB implements FilmService{

	@Autowired 
	private FilmRepository filmrepository;

	@Autowired 
	private GenereRepository genererepository;

	@Override
	public List<Film> getFilms() {
		return (List<Film>) filmrepository.findAll();
	}

	@Override
	public Film getFilm(Long id) {
		Optional<Film> f = filmrepository.findById(id);
		if (f.isPresent()) {
			return f.get();
		}
		return null;
	}


	@Override
	public Long addFilm(Film film) {
		Film f = filmrepository.save(film);
		return f.getId();
	}

	@Override
	public Film updateFilm(Film film, Long id) {
		if (filmrepository.existsById(id)) {
			Film f = filmrepository.findById(id).get(); //film sul DB
			f.setTitolo(film.getTitolo());
			f.setRegista(film.getRegista());
			f.setAnno(film.getAnno());
			f.setDurata(film.getDurata());
			f.setPaese(film.getPaese());
			f.setLingua(film.getLingua());
			f.setAttori(film.getAttori());
			f.setGeneri(film.getGeneri());
			f.setRecensioni(film.getRecensioni());
			f.setVisualizzazioni(film.getVisualizzazioni());
			filmrepository.save(f);
			return f;
		}
		return null;

	}
	@Override
	public boolean deleteFilm(Long id) {
		if (filmrepository.existsById(id)) {
			filmrepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Film> getFilmByTitolo(String titolo) {
		List<Film> risultati = new ArrayList<>();

		for (Film film : filmrepository.findAll()) {
			if (film.getTitolo().equalsIgnoreCase(titolo)) {
				risultati.add(film);
			}
		}

		return risultati;
	}

	public List<Film> getFilmByRegista(String regista) {
		List<Film> risultati = new ArrayList<>();

		for (Film film : filmrepository.findAll()) {
			if (film.getRegista().equalsIgnoreCase(regista)) {
				risultati.add(film);
			}
		}

		return risultati;
	}

	public List<Film> getFilmByAnno(Date anno) {
		List<Film> risultati = new ArrayList<>();

		for (Film film : filmrepository.findAll()) {
			if (film.getAnno().equals(anno)) {
				risultati.add(film);
			}
		}

		return risultati;
	}

	public List<Film> getFilmByPaese(String paese) {
		List<Film> risultati = new ArrayList<>();

		for (Film film : filmrepository.findAll()) {
			if (film.getPaese().equalsIgnoreCase(paese)) {
				risultati.add(film);
			}
		}

		return risultati;
	}
	//Avere tutti i film in base al genere 1
	public List<Film> getAllFilmsByGenere(Genere genere) {
		List<Film> risultati = new ArrayList<>();

		for (Film film : filmrepository.findAll()) {
			if (film.getGeneri().contains(genere)) {
				risultati.add(film);
			}
		}

		return risultati;
	}
	//Avere tutti i film in base al genere 2

	public Set<Film> getAllFilmsByNameofGenere(String nome) { 
		Set<Film> risultati = new HashSet<>();
		for (Film film : filmrepository.findAll()) {
			
				if (film.getGeneri().contains(nome)) {
					risultati.add(film);
				}

			}
		return risultati;
	}

	public Set<Film> getAllFilmsByNameofGenere3(String nome) { 
		Optional<Genere> genere = genererepository.findByGenereNome(nome);
		Set<Film> risultati = new HashSet<>();
		for (Film film : filmrepository.findAll()) {
			if (film.getGeneri().contains(genere)) {

				risultati.add(film);
			}
		}

		return risultati;
	}
	public List <FilmDTO> getAllFilmsByNameofGenere4(String nome) {
		List <Film> films = filmrepository.findAll();
		List <FilmDTO> filmsDTO = new ArrayList <>();
		for (Film film: films) {
			FilmDTO filmDTO = new FilmDTO();
			filmDTO.setGeneri(film.getGeneri());
			filmsDTO.add(filmDTO);

		}
		return filmsDTO;
	}
	public Set<Film> getAllFilmsByNameofAttore(String nome) {
		return null;
}
}
