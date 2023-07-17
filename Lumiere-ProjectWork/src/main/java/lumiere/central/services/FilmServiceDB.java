package lumiere.central.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lumiere.central.model.Attore;
import lumiere.central.model.Film;
import lumiere.central.model.Genere;
import lumiere.central.model.Recensione;
import lumiere.central.repository.FilmRepository;


@Service
public class FilmServiceDB implements FilmService{

	@Autowired 
	private FilmRepository filmrepository;


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
			f.setLingue(film.getLingue());
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
	/*public List<Film> getAllFilmsByGenere(Genere genere) {
		List<Film> risultati = new ArrayList<>();

		for (Film film : filmrepository.findAll()) {
			if (film.getGeneri().contains(genere)) {
				risultati.add(film);
			}
		}

		return risultati;
	}
	//Avere tutti i film in base al nome del genere metodo definitivo
	public List<Film> getAllFilmsByNameOfGenere(String nome) {
		List<Film> risultati = new ArrayList<>();

		for (Film film : filmrepository.findAll()) {
			for (Genere genere : film.getGeneri()) {
				if (genere.getNome() == nome) {
					risultati.add(film);
				}
			}
		}

		return risultati;
	}
	public List<Film> getAllFilmsByNameOfAttore(String nome) {
		List<Film> risultati = new ArrayList<>();

		for (Film film : filmrepository.findAll()) {
			for (Attore attore : film.getAttori()) {
				if (attore.getNome() == nome) {
					risultati.add(film);
				}
			}
		}

		return risultati;
	}
	public List<Film> getAllFilmsByVotoOfRecensioni() {
		List<Film> risultati = new ArrayList<>();

		for (Film film : filmrepository.findAll()) {
			for (Recensione recensione : film.getRecensioni()) {
				risultati.add(film);


			}
		}

		return risultati;
	}*/

	@Override
	public List<Film> getFilmByLingua(String lingua) {
		List<Film> risultati = new ArrayList<>();

		for (Film film : filmrepository.findAll()) {
			for ( String linguaDisponibile : film.getLingue()) {
				if (linguaDisponibile == lingua) {
					risultati.add(film);
				}
			}
		}

		return risultati;
	}
	//Avere tutti i film in base al nome del genere
	public List<Film> getAllFilmsByNameOfGenere(String nome) {
		return filmrepository.FindFilmByNameOfGenre(nome);
	}
	//Avere tutti i film in base al nome del genere
	public List<Film> getAllFilmsByNameOfAttore(String nome) {
		return filmrepository.FindFilmByNameOfActor(nome);
	}
	//Ordinare tutti i film in base al voto delle recensioni
	public List<Film> getAllFilmsByVotoOfRecensioni() {
		return filmrepository.OrderFilmByVotoOfRecensione();
	}
	//Ordinare tutti i film in base al numero di visualizzazioni
	public List<Film> getAllFilmsByNumberOfVisualizzazioni() {
		return filmrepository.OrderFilmByNumberOfVisualizzazioni();
	}

}
