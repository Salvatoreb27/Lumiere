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

import lumiere.central.model.Genere;
import lumiere.central.services.GenereService;

@CrossOrigin
@RestController 
@RequestMapping("/api/v1/lumiere/generi")
public class GenereController {

	@Autowired
	private GenereService genereService; 
	
	@GetMapping("/all")
	public List<Genere> getAllGeneri() {
		return genereService.getGeneri();
	}
	
	@GetMapping("/{id}")
	public Genere getGenereById(@PathVariable Long id) {
		Genere genere = genereService.getGenere(id);
		if (genere == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genere non trovato");
		}
		return genere;
	}

}
