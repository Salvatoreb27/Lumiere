package lumiere.central.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lumiere.central.dto.UtenteLogin;
import lumiere.central.dto.UtenteSignup;
import lumiere.central.model.Amico;
import lumiere.central.model.Recensione;
import lumiere.central.model.Ruolo;
import lumiere.central.security.SessionUtils;
import lumiere.central.model.Utente;
import lumiere.central.security.AuthenticationService;
import lumiere.central.services.AmicoService;
import lumiere.central.services.RecensioneService;
import lumiere.central.services.UtenteService;

@CrossOrigin
@RestController 
@RequestMapping("/api/v1/lumiere/utenti")
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService; 
	
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AmicoService amicoService; 


	@GetMapping("/{id}")
	public Utente getUtenteById(@PathVariable Long id) {
		Utente utente = utenteService.getUtente(id);
		if (utente == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato");
		}
		return utente;
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		String title = "Please Login";
		model.addAttribute("message", title);
		model.addAttribute("utenteLogin", new UtenteLogin());
		return "loginForm";
	}

	@PostMapping("/loginUtente")
	public String processLoginUtente(@ModelAttribute("utenteLogin") UtenteLogin utenteLogin, Model model) {
		// invocazione del servizio
		boolean isAuth = authService.authenticate(utenteLogin.getEmail(), utenteLogin.getPassword());
		System.err.println("AUTH=" + isAuth);
		
		//Preparazione della risposta
		if (isAuth) {	
			//ricerca ruolo da sessione
			String ruolo = SessionUtils.getUserRole();		
			System.err.println("attributo sessione RUOLI=" + ruolo);
			
			if (ruolo.equals("ROLE_USER")) {
				return "redirect:/home";
			} else if (ruolo.equals("ROLE_ADMIN")) {
				return "adminDashboard";
			} else {
				return "error";
			}
		} else {
			model.addAttribute("utenteLogin", "Utente non esistente");
			return "loginForm";
		}
	}

	@GetMapping("/signup")
	public String showSignupForm(Model model) {
		String title = "Please Signup";
		model.addAttribute("message", title);
		model.addAttribute("utenteSignup", new UtenteSignup());
		return "signupForm";
	}

	@PostMapping("/signupUtente")
	public String processSignupUtente(@ModelAttribute("utenteSignup") UtenteSignup utenteSignup, Model model) {
		//****** MAPPING UtenteSignup -> Utente ******//
		Utente utente = new Utente();
		utente.setCognome(utenteSignup.getCognome());
		utente.setNome(utenteSignup.getNome());
		utente.setEmail(utenteSignup.getEmail());
		utente.setPassword(passwordEncoder.encode(utenteSignup.getPassword()));
		utente.setAttivo(true);
		Ruolo ruolo = new Ruolo();
		ruolo.setNome("USER");
		ruolo.setId((long) 1);
		utente.addRuolo(ruolo);
		// invocazione del servizio
		Long id = utenteService.addUtente(utente);
		//Preparazione della risposta
		//model.addAttribute("utente", utente); 
		//return "loginForm";
		return "redirect:/utenti/login";
	}
	
	@PostMapping("/amico/addAmico") 
	public Long saveAmico(@RequestBody Amico amico) {
		Long idAmico = amicoService.addAmico(amico);
		return idAmico;
	}
	
	@DeleteMapping("/amico/delete/{id}")
	public boolean deleteAmicoById(@PathVariable Long id) {
		boolean b = amicoService.deleteAmico(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Amico non trovato");
		} 
		return true;
	}
}
