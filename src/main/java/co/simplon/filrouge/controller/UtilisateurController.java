package co.simplon.filrouge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.filrouge.model.Utilisateur;
import co.simplon.filrouge.service.UtilisateurService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping(path = "/utilisateurs")
	public @ResponseBody Iterable<Utilisateur> getAllUtilisateurs() throws Exception {
		return utilisateurService.getAllUtilisateurs();
	}

	@GetMapping(path = "/utilisateur/{id}")
	public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable Long id) throws Exception {
		Utilisateur utilisateur = utilisateurService.getUtilisateur(id);
		if (utilisateur == null) {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
		return ResponseEntity.status(HttpStatus.OK).body(utilisateur);
		}
		
	}

	@DeleteMapping(path = "/utilisateur/{id}")
	public ResponseEntity<Utilisateur> deleteUtilisateur(@PathVariable Long id) throws Exception {
		Utilisateur utilisateur = utilisateurService.getUtilisateur(id);
		if (utilisateur == null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		else {
			utilisateurService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).build();
			}
	}

	@PostMapping(path = "/utilisateurs")
	public ResponseEntity<?> createUtilisateur(@Valid @RequestBody Utilisateur user) throws Exception {
		Utilisateur newUser = utilisateurService.addUtilisateur(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}

	@PutMapping(path = "/utilisateur/{id}")
	public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id,@Valid @RequestBody Utilisateur user) throws Exception {
		Utilisateur utilisateur = utilisateurService.getUtilisateur(id);
		if (utilisateur == null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
	
		if(user.getNom()!=null)
			utilisateur.setNom(user.getNom());
		if(user.getPrenom()!=null)
			utilisateur.setPrenom(user.getPrenom());
		if(user.getMatricule()!=null);		
			utilisateur.setMatricule(user.getMatricule());
		if(user.getPassword()!=null)
			utilisateur.setPassword(user.getPassword());
		if(user.getHabilitation()!=null)
			utilisateur.setHabilitation(user.getHabilitation());
		
		Utilisateur updatedUser = utilisateurService.editUtilisateur(utilisateur);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
	}
}
