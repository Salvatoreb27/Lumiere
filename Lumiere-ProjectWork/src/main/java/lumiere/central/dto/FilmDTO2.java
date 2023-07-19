package lumiere.central.dto;

import java.sql.Date;

public class FilmDTO2 {
	private String titolo;
	private Date anno;
	private Integer durata;
	private String regista;
	private String paese;
	private String lingua;
	
	public FilmDTO2() {
		super();
	}

	public FilmDTO2(String titolo, Date anno, Integer durata, String regista, String paese, String lingua) {
		super();
		this.titolo = titolo;
		this.anno = anno;
		this.durata = durata;
		this.regista = regista;
		this.paese = paese;
		this.lingua = lingua;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Date getAnno() {
		return anno;
	}

	public void setAnno(Date anno) {
		this.anno = anno;
	}

	public Integer getDurata() {
		return durata;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	@Override
	public String toString() {
		return "FilmDTO2 [titolo=" + titolo + ", anno=" + anno + ", durata=" + durata + ", regista=" + regista
				+ ", paese=" + paese + ", lingua=" + lingua + "]";
	}
	
	
}
