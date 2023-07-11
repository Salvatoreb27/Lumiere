package lumiere.central.services;

import java.util.List;

import lumiere.central.model.Genere;

public interface GenereService {

	//visualizzazione di tutti i generi
	List<Genere> getGenres();
	//visualizzazione di un genere specifico
	Genere getGenere(Long id);
	//inserimento di un nuovo genere
	Long addGenere(Genere genere);
	//modifica di un genere esistente
	Genere updateGenere(Genere genere, Long id);
	//cancellazione di un genere esistente
	boolean deleteGenere(Long id);
}
