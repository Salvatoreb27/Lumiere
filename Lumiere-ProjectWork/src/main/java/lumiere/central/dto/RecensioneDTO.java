package lumiere.central.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class RecensioneDTO {

		private Long Id;
		private Date data;
		private Integer voto;
		private String testo;
		private Boolean pubblico;
}
