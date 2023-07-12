package lumiere.central.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import lumiere.central.model.Recensione;
import lumiere.central.repository.RecensioneRepository;

public class RecensioneServicesDB implements RecensioneService{
	
	@Autowired 
	private RecensioneRepository recensionerepository;

	@Override
	public List<Recensione> getRecensioni() {
		return (List<Recensione>) recensionerepository.findAll();
	}

	@Override
	public Recensione getRecensione(Long id) {
		Optional<Recensione> rc = recensionerepository.findById(id);
		if (rc.isPresent()) {
			return rc.get();
		}
		return null;
	}

	@Override
	public Long addRecensione(Recensione recensione) {
		Recensione rc = recensionerepository.save(recensione);
		return rc.getId();
	}

	@Override
	public Recensione updateRecensione(Recensione recensione, Long id) {
		if (recensionerepository.existsById(id)) {
			Recensione rc = recensionerepository.findById(id).get();
			rc.setData(recensione.getData());
			rc.setVoto(recensione.getVoto());
			rc.setTesto(recensione.getTesto());
			rc.setPubblico(recensione.getPubblico());
			rc.setFilms(recensione.getFilms());
			rc.setUtenti(recensione.getUtenti());

			recensionerepository.save(rc);
			return rc;
		}
		return null;
}

	@Override
	public boolean deleteRecensione(Long id) {
		if (recensionerepository.existsById(id)) {
			recensionerepository.deleteById(id);
			return true;
		}
		return false;
	}
}
