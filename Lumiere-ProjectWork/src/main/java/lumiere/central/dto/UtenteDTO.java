package lumiere.central.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class UtenteDTO {

	private String nickname;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private String email;
	private String password;
	private String telefono;
}
