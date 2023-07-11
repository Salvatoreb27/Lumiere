package lumiere.central.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import lumiere.central.model.Ruolo;
import lumiere.central.repository.RuoloRepository;

public class RuoloServiceDB implements RuoloService{
	
	@Autowired 
	private RuoloRepository ruolirepository;

	@Override
	public List<Ruolo> getRuoli() {
		return (List<Ruolo>) ruolirepository.findAll();
	}

	@Override
	public Ruolo getRuolo(Long id) {
		Optional<Ruolo> r = ruolirepository.findById(id);
		if (r.isPresent()) {
			return r.get();
		}
		return null;
	}

	@Override
	public Long addRuolo(Ruolo ruolo) {
		Ruolo r = ruolirepository.save(ruolo);
		return r.getId();
	}

	@Override
	public Ruolo updateRuolo(Ruolo ruolo, Long id) {
			if (ruolirepository.existsById(id)) {
				Ruolo r = ruolirepository.findById(id).get();
				r.setNome(ruolo.getNome());
				r.setUtenti(ruolo.getUtenti());
				ruolirepository.save(r);
				return r;
			}
			return null;
	}

	@Override
	public boolean deleteRuolo(Long id) {
		
		if (ruolirepository.existsById(id)) {
			ruolirepository.deleteById(id);
			return true;
		}
		return false;
	}
}
