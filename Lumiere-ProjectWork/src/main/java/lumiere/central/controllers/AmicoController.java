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

import lumiere.central.model.Amico;
import lumiere.central.services.AmicoService;

@CrossOrigin
@RestController 
@RequestMapping("/api/v1/amici")
public class AmicoController {

	@Autowired
	private AmicoService amicoService; 
	
	@GetMapping("/all")
	public List<Amico> getAllAmici() {
		return amicoService.getAmici();
	}
	@GetMapping("/{id}")
	public Amico getAmicoById(@PathVariable Long id) {
		Amico amico = amicoService.getAmico(id);
		if (amico == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Amico non trovato");
		}
		return amico;
	}

	@PostMapping("/user/save") 
	public Long saveAmico(@RequestBody Amico amico) {
		Long idAmico = amicoService.addAmico(amico);
		return idAmico;
	}
	
	@DeleteMapping("/user/delete/{id}")
	public boolean deleteAmicoById(@PathVariable Long id) {
		boolean b = amicoService.deleteAmico(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Amico non trovato");
		} 
		return true;
	}
}




