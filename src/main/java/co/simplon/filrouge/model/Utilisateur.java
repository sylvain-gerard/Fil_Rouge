package co.simplon.filrouge.model;

/**
 * bean Utilisateur
 */
public class Utilisateur extends Humain{
	
	private Long id_utilisateur;
	//private String nom_utilisateur; inutile si extends Humain
	//private String prenom_utilisateur; inutile si extends Humain
	private String matricule;
	private String password;
	private String habilitation;
	
	public Utilisateur() {
		super();
	}

	public Long getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	/*  inutile si extends Humain
	 * 
	public String getNom_utilisateur() {
		return nom_utilisateur;
	}

	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}

	public String getPrenom_utilisateur() {
		return prenom_utilisateur;
	}

	public void setPrenom_utilisateur(String prenom_utilisateur) {
		this.prenom_utilisateur = prenom_utilisateur;
	}
	 */
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
