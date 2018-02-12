package co.simplon.model;

public class Affaire {
	private Long id_affaire;
	private String nom_affaire;
	private String date_creation;
	private String date_cloture;
	private String pieces_conviction;
	private boolean classee;
	
	public Long getId() {
		return id_affaire;
	}
	public void setId(Long id) {
		this.id_affaire = id;
	}
	public String getNom() {
		return nom_affaire;
	}
	public void setNom(String nom) {
		this.nom_affaire = nom;
	}
	public boolean isEnCours() {
		return classee;
	}
	public void setEnCours(boolean enCours) {
		this.classee = enCours;
	}
	public String getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}
	public String getDate_cloture() {
		return date_cloture;
	}
	public void setDate_cloture(String date_cloture) {
		this.date_cloture = date_cloture;
	}
	public String getPieces_conviction() {
		return pieces_conviction;
	}
	public void setPieces_conviction(String pieces_conviction) {
		this.pieces_conviction = pieces_conviction;
	}
	public boolean isClassee() {
		return classee;
	}
	public void setClassee(boolean classee) {
		this.classee = classee;
	}
}
