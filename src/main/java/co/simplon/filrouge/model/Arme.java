package co.simplon.filrouge.model;

public class Arme {
	private Long id_arme;
	private String type;
	private String marque_arme;
	private String modele_arme;
	private String calibre;
	private String numSerie;
	
	public Long getId_arme() {
		return id_arme;
	}
	public void setId_arme(Long id_arme) {
		this.id_arme = id_arme;
	}
	public String getMarque_arme() {
		return marque_arme;
	}
	public void setMarque_arme(String marque_arme) {
		this.marque_arme = marque_arme;
	}
	public String getModele_arme() {
		return modele_arme;
	}
	public void setModele_arme(String modele_arme) {
		this.modele_arme = modele_arme;
	}
	public String getCalibre() {
		return calibre;
	}
	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
}
