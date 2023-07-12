package lumiere.central.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lumiere.central.model.Visualizzazione;
import lumiere.central.services.VisualizzazioneService;

@CrossOrigin
@RestController 
@RequestMapping("/lumiere/visualizzazioni")
public class VisualizzazioneController {

	@Autowired
	private VisualizzazioneService visualizzazioneService; 
	
	@GetMapping("/all")
	public List<Visualizzazione> getAllVisualizzazioni() {
		return visualizzazioneService.getVisualizzazioni();
	}
	
	@GetMapping("/{id}")
	public Visualizzazione getVisualizzazioneById(@PathVariable Long id) {
		Visualizzazione visualizzazione = visualizzazioneService.getVisualizzazione(id);
		if (visualizzazione == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Visualizzazione non trovato");
		}
		return visualizzazione;
	}

	@PostMapping("/visualizzazionefunct/save") 
	public Long saveVisualizzazione(@RequestBody Visualizzazione visualizzazione) {
		Long idVisualizzazione = visualizzazioneService.addVisualizzazione(visualizzazione);
		return idVisualizzazione;
	}
	
	@PutMapping("/visualizzazionefunct/update/{id}")
	public Visualizzazione updateVisualizzazioneById(@PathVariable Long id, @RequestBody Visualizzazione visualizzazione) {
		Visualizzazione a = visualizzazioneService.updateVisualizzazione(visualizzazione, id);
		if (a == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Visualizzazione non trovato");
		}
		return a;
	}

	@DeleteMapping("/visualizzazionefunct/delete/{id}")
	public boolean deleteVisualizzazioneById(@PathVariable Long id) {
		boolean b = visualizzazioneService.deleteVisualizzazione(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Visualizzazione non trovato");
		} 
		return true;
	}
}
