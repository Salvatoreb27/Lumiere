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

import lumiere.central.model.Ruolo;
import lumiere.central.services.RuoloService;

@CrossOrigin
@RestController 
@RequestMapping("/lumiere/ruoli")
public class RuoloController {

	@Autowired
	private RuoloService ruoloService; 
	
	@GetMapping("/all")
	public List<Ruolo> getAllRuoli() {
		return ruoloService.getRuoli();
	}
	
	@GetMapping("/{id}")
	public Ruolo getRuoloById(@PathVariable Long id) {
		Ruolo ruolo = ruoloService.getRuolo(id);
		if (ruolo == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruolo non trovato");
		}
		return ruolo;
	}

	@PostMapping("/ruolofunct/save") 
	public Long saveRuolo(@RequestBody Ruolo ruolo) {
		Long idRuolo = ruoloService.addRuolo(ruolo);
		return idRuolo;
	}
	
	@PutMapping("/ruolofunct/update/{id}")
	public Ruolo updateRuoloById(@PathVariable Long id, @RequestBody Ruolo ruolo) {
		Ruolo a = ruoloService.updateRuolo(ruolo, id);
		if (a == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruolo non trovato");
		}
		return a;
	}

	@DeleteMapping("/ruolofunct/delete/{id}")
	public boolean deleteRuoloById(@PathVariable Long id) {
		boolean b = ruoloService.deleteRuolo(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruolo non trovato");
		} 
		return true;
	}
}
