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

	public Visualizzazione(Long id, Date data, Integer numero, Film films, Utente utenti) {
		super();
		Id = id;
		this.data = data;
		this.numero = numero;
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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

	@Override
	public String toString() {
		return "Visualizzazione [Id=" + Id + ", data=" + data + ", numero=" + numero + ", films=" + films + ", utenti="
				+ utenti + "]";
	}

}
