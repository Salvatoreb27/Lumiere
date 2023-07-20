package lumiere.central.dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lumiere.central.model.Attore;
import lumiere.central.model.Genere;
import lumiere.central.model.Recensione;
import lumiere.central.model.Visualizzazione;

@Data
public class FilmDTO {
	
	private Long id;
	private String titolo;
	private String trama;
	private String locandina;
	private String trailer;
	private Date anno;
	private Integer durata;
	private String regista;
	private String paese;
	private String lingua;
	private Set<Attore> attori = new HashSet<>();
	private Set<Genere> generi = new HashSet<>();
	private Set<Recensione> recensioni = new HashSet<>();
	private Set<Visualizzazione> visualizzazioni = new HashSet<>();

}
