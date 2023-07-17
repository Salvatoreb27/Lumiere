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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente implements Serializable {

	private static final long serialVersionUID = 2218373969423919482L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_utente")
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
		
		//Associazione uno a molti tra utente e amico
		@OneToMany(mappedBy = "sourcePerson")
		private List<Amico> friendships = new ArrayList<>();
		
		// OPZIONALE
//		@OneToMany(mappedBy = "targetPerson")
//		private List<Friendship> requestedFriendships = new ArrayList<Friendship>();
		
		//Associazione tra ruoli e utenti
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
		@JoinTable(name = "ruolo_utente",
		joinColumns = {
		@JoinColumn(name = "id_utente", 
		referencedColumnName = "id_utente")
		},
		inverseJoinColumns = {
		@JoinColumn(name = "id_ruolo", 
		referencedColumnName = "id_ruolo") 
		})
		private Set<Ruolo> ruoli = new HashSet<>();
		
		//Associazione tra pagamenti e utente
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "id_utenti",
		referencedColumnName = "id_pagamento") 
		private Pagamento pagamenti;
		
		@OneToMany(mappedBy = "utenti")
		private List<Recensione> recensioni = new ArrayList<>();
		
		@OneToMany(mappedBy = "utenti")
		private List<Visualizzazione> Visualizzazioni = new ArrayList<>();

		public Utente() {
			super();
		}
		
		public Utente(String nickname, String nome, String cognome, Date dataDiNascita, String email, String password) {
			super();
			this.nickname = nickname;
			this.nome = nome;
			this.cognome = cognome;
			this.dataDiNascita = dataDiNascita;
			this.email = email;
			this.password = password;
		}

		public Utente(Long id, String nickname, String nome, String cognome, Date dataDiNascita, String email,
				String password, String telefono, boolean attivo, List<Amico> friendships, Set<Ruolo> ruoli,
				Pagamento pagamenti, List<Recensione> recensioni, List<Visualizzazione> visualizzazioni) {
			super();
			Id = id;
			this.nickname = nickname;
			this.nome = nome;
			this.cognome = cognome;
			this.dataDiNascita = dataDiNascita;
			this.email = email;
			this.password = password;
			this.telefono = telefono;
			this.attivo = attivo;
			this.friendships = friendships;
			this.ruoli = ruoli;
			this.pagamenti = pagamenti;
			this.recensioni = recensioni;
			Visualizzazioni = visualizzazioni;
		}

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public Date getDataDiNascita() {
			return dataDiNascita;
		}

		public void setDataDiNascita(Date dataDiNascita) {
			this.dataDiNascita = dataDiNascita;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public boolean isAttivo() {
			return attivo;
		}

		public void setAttivo(boolean attivo) {
			this.attivo = attivo;
		}

		public List<Amico> getFriendships() {
			return friendships;
		}

		public void setFriendships(List<Amico> friendships) {
			this.friendships = friendships;
		}

		public Set<Ruolo> getRuoli() {
			return ruoli;
		}

		public void setRuoli(Set<Ruolo> ruoli) {
			this.ruoli = ruoli;
		}

		public Pagamento getPagamenti() {
			return pagamenti;
		}

		public void setPagamenti(Pagamento pagamenti) {
			this.pagamenti = pagamenti;
		}

		public List<Recensione> getRecensioni() {
			return recensioni;
		}

		public void setRecensioni(List<Recensione> recensioni) {
			this.recensioni = recensioni;
		}

		public List<Visualizzazione> getVisualizzazioni() {
			return Visualizzazioni;
		}

		public void setVisualizzazioni(List<Visualizzazione> visualizzazioni) {
			Visualizzazioni = visualizzazioni;
		}

		@Override
		public String toString() {
			return "Utente [Id=" + Id + ", nickname=" + nickname + ", nome=" + nome + ", cognome=" + cognome
					+ ", dataDiNascita=" + dataDiNascita + ", email=" + email + ", password=" + password + ", telefono="
					+ telefono + ", attivo=" + attivo + ", friendships=" + friendships + ", ruoli=" + ruoli
					+ ", pagamenti=" + pagamenti + ", recensioni=" + recensioni + ", Visualizzazioni=" + Visualizzazioni
					+ "]";
		}
		public void addRuolo(Ruolo ruolo) {
			ruoli.add(ruolo);
		}
		
}
