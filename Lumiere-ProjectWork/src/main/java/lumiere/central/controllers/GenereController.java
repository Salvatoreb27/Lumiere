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
@RequestMapping("/lumiere/generi")
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

	@PostMapping("/user/save") 
	public Long saveGenere(@RequestBody Genere genere) {
		Long idGenere = genereService.addGenere(genere);
		return idGenere;
	}
	
	@PutMapping("/user/update/{id}")
	public Genere updateGenereById(@PathVariable Long id, @RequestBody Genere genere) {
		Genere a = genereService.updateGenere(genere, id);
		if (a == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genere non trovato");
		}
		return a;
	}

	@DeleteMapping("/user/delete/{id}")
	public boolean deleteGenereById(@PathVariable Long id) {
		boolean b = genereService.deleteGenere(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genere non trovato");
		} 
		return true;
	}
}
