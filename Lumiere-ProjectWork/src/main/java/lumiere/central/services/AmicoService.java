package lumiere.central.services;

import java.util.List;

import lumiere.central.model.Amico;
import lumiere.central.model.Attore;

public interface AmicoService {

	//visualizzazione di tutti gli amici
	List<Amico> getAmici();
	//visualizzazione di un amico specifico
	Amico getAmico(Long id);
	//inserimento di un nuovo amico
	Long addAmico(Amico amico);
	//cancellazione di un amico esistente
	boolean deleteAmico(Long id);
	
}
