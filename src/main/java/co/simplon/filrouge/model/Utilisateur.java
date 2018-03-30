package co.simplon.filrouge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur extends Humain implements Serializable {

	private static final long serialVersionUID = 1L;

	private String matricule;
	private String password;
	private String habilitation;

	public Utilisateur() {
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

	@Override
	public String toString() {
		return "Utilisateur [matricule=" + matricule + ", password=" + password + ", habilitation=" + habilitation
				+ "]";
	}

}
