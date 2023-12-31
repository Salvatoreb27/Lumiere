package lumiere.central.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lumiere.central.model.Attore;
import lumiere.central.services.AttoreService;

@CrossOrigin
@RestController 
@RequestMapping("/api/v1/lumiere/attori")
public class AttoreController {

	@Autowired
	private AttoreService attoreService; 
	
	@GetMapping("/all")
	public List<Attore> getAllAttori() {
		return attoreService.getAttori();
	}
	
	@GetMapping("/{id}")
	public Attore getAttoreById(@PathVariable Long id) {
		Attore attore = attoreService.getAttore(id);
		if (attore == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attore non trovato");
		}
		return attore;
	}

	
}
