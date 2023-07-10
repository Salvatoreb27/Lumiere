package lumiere.central.model;

import java.io.Serializable;
import java.sql.Time;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "films")
public class Film implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;
	
	@Column(name = "titolo", length = 100, nullable = false)
	private String titolo;
	
	@Column(name = "anno", nullable = false)
	private Date anno;
	
	@Column(name = "durata", nullable = false)
	private Time durata;
	
	@Column(name = "autore", length = 100, nullable = false)
	private String regista;
	
	@Column(name = "autore", length = 50, nullable = false)
	private String paese;
	
	@Column(name = "autore", length = 50, nullable = false)
	private String lingua;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "film_attore",
	joinColumns = {
	@JoinColumn(name = "id_film", 
	referencedColumnName = "id")
	},
	inverseJoinColumns = {
	@JoinColumn(name = "id_attore", 
	referencedColumnName = "id") 
	})
	private Set<Attore> attori = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "film_genere",
	joinColumns = {
	@JoinColumn(name = "id_film", 
	referencedColumnName = "id")
	},
	inverseJoinColumns = {
	@JoinColumn(name = "id_genere", 
	referencedColumnName = "id") 
	})
	private Set<Genere> generi = new HashSet<>();

	
	
	
}
