package lumiere.central.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "visualizzazioni")
public class Visualizzazione implements Serializable{

	private static final long serialVersionUID = 7144951192204777962L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visualizzazione")
	private Long Id;
	
	//java.sql.Date = non fornisce l'orario esatto, mentre java.util.Date sì
	@Column(name = "data", nullable = false)
	private Date data;
	
	@Column(name = "numero", nullable = false)
	private Integer numero;
	
	//Associazione molti a uno da Visualizzazioni a Film
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_film", referencedColumnName = "id_film")
	private Film films;
	
	//Associazione molti a uno da Visualizzazioni a Utente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utente", referencedColumnName = "id_utente")
	private Utente utenti;

}
