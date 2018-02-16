package co.simplon.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.filrouge.dao.UtilisateurDAO;
import co.simplon.filrouge.model.Utilisateur;


@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
	public List<Utilisateur> getAllUtilisateurs() throws Exception {
		return utilisateurDAO.listUtilisateurs();
	}


}
