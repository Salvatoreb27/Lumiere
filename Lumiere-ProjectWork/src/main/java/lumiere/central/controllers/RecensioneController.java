package lumiere.central.controllers;

import java.sql.Date;
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

import lumiere.central.dto.RecensioneDTO;
import lumiere.central.model.Recensione;
import lumiere.central.services.RecensioneService;

@CrossOrigin
@RestController 
@RequestMapping("/lumiere/recensioni")
public class RecensioneController {

	@Autowired
	private RecensioneService recensioneService;
	
	@GetMapping("/all")
	public List <RecensioneDTO> getAllRecensioni() {
		List <Recensione> recensioni = recensioneService.getRecensioni();
		List <RecensioneDTO> recensioniDTO = new ArrayList <>();
		for (Recensione recensione: recensioni) {
			RecensioneDTO recensioneDTO = new RecensioneDTO();
			recensioneDTO.setId(recensione.getId());
			recensioneDTO.setData((Date) recensione.getData());
			recensioneDTO.setVoto(recensione.getVoto());
			recensioneDTO.setTesto(recensione.getTesto());
			recensioneDTO.setPubblico(recensione.getPubblico());
			recensioniDTO.add(recensioneDTO);
		}
		return recensioniDTO;
	}

	@GetMapping("/{id}")
	public Recensione getRecensioneById(@PathVariable Long id) {
		Recensione recensione = recensioneService.getRecensione(id);
		if (recensione == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recensione non trovato");
		}
		return recensione;
	}

	@PostMapping("/user/save") 
	public Long saveRecensione(@RequestBody Recensione recensione) {
		Long idRecensione = recensioneService.addRecensione(recensione);
		return idRecensione;
	}
	
	@PutMapping("/user/update/{id}")
	public Recensione updateRecensioneById(@PathVariable Long id, @RequestBody Recensione recensione) {
		Recensione f = recensioneService.updateRecensione(recensione, id);
		if (f == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recensione non trovato");
		}
		return f;
	}

	@DeleteMapping("/user/delete/{id}")
	public boolean deleteRecensioneById(@PathVariable Long id) {
		boolean b = recensioneService.deleteRecensione(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recensione non trovato");
		} 
		return true;
	}
}
