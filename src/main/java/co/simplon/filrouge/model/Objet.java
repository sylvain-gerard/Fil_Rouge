package co.simplon.filrouge.model;


import java.util.List;

public abstract class Objet {

	private Long id;
	private String type;
	private String marque;
	private String modele;
	private List<Affaire> affaire;
	private String infos_complementaire;
	private List<String> photos;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public List<Affaire> getAffaire() {
		return affaire;
	}
	public void setAffaire(List<Affaire> affaire) {
		this.affaire = affaire;
	}
	public String getInfos_complementaire() {
		return infos_complementaire;
	}
	public void setInfos_complementaire(String infos_complementaire) {
		this.infos_complementaire = infos_complementaire;
	}
	public List<String> getPhotos() {
		return photos;
	}
	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}
	
	
	
}
