package lumiere.central.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "attori")
public class Attore implements Serializable {

	private static final long serialVersionUID = -7173005684429567265L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_attore")
	private Long Id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	//Associazione molti a molti tra attori e film
	@ManyToMany(mappedBy = "attori") 
	@JsonIgnore
	private Set<Film> films = new HashSet<>();

	public Attore() {
		super();
	}

	public Attore(Long id, String nome, Set<Film> films) {
		super();
		Id = id;
		this.nome = nome;
		this.films = films;
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

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Attore [Id=" + Id + ", nome=" + nome + ", films=" + films + "]";
	}
	
	

	
}
