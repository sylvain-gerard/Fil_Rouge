package co.simplon.filrouge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.simplon.filrouge.model.Utilisateur;
import co.simplon.filrouge.repository.UtilisateurRepository;


@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository ;
	
	public Iterable<Utilisateur> getAllUtilisateurs() throws Exception {
		// return utilisateurDAO.listUtilisateurs();
		return utilisateurRepository.findAll();
	}

	public Utilisateur getUtilisateur(Long id) throws Exception {
		// return utilisateurDAO.affichertUtilisateur(id);
		return utilisateurRepository.findOne(id);
	}
		
	public void delete(Long id) {
		utilisateurRepository.delete(id);
	}

	public Utilisateur addUtilisateur(Utilisateur user) throws Exception {		
		return utilisateurRepository.save(user);
	}

	public Utilisateur editUtilisateur(Utilisateur user)  throws Exception {
		return utilisateurRepository.save(user);
	}

}
