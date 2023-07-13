package lumiere.central.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lumiere.central.model.Ruolo;
import lumiere.central.services.RuoloService;

@CrossOrigin
@RestController 
@RequestMapping("/api/v1/lumiere/ruoli")
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
}
