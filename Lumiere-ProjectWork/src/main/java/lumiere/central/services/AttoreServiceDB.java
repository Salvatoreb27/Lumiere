package lumiere.central.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lumiere.central.model.Attore;
import lumiere.central.model.Genere;
import lumiere.central.repository.AttoreRepository;

@Service
public class AttoreServiceDB implements AttoreService{

	@Autowired 
	private AttoreRepository attorerepository;
	
	@Override
	public List<Attore> getAttori() {
		return (List<Attore>) attorerepository.findAll();
	}

	@Override
	public Attore getAttore(Long id) {
		Optional<Attore> a = attorerepository.findById(id);
		if (a.isPresent()) {
			return a.get();
		}
		return null;
	}

	@Override
	public Long addAttore(Attore attore) {
		Attore a = attorerepository.save(attore);
		return a.getId();
	}

	@Override
	public Attore updateAttore(Attore attore, Long id) {
		if (attorerepository.existsById(id)) {
			Attore a = attorerepository.findById(id).get(); //attore sul DB
			a.setNome(attore.getNome());
			attorerepository.save(a);
			return a;
		}
		return null;
	}

	@Override
	public boolean deleteAttore(Long id) {
		if (attorerepository.existsById(id)) {
			attorerepository.deleteById(id);
			return true;
		}
		return false;
	}
	//Da verificare
	public Attore getAttoreByName(String name) {
		Optional<Attore> a = attorerepository.findByAttoreNome(name);
		if (a.isPresent()) {
			return a.get();
		}
		return null;
	}
}
