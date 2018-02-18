package co.simplon.filrouge.model;

public class Suspect extends Humain{
	
	private Long id_suspect;
	private String adresse;
	private String date_naissance;
	private int taille;
	private int poids;
	private String couleur_yeux;
	private String couleur_peau;
	private String signes_particuliers;
	private String adn;
	
	public Long getId_suspect() {
		return id_suspect;
	}
	public void setId_suspect(Long id_suspect) {
		this.id_suspect = id_suspect;
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
	public String getCouleur_yeux() {
		return couleur_yeux;
	}
	public void setCouleur_yeux(String couleur_yeux) {
		this.couleur_yeux = couleur_yeux;
	}
	public String getCouleur_peau() {
		return couleur_peau;
	}
	public void setCouleur_peau(String couleur_peau) {
		this.couleur_peau = couleur_peau;
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

	
}
