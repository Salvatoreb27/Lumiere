package lumiere.central.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "ruoli")
public class Ruolo implements Serializable {

	private static final long serialVersionUID = -785697413272000785L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ruolo")
	private Long Id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@ManyToMany(mappedBy = "ruoli") 
	@JsonIgnore
	private Set<Utente> utenti = new HashSet<>();

	
	public Ruolo() {
		super();
	}

	public Ruolo(Long id, String nome, Set<Utente> utenti) {
		super();
		Id = id;
		this.nome = nome;
		this.utenti = utenti;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}

	@Override
	public String toString() {
		return "Ruolo [Id=" + Id + ", nome=" + nome + ", utenti=" + utenti + "]";
	}
	
}
