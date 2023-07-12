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

import lumiere.central.dto.UtenteDTO;
import lumiere.central.model.Utente;
import lumiere.central.services.UtenteService;

@CrossOrigin
@RestController 
@RequestMapping("/lumiere/utenti")
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService; 

	@GetMapping("/all")
	
	public List <UtenteDTO> getAllUtenti() {
		List <Utente> utenti = utenteService.getUtenti();
		List <UtenteDTO> utentiDTO = new ArrayList <>();
		for (Utente utente: utenti) {
			UtenteDTO utenteDTO = new UtenteDTO();
			utenteDTO.setId(utente.getId());
			utenteDTO.setNickname(utente.getNickname());
			utenteDTO.setNome(utente.getNome());
			utenteDTO.setCognome(utente.getCognome());
			utenteDTO.setDataDiNascita(utente.getDataDiNascita());
			utenteDTO.setEmail(utente.getEmail());
			utenteDTO.setPassword(utente.getPassword());
			utenteDTO.setTelefono(utente.getTelefono());
			utenteDTO.setAttivo(utente.isAttivo());
			utentiDTO.add(utenteDTO);
		}
		return utentiDTO;
	}

	@GetMapping("/{id}")
	public Utente getUtenteById(@PathVariable Long id) {
		Utente utente = utenteService.getUtente(id);
		if (utente == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato");
		}
		return utente;
	}

	@PostMapping("/utentefunct/save") 
	public Long saveUtente(@RequestBody Utente utente) {
		Long idUtente = utenteService.addUtente(utente);
		return idUtente;
	}
	
	@PutMapping("/utentefunct/update/{id}")
	public Utente updateUtenteById(@PathVariable Long id, @RequestBody Utente utente) {
		Utente f = utenteService.updateUtente(utente, id);
		if (f == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato");
		}
		return f;
	}

	@DeleteMapping("/utentefunct/delete/{id}")
	public boolean deleteUtenteById(@PathVariable Long id) {
		boolean b = utenteService.deleteUtente(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato");
		} 
		return true;
	}
}
