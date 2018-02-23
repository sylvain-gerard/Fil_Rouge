package co.simplon.filrouge.controller;

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

import co.simplon.filrouge.model.Affaire;
import co.simplon.filrouge.service.AffaireService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AffaireController {

	@Autowired
	private AffaireService affaireService;

	@GetMapping(path = "/affaires")
	public @ResponseBody Iterable<Affaire> getAllAffaires() throws Exception {
		return affaireService.getAllAffaires();
	}

	@GetMapping(path = "/affaire/{id}")
	public @ResponseBody Affaire getAffaire(@PathVariable Long id) throws Exception {
		return affaireService.getAffaire(id);
	}

	@DeleteMapping(path = "/affaire/{id}")
	public @ResponseBody void deleteAffaire(@PathVariable Long id) {
		affaireService.delete(id);
	}

	@PostMapping(path = "/affaires")
	public ResponseEntity<?> createAffaire(@RequestBody Affaire affaire) throws Exception {
		Affaire newAffaire = affaireService.addAffaire(affaire);
		return ResponseEntity.status(HttpStatus.CREATED).body(newAffaire);
	}

	@PutMapping(path = "/affaires")
	public ResponseEntity<?> updateAffaire(@RequestBody Affaire affaire) throws Exception {
		Affaire updateAffaire = affaireService.addAffaire(affaire);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateAffaire);
	}
}
