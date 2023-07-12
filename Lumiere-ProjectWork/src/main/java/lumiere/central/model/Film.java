package lumiere.central.model;

import java.awt.Image;
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
	
	@Column(name = "copertina", nullable = true)
	private Image copertina;

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


		public Film() {
			super();
		}

		public Film(Long id, String titolo, Image copertina, Date anno, Time durata, String regista, String paese,
				String lingua, Set<Attore> attori, Set<Genere> generi, Set<Recensione> recensioni,
				Set<Visualizzazione> visualizzazioni) {
			super();
			Id = id;
			this.titolo = titolo;
			this.copertina = copertina;
			this.anno = anno;
			this.durata = durata;
			this.regista = regista;
			this.paese = paese;
			this.lingua = lingua;
			this.attori = attori;
			this.generi = generi;
			this.recensioni = recensioni;
			this.visualizzazioni = visualizzazioni;
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
		
		public Image getCopertina() {
			return copertina;
		}

		public void setCopertina(Image copertina) {
			this.copertina = copertina;
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


		public Set<Genere> getGeneri() {
			return generi;
		}


		public void setGeneri(Set<Genere> generi) {
			this.generi = generi;
		}


		public Set<Recensione> getRecensioni() {
			return recensioni;
		}


		public void setRecensioni(Set<Recensione> recensioni) {
			this.recensioni = recensioni;
		}


		public Set<Visualizzazione> getVisualizzazioni() {
			return visualizzazioni;
		}


		public void setVisualizzazioni(Set<Visualizzazione> visualizzazioni) {
			this.visualizzazioni = visualizzazioni;
		}


		@Override
		public String toString() {
			return "Film [Id=" + Id + ", titolo=" + titolo + ", anno=" + anno + ", durata=" + durata + ", regista="
					+ regista + ", paese=" + paese + ", lingua=" + lingua + ", attori=" + attori + ", generi=" + generi
					+ ", recensioni=" + recensioni + ", visualizzazioni=" + visualizzazioni + "]";
		}




}
