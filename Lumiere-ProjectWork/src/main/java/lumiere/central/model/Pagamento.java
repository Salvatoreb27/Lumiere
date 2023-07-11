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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamenti")
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 5397319659619076261L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pagamento")
	private Long Id;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	@OneToMany(mappedBy = "pagamenti",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Utente> utenti = new HashSet<>();
	
}
