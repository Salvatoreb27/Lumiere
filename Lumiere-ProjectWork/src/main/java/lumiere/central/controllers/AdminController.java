package lumiere.central.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
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
import lumiere.central.model.Attore;
import lumiere.central.model.Film;
import lumiere.central.model.Genere;
import lumiere.central.model.Ruolo;
import lumiere.central.model.Utente;
import lumiere.central.model.Visualizzazione;
import lumiere.central.security.SessionUtils;
import lumiere.central.services.AttoreService;
import lumiere.central.services.FilmService;
import lumiere.central.services.GenereService;

import lumiere.central.services.RuoloService;
import lumiere.central.services.UtenteService;
import lumiere.central.services.VisualizzazioneService;

@CrossOrigin
@RestController 
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private AttoreService attoreService; 
	
	@Autowired
	private GenereService genereService; 
	
	@Autowired
	private UtenteService utenteService; 
	
	@Autowired
	private RuoloService ruoloService; 
	
	@Autowired
	private VisualizzazioneService visualizzazioneService; 
	
//Cancellazione di film --> Admin
	@DeleteMapping("/film/delete/{id}")
	public boolean deleteFilmById(@PathVariable Long id) {
		boolean b = filmService.deleteFilm(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trovato");
		} 
		return true;
	}
	
	//@Secured("ROLE_ADMIN")
	//@PreAuthorize("hasRole('ADMIN')")
	
	//Aggiunta di film ---> Admin
	@PostMapping("/film/addFilm") 
	public Long saveFilm(@RequestBody Film film) {
		Long idFilm = filmService.addFilm(film);
		return idFilm;
	}
	
	//@Secured("ROLE_ADMIN")
	//@PreAuthorize("hasRole('ADMIN')")
	
	//Aggiornamento di film --->Admin
	@PutMapping("/film/update/{id}")
	public Film updateFilmById(@PathVariable Long id, @RequestBody Film film) {
		Film f = filmService.updateFilm(film, id);
		if (f == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trovato");
		}
		return f;
	}
	
	//Dashboard dell'admin
	@GetMapping("/dashboard")
	public String showAdminDashboard(Model model) {
		if (SessionUtils.isAdmin()) {
			return "adminDashboard";
		}
		return "error";
	}
	
	//Aggiunta di attori al db --->Admin
	@PostMapping("/attore/addAttore") 
	public Long saveAttore(@RequestBody Attore attore) {
		Long idAttore = attoreService.addAttore(attore);
		return idAttore;
	}
	
	//Aggiornamento di un attore nel db --->Admin
	@PutMapping("/attore/update/{id}")
	public Attore updateAttoreById(@PathVariable Long id, @RequestBody Attore attore) {
		Attore a = attoreService.updateAttore(attore, id);
		if (a == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attore non trovato");
		}
		return a;
	}
	
	//Eliminazione di un attore dal db --->Admin
	@DeleteMapping("/attore/delete/{id}")
	public boolean deleteAttoreById(@PathVariable Long id) {
		boolean b = attoreService.deleteAttore(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attore non trovato");
		} 
		return true;
	}
	
	//Aggiunta di un genere al db --->Admin
	@PostMapping("/genere/addGenere") 
	public Long saveGenere(@RequestBody Genere genere) {
		Long idGenere = genereService.addGenere(genere);
		return idGenere;
	}
	
	//Aggiornamento di un genere del db ---> Admin
	@PutMapping("/genere/update/{id}")
	public Genere updateGenereById(@PathVariable Long id, @RequestBody Genere genere) {
		Genere a = genereService.updateGenere(genere, id);
		if (a == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genere non trovato");
		}
		return a;
	}

	//Eliminazione di un genere nel db --->Admin
	@DeleteMapping("/genere/delete/{id}")
	public boolean deleteGenereById(@PathVariable Long id) {
		boolean b = genereService.deleteGenere(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genere non trovato");
		} 
		return true;
	}
	
	//Visualizzazione di tutti gli utenti ---> Admin
	@GetMapping("/utenti/all")
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
	@PostMapping("/utente/addUtente") 
	public Long saveUtente(@RequestBody Utente utente) {
		Long idUtente = utenteService.addUtente(utente);
		return idUtente;
	}
	
	@PutMapping("/utente/update/{id}")
	public Utente updateUtenteById(@PathVariable Long id, @RequestBody Utente utente) {
		Utente f = utenteService.updateUtente(utente, id);
		if (f == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato");
		}
		return f;
	}

	@DeleteMapping("/utente/delete/{id}")
	public boolean deleteUtenteById(@PathVariable Long id) {
		boolean b = utenteService.deleteUtente(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato");
		} 
		return true;
	}

	@PostMapping("/ruolo/addRuolo") 
	public Long saveRuolo(@RequestBody Ruolo ruolo) {
		Long idRuolo = ruoloService.addRuolo(ruolo);
		return idRuolo;
	}
	
	@PutMapping("/ruolo/update/{id}")
	public Ruolo updateRuoloById(@PathVariable Long id, @RequestBody Ruolo ruolo) {
		Ruolo a = ruoloService.updateRuolo(ruolo, id);
		if (a == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruolo non trovato");
		}
		return a;
	}

	@DeleteMapping("/ruolo/delete/{id}")
	public boolean deleteRuoloById(@PathVariable Long id) {
		boolean b = ruoloService.deleteRuolo(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruolo non trovato");
		} 
		return true;
	}
	@PutMapping("/visualizzazione/update/{id}")
	public Visualizzazione updateVisualizzazioneById(@PathVariable Long id, @RequestBody Visualizzazione visualizzazione) {
		Visualizzazione a = visualizzazioneService.updateVisualizzazione(visualizzazione, id);
		if (a == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Visualizzazione non trovato");
		}
		return a;
	}

	@DeleteMapping("/visualizzazione/delete/{id}")
	public boolean deleteVisualizzazioneById(@PathVariable Long id) {
		boolean b = visualizzazioneService.deleteVisualizzazione(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Visualizzazione non trovato");
		} 
		return true;
	}
	
}
