package co.simplon.filrouge.dao;

import java.util.List;

import co.simplon.filrouge.model.Utilisateur;

public interface UtilisateurDAO {

	public List<Utilisateur> listUtilisateurs() throws Exception;

	public Utilisateur affichertUtilisateur(Long id) throws Exception;

}
