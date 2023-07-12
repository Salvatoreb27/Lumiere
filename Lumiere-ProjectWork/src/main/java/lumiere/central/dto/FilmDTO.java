package lumiere.central.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class FilmDTO {
	
	private Long id;
	private String titolo;
	private Date anno;
	private Time durata;
	private String regista;
	private String paese;
	private String lingua;

}
