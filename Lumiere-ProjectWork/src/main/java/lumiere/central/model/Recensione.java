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

	public Recensione(Long id, Date data, Integer voto, String testo, Boolean pubblico, Film films, Utente utenti) {
		super();
		Id = id;
		this.data = data;
		this.voto = voto;
		this.testo = testo;
		this.pubblico = pubblico;
		this.films = films;
		this.utenti = utenti;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getVoto() {
		return voto;
	}

	public void setVoto(Integer voto) {
		this.voto = voto;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Boolean getPubblico() {
		return pubblico;
	}

	public void setPubblico(Boolean pubblico) {
		this.pubblico = pubblico;
	}

	public Film getFilms() {
		return films;
	}

	public void setFilms(Film films) {
		this.films = films;
	}

	public Utente getUtenti() {
		return utenti;
	}

	public void setUtenti(Utente utenti) {
		this.utenti = utenti;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Recensione [Id=" + Id + ", data=" + data + ", voto=" + voto + ", testo=" + testo + ", pubblico="
				+ pubblico + ", films=" + films + ", utenti=" + utenti + ", getId()=" + getId() + ", getData()="
				+ getData() + ", getVoto()=" + getVoto() + ", getTesto()=" + getTesto() + ", getPubblico()="
				+ getPubblico() + ", getFilms()=" + getFilms() + ", getUtenti()=" + getUtenti() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
