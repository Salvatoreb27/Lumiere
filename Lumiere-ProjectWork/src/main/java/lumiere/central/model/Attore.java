package lumiere.central.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	@Column(name = "id")
	private Long Id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy = "attori") 
	private Set<Film> films = new HashSet<>();

}
