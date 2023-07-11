package lumiere.central.services;

import java.util.List;

import lumiere.central.model.Visualizzazione;

public interface VisualizzazioneService {

	List<Visualizzazione> getVisualizzazioni();
	
	Visualizzazione getVisualizzazione(Long id);
	
	Long addVisualizzazione(Visualizzazione visualizzazione);
	
	Visualizzazione updateVisualizzazione(Visualizzazione visualizzazione, Long id);
	
	boolean deleteVisualizzazione(Long id);
}
