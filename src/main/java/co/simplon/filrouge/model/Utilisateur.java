package co.simplon.filrouge.model;

import javax.persistence.Entity;

/**
 * bean Utilisateur
 */
@Entity
public class Utilisateur extends Humain{
	
	private String matricule;
	private String password;
	private String habilitation;
	
	public Utilisateur() {
	}
	
	public Utilisateur(String nom, String prenom, String matricule, String password, String habilitation) {
		super(nom, prenom);
		this.matricule = matricule;
		this.password = password;
		this.habilitation = habilitation;
	}
	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHabilitation() {
		return habilitation;
	}

	public void setHabilitation(String habilitation) {
		this.habilitation = habilitation;
	}
	
	
	
}
