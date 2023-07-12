package lumiere.central.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import lumiere.central.model.Visualizzazione;
import lumiere.central.repository.VisualizzazioneRepository;

public class VisualizzazioneServiceDB implements VisualizzazioneService{

	@Autowired 
	private VisualizzazioneRepository visualizzazionerepository;
	
	@Override
	public List<Visualizzazione> getVisualizzazioni() {
		return (List<Visualizzazione>) visualizzazionerepository.findAll();
		}

	@Override
	public Visualizzazione getVisualizzazione(Long id) {
		Optional<Visualizzazione> v = visualizzazionerepository.findById(id);
		if (v.isPresent()) {
			return v.get();
		}
		return null;
	}

	@Override
	public Long addVisualizzazione(Visualizzazione visualizzazione) {
		Visualizzazione v = visualizzazionerepository.save(visualizzazione);
		return v.getId();
	}

	@Override
	public Visualizzazione updateVisualizzazione(Visualizzazione visualizzazione, Long id) {
		if (visualizzazionerepository.existsById(id)) {
			Visualizzazione v = visualizzazionerepository.findById(id).get();
			v.setData(visualizzazione.getData());
			v.setNumero(visualizzazione.getNumero());
			v.setFilms(visualizzazione.getFilms());
			v.setUtenti(visualizzazione.getUtenti());
			visualizzazionerepository.save(v);
			return v;
		}
		return null;
}

	@Override
	public boolean deleteVisualizzazione(Long id) {
		
		if (visualizzazionerepository.existsById(id)) {
			visualizzazionerepository.deleteById(id);
			return true;
		}
		return false;
	}
}
