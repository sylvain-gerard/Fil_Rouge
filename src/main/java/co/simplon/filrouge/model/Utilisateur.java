package co.simplon.filrouge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * bean Utilisateur
 */
@Entity
@Table(name="utilisateur")
public class Utilisateur extends Humain implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//@Column(nullable = false)
	private String matricule;
	//@Column(nullable = false)
	private String password;
	//@Column(nullable = false)
	private String habilitation;
	
	public Utilisateur() {
	}
	
//	public Utilisateur(String nom, String prenom, String matricule, String password, String habilitation) {
//		super(nom, prenom);
//		this.matricule = matricule;
//		this.password = password;
//		this.habilitation = habilitation;
//	}
	
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
	
	@Override
	public String toString() {
		return "Utilisateur [matricule=" + matricule + ", password=" + password + ", habilitation=" + habilitation
				+ "]";
	}
	
}
