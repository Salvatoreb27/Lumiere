package lumiere.central.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lumiere.central.model.Utente;
import lumiere.central.repository.UtenteRepository;


@Service
public class UtenteServiceDB implements UtenteService {

	@Autowired
	private UtenteRepository repository;
	
	@Override
	public List<Utente> getUtenti() {
		return (List<Utente>) repository.findAll();
	}

	@Override
	public Utente getUtente(Long id) {
		Optional<Utente> u = repository.findById(id);
		if (u.isPresent()) {
			return u.get();
		}
		return null;
	}

	@Override
	public Long addUtente(Utente utente) {
		Utente u = repository.save(utente);
		return u.getId();
	}

	@Override
	public Utente updateUtente(Utente utente, Long id) {
		if (repository.existsById(id)) {
			Utente u = repository.findById(id).get(); //utente sul DB
			u.setNickname(utente.getNickname());
			u.setNome(utente.getNome());
			u.setCognome(utente.getCognome());
			u.setDataDiNascita(utente.getDataDiNascita());
			u.setEmail(utente.getEmail());
			u.setPassword(utente.getPassword());
			u.setTelefono(utente.getTelefono());
			u.setAttivo(utente.isAttivo());
			u.setFriendships(utente.getFriendships());
			u.setRuoli(utente.getRuoli());
			u.setPagamenti(utente.getPagamenti());
			u.setRecensioni(utente.getRecensioni());
			u.setVisualizzazioni(utente.getVisualizzazioni());
			
			repository.save(u);
			return u;
		}
		return null;
	}

	@Override
	public boolean deleteUtente(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}