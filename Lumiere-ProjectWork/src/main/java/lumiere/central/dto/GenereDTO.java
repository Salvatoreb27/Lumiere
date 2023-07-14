package lumiere.central.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lumiere.central.model.Film;

@Data
public class GenereDTO {
	
	private String nome;
	private Set<Film> films = new HashSet<>();
}
