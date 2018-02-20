package co.simplon.filrouge.model;

import java.util.List;

public class Suspect extends Humain{
	
	private String adresse;
	private String date_naissance;
	private int taille;
	private int poids;
	private String signes_particuliers;
	private String adn;
	private String sexe;
	private List <Affaire> affaires;
	private String infos_suspect;
	private List<String> photo_suspect;
	private String empreinte_suspect;
	
	public Suspect() {
		super();
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}

	public String getSignes_particuliers() {
		return signes_particuliers;
	}
	public void setSignes_particuliers(String signes_particuliers) {
		this.signes_particuliers = signes_particuliers;
	}
	public String getAdn() {
		return adn;
	}
	public void setAdn(String adn) {
		this.adn = adn;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public List<Affaire> getAffaires() {
		return affaires;
	}
	public void setAffaires(List<Affaire> affaires) {
		this.affaires = affaires;
	}
	public String getInfos_suspect() {
		return infos_suspect;
	}
	public void setInfos_suspect(String infos_suspect) {
		this.infos_suspect = infos_suspect;
	}
	public List<String> getPhoto_suspect() {
		return photo_suspect;
	}
	public void setPhoto_suspect(List<String> photo_suspect) {
		this.photo_suspect = photo_suspect;
	}
	public String getEmpreinte_suspect() {
		return empreinte_suspect;
	}
	public void setEmpreinte_suspect(String empreinte_suspect) {
		this.empreinte_suspect = empreinte_suspect;
	}
}
