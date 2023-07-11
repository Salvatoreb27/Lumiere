package lumiere.central.model;

import java.io.Serializable;
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
	private Set<Utente> utenti = new HashSet<>();

}
