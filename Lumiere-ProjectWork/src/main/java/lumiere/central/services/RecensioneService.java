package lumiere.central.services;

import java.util.List;

import lumiere.central.model.Recensione;

public interface RecensioneService{

	//visualizzazione di tutti le recensioni
	List<Recensione> getRecensioni();
	//visualizzazione di una recensione specifica
	Recensione getRecensione(Long id);
	//inserimento di una nuova recensione
	Long addRecensione(Recensione recensione);
	//modifica di una recensione esistente
	Recensione updateRecensione(Recensione recensione, Long id);
	//cancellazione di una recensione esistente
	boolean deleteRecensione(Long id);
}
