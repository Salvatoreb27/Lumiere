package lumiere.central.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lumiere.central.security.SessionUtils;

@Controller
@RequestMapping("/api/v1/user")
public class LoginUserController {
	
	@GetMapping("/logout")
	public String processLogout() {
	    SessionUtils.invalidateSession();
		return "index";
	}

}
