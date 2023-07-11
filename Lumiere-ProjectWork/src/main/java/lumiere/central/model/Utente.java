package lumiere.central.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
@Table(name = "utenti")
public class Utente implements Serializable {

	private static final long serialVersionUID = 2218373969423919482L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long Id;
		
		@Column(name = "nickname", nullable = false)
		private String nickname;
		
		@Column(name = "nome", nullable = false)
		private String nome;
		
		@Column(name = "cognome", nullable = false)
		private String cognome;
		
		@Column(name = "dataDiNascita", nullable = false)
		private Date dataDiNascita;
		
		@Column(name = "email", nullable = false)
		private String email;
		
		@Column(name = "password", nullable = false)
		private String password;
		
		@Column(name = "telefono", nullable = true)
		private String telefono;
		
		@Column(name = "attivo", nullable = false)
		private boolean attivo;
		
		@OneToMany(mappedBy = "sourcePerson")
		private List<Amico> friendships = new ArrayList<>();
		
		// OPZIONALE
//		@OneToMany(mappedBy = "targetPerson")
//		private List<Friendship> requestedFriendships = new ArrayList<Friendship>();
		
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
		@JoinTable(name = "ruolo_utente",
		joinColumns = {
		@JoinColumn(name = "id_utente", 
		referencedColumnName = "id")
		},
		inverseJoinColumns = {
		@JoinColumn(name = "id_ruolo", 
		referencedColumnName = "id") 
		})
		private Set<Ruolo> ruoli = new HashSet<>();
		
		

		
}
