package co.simplon.filrouge.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "suspect")
public class Suspect extends Humain {

	private String adresse;
	private Date date_naissance;
	private double taille;
	private double poids;
	private String signes_particuliers;
	private String adn;
	private String sexe;
	private String infos_suspect;
	private String photo;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "suspect")
	private Set<Affaire> affaire = new HashSet<>();

	public Suspect() {
		super();
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getInfos_suspect() {
		return infos_suspect;
	}

	public void setInfos_suspect(String infos_suspect) {
		this.infos_suspect = infos_suspect;
	}
}
