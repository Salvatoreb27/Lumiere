package lumiere.central.dto;

import java.sql.Date;
import java.util.Comparator;

import lombok.Data;
import lumiere.central.model.Film;

@Data
public class RecensioneDTO {

		private Long Id;
		private Date data;
		private Integer voto;
		private String testo;
		private Boolean pubblico;
		public void setVoto(Comparator<? super Film> voto) {
			// TODO Auto-generated method stub
			
		}
}
