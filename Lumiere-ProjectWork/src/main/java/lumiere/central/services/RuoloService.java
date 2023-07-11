package lumiere.central.services;

import java.util.List;

import lumiere.central.model.Ruolo;

public interface RuoloService {

	//visualizzazione di tutti i ruoli
	List<Ruolo> getRuoli();
	//visualizzazione di un ruolo specifico
	Ruolo getRuolo(Long id);
	//inserimento di un nuovo ruolo
	Long addRuolo(Ruolo ruolo);
	//modifica di un ruolo esistente
	Ruolo updateRuolo(Ruolo ruolo, Long id);
	//cancellazione di un ruolo esistente
	boolean deleteRuolo(Long id);
}
