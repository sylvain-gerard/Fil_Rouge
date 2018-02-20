package co.simplon.filrouge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.filrouge.model.Utilisateur;
import co.simplon.filrouge.service.UtilisateurService;



@RestController
@RequestMapping("/api")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	/**
	 * Get all the utilisateurs.
	 * @return a list with all the utilisateurs
	 * @throws Exception 
	 */
	@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUtilisateurs(){
		List<Utilisateur> listUtilisateur = null;
		try {
			listUtilisateur = utilisateurService.getAllUtilisateurs();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(listUtilisateur);
	}
	
	@RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUtilisateur(@PathVariable Long id){
		Utilisateur utilisateur = null;
				
		try {
			utilisateur =utilisateurService.getUtilisateur(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		if(utilisateur == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		return ResponseEntity.status(HttpStatus.OK).body(utilisateur);
	}
}
