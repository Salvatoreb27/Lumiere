package lumiere.central.controllers;

import java.util.ArrayList;
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

import lumiere.central.model.Attore;
import lumiere.central.services.AttoreService;

@CrossOrigin
@RestController 
@RequestMapping("/lumiere/attori")
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

	@PostMapping("/user/save") 
	public Long saveAttore(@RequestBody Attore attore) {
		Long idAttore = attoreService.addAttore(attore);
		return idAttore;
	}
	
	@PutMapping("/user/update/{id}")
	public Attore updateAttoreById(@PathVariable Long id, @RequestBody Attore attore) {
		Attore a = attoreService.updateAttore(attore, id);
		if (a == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attore non trovato");
		}
		return a;
	}

	@DeleteMapping("/user/delete/{id}")
	public boolean deleteAttoreById(@PathVariable Long id) {
		boolean b = attoreService.deleteAttore(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attore non trovato");
		} 
		return true;
	}
}
