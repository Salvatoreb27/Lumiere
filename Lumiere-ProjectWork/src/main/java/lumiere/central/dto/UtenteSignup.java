package lumiere.central.dto;

public class UtenteSignup {

	private String email;
	private String password;
	private String cognome;
	private String nome;
	
	public UtenteSignup() {
	}
	
	public UtenteSignup(String email, String password, String cognome, String nome) {
		this.email = email;
		this.password = password;
		this.cognome = cognome;
		this.nome = nome;
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
	
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "UtenteDto [email=" + email + ", password=" + password + "]";
	}
	
}
