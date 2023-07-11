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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamenti")
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 5397319659619076261L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	@OneToMany(mappedBy = "pagamenti",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Utente> utenti = new HashSet<>();

	public Pagamento(Long id, String tipo, Set<Utente> utenti) {
		super();
		Id = id;
		this.tipo = tipo;
		this.utenti = utenti;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Pagamento [Id=" + Id + ", tipo=" + tipo + ", utenti=" + utenti + ", getId()=" + getId() + ", getTipo()="
				+ getTipo() + ", getUtenti()=" + getUtenti() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
