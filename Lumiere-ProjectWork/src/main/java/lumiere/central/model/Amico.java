package lumiere.central.model;

import java.io.Serializable;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "amici")
public class Amico implements Serializable {
	
	private static final long serialVersionUID = 6874984128289861373L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Utente sourcePerson;
//	@ManyToOne
//	@JoinColumn(name = "friend_id")
//	private Utente targetPerson;
	
	// ... altri campi e metodi
	
	// Getters e setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Utente getSourcePerson() {
		return sourcePerson;
	}
	public void setSourcePerson(Utente sourcePerson) {
		this.sourcePerson = sourcePerson;
	}
	
	
	
	}
