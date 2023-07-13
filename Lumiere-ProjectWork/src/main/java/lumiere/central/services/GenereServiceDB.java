package lumiere.central.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lumiere.central.model.Genere;
import lumiere.central.repository.GenereRepository;

@Service
public class GenereServiceDB implements GenereService {

	@Autowired 
	private GenereRepository genererepository;
	
	@Override
	public List<Genere> getGeneri() {
		return (List<Genere>) genererepository.findAll();
	}

	@Override
	public Genere getGenere(Long id) {
			Optional<Genere> g = genererepository.findById(id);
			if (g.isPresent()) {
				return g.get();
			}
			return null;
	}

	@Override
	public Long addGenere(Genere genere) {
		Genere g = genererepository.save(genere);
		return g.getId();
	}

	@Override
	public Genere updateGenere(Genere genere, Long id) {
		if (genererepository.existsById(id)) {
			Genere g = genererepository.findById(id).get(); //genere sul DB
			g.setNome(genere.getNome());
			genererepository.save(g);
			return g;
		}
		return null;
	}

	@Override
	public boolean deleteGenere(Long id) {
		if (genererepository.existsById(id)) {
			genererepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	//Da verificare
	public Genere getGenereByName(String name) {
		Optional<Genere> g = genererepository.findByNome(name);
		if (g.isPresent()) {
			return g.get();
		}
		return null;
	}

}
