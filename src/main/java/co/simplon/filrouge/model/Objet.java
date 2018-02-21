package co.simplon.filrouge.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@MappedSuperclass
//@Embeddable
public abstract class Objet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Size(max = 100)
	private Long id;

	@Size(max = 100)
	private String type;
	
	@Size(max = 100)
	private String marque;
	
	@Size(max = 100)
	private String modele;
	
	//private List<Affaire> affaire;
	
	@Size(max = 250)
	private String infos_complementaire;
	
	//private List<String> photos;

	protected Objet() {

	}

//	public Objet(Long id, String type, String marque, String modele, List<Affaire> affaire, String infos_complementaire,
//			List<String> photos) {
//		this.id = id;
//		this.type = type;
//		this.marque = marque;
//		this.modele = modele;
//		this.affaire = affaire;
//		this.infos_complementaire = infos_complementaire;
//		this.photos = photos;
//
//	}

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

//	public List<Affaire> getAffaire() {
//		return affaire;
//	}
//
//	public void setAffaire(List<Affaire> affaire) {
//		this.affaire = affaire;
//	}

	public String getInfos_complementaire() {
		return infos_complementaire;
	}

	public void setInfos_complementaire(String infos_complementaire) {
		this.infos_complementaire = infos_complementaire;
	}

//	public List<String> getPhotos() {
//		return photos;
//	}
//
//	public void setPhotos(List<String> photos) {
//		this.photos = photos;
//	}

}
