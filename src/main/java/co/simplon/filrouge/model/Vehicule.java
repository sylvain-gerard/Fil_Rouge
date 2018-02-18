package co.simplon.filrouge.model;

public class Vehicule extends Objet{
	
	private String immatriculation;
	private String couleur_vehicule;
	
	public Vehicule() {
		super();
	}
	
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getCouleur_vehicule() {
		return couleur_vehicule;
	}
	public void setCouleur_vehicule(String couleur_vehicule) {
		this.couleur_vehicule = couleur_vehicule;
	}
	
	
}
