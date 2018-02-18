package co.simplon.filrouge.model;

/**
 * bean Utilisateur
 */
public class Utilisateur extends Humain{
	
	private String matricule;
	private String password;
	private String habilitation;
	
	public Utilisateur() {
		super();
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
