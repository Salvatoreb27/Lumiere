package lumiere.central.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "films")
public class Film implements Serializable {

	private static final long serialVersionUID = 6120667484064701854L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_film")
	private Long Id;

	@Column(name = "titolo", length = 100, nullable = false)
	private String titolo;

	@Column(name = "anno", nullable = false)
	private Date anno;

	@Column(name = "durata", nullable = false)
	private Time durata;

	@Column(name = "regista", length = 100, nullable = false)
	private String regista;

	@Column(name = "paese", length = 50, nullable = false)
	private String paese;

	@Column(name = "lingua", length = 50, nullable = false)
	private String lingua;

	
	//Associazione molti a molti tra attori e film
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "film_attore",
	joinColumns = {
			@JoinColumn(name = "id_attore", 
					referencedColumnName = "id_film")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "id_film", 
					referencedColumnName = "id_attore") 
	})
	private Set<Attore> attori = new HashSet<>();

	
	//Associazione molti a molti tra attori e generi
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "film_genere",
	joinColumns = {
			@JoinColumn(name = "id_genere", 
					referencedColumnName = "id_film")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "id_film", 
					referencedColumnName = "id_genere") 
	})
	private Set<Genere> generi = new HashSet<>();

	
	//Associazione uno a molti tra film e recensioni
	@OneToMany(mappedBy = "films", 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Recensione> recensioni = new HashSet<>();
	
	
	//Associazione uno a molti tra film e visualizzazioni
		@OneToMany(mappedBy = "films", 
				fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private Set<Visualizzazione> visualizzazioni = new HashSet<>();




}
