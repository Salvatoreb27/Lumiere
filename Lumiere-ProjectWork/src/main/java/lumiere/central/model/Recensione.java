package lumiere.central.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name= "recensioni")
public class Recensione implements Serializable {

	private static final long serialVersionUID = -203671527600072686L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recensione")
	private Long Id;
	
	@Column(name = "data", nullable = false)
	private Date data;
	
	@Column(name = "voto", nullable = false)
	private Integer voto;
	
	@Column(name = "testo", length = 100, nullable = false)
	private String testo;
	
	@Column(name = "pubblico", nullable = false)
	private Boolean pubblico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_film", 
	referencedColumnName = "id_film") 
	private Film films;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utente", 
	referencedColumnName = "id_utente") 
	private Utente utenti;
	
	
	
	
}
