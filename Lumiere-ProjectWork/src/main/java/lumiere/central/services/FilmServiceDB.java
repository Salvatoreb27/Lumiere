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
			Optional<Film> a = filmrepository.findById(id);
			if (a.isPresent()) {
				return a.get();
			}
			return null;
	}

		
	@Override
	public Integer addFilm(Film film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film updateFilm(Film film, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteFilm(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
