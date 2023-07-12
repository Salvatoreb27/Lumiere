package lumiere.central.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lumiere.central.model.Ruolo;
import lumiere.central.repository.RuoloRepository;

@Service
public class RuoloServiceDB implements RuoloService{
	
	@Autowired 
	private RuoloRepository ruolorepository;

	@Override
	public List<Ruolo> getRuoli() {
		return (List<Ruolo>) ruolorepository.findAll();
	}

	@Override
	public Ruolo getRuolo(Long id) {
		Optional<Ruolo> r = ruolorepository.findById(id);
		if (r.isPresent()) {
			return r.get();
		}
		return null;
	}

	@Override
	public Long addRuolo(Ruolo ruolo) {
		Ruolo r = ruolorepository.save(ruolo);
		return r.getId();
	}

	@Override
	public Ruolo updateRuolo(Ruolo ruolo, Long id) {
			if (ruolorepository.existsById(id)) {
				Ruolo r = ruolorepository.findById(id).get();
				r.setNome(ruolo.getNome());
				r.setUtenti(ruolo.getUtenti());
				ruolorepository.save(r);
				return r;
			}
			return null;
	}

	@Override
	public boolean deleteRuolo(Long id) {
		
		if (ruolorepository.existsById(id)) {
			ruolorepository.deleteById(id);
			return true;
		}
		return false;
	}
}
