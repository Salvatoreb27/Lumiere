package lumiere.central.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lumiere.central.model.Film;
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

}
