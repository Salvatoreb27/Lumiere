package lumiere.central.services;

import java.util.List;

import lumiere.central.model.Attore;

public interface AttoreService {

	//visualizzazione di tutti gli attori
	List<Attore> getAttori();
	//visualizzazione di un attore specifico
	Attore getAttore(Long id);
	//inserimento di un nuovo attore
	Long addAttore(Attore attore);
	//modifica di un attore esistente
	Attore updateAttore(Attore attore, Long id);
	//cancellazione di un attore esistente
	boolean deleteAttore(Long id);
	
}
