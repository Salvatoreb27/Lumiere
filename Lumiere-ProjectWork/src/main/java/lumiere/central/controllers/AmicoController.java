package lumiere.central.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import lumiere.central.model.Amico;
import lumiere.central.services.AmicoService;

@CrossOrigin
@RestController 
@RequestMapping("/api/v1/lumiere/amici")
public class AmicoController {

	@Autowired
	private AmicoService amicoService; 
	
	@GetMapping("/all")
	public String showAllAmici(Model model) {
		//richiede servizio a AmicoService
		List<Amico> amici = amicoService.getAmici();
		
		String title = "amici";
		model.addAttribute("message", title);
		model.addAttribute("amici", amici);

		return "amici";
	}
	
	@GetMapping("/{id}")
	public Amico getAmicoById(@PathVariable Long id) {
		Amico amico = amicoService.getAmico(id);
		if (amico == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Amico non trovato");
		}
		return amico;
	}

}




