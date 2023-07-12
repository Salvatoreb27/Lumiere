package lumiere.central.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lumiere.central.model.Utente;



@Service
public interface UtenteService {

	//visualizzazione di tutti gli utenti
	List<Utente> getUtenti();
	//visualizzazione di un utente specifico
	Utente getUtente(Long id);
	//inserimento di un nuovo utente
	Long addUtente(Utente utente);
	//modifica di un utente esistente
	Utente updateUtente(Utente utente, Long id);
	//cancellazione di un utente esistente
	boolean deleteUtente(Long id);
}
