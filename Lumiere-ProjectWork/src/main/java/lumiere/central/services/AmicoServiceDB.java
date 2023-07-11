package lumiere.central.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lumiere.central.model.Amico;
import lumiere.central.repository.AmicoRepository;

@Service
public class AmicoServiceDB implements AmicoService {
	
	@Autowired 
	private AmicoRepository amicorepository;
	
	@Override
	public List<Amico> getAmici() {
		return (List<Amico>) amicorepository.findAll();
	}

	@Override
	public Amico getAmico(Long id) {
		Optional<Amico> a = amicorepository.findById(id);
		if (a.isPresent()) {
			return a.get();
		}
		return null;
	}

	@Override
	public Long addAmico(Amico amico) {
			Amico a = amicorepository.save(amico);
			return a.getId();
	}

	@Override
	public boolean deleteAmico(Long id) {
		if (amicorepository.existsById(id)) {
			amicorepository.deleteById(id);
			return true;
		}
		return false;
	}

}
