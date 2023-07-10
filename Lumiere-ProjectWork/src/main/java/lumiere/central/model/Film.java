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

@Entity
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

	public Film() {
		super();
	}

	public Film(Long id, String titolo, Date anno, Time durata, String regista, String paese, String lingua,
			Set<Attore> attori) {
		super();
		Id = id;
		this.titolo = titolo;
		this.anno = anno;
		this.durata = durata;
		this.regista = regista;
		this.paese = paese;
		this.lingua = lingua;
		this.attori = attori;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Date getAnno() {
		return anno;
	}

	public void setAnno(Date anno) {
		this.anno = anno;
	}

	public Time getDurata() {
		return durata;
	}

	public void setDurata(Time durata) {
		this.durata = durata;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public Set<Attore> getAttori() {
		return attori;
	}

	public void setAttori(Set<Attore> attori) {
		this.attori = attori;
	}

	@Override
	public String toString() {
		return "Film [Id=" + Id + ", titolo=" + titolo + ", anno=" + anno + ", durata=" + durata + ", regista="
				+ regista + ", paese=" + paese + ", lingua=" + lingua + ", attori=" + attori + "]";
	}
	
	
	
}
