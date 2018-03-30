package co.simplon.filrouge.model;

import java.io.Serializable;

public class AffaireLien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idAffaire;
	private long idObjet;

	public long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(long id_affaire) {
		this.idAffaire = id_affaire;
	}

	public long getIdObjet() {
		return idObjet;
	}

	public void setIdObjet(long id_objet) {
		this.idObjet = id_objet;
	}

}
