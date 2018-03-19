package co.simplon.filrouge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import co.simplon.filrouge.repository.AffaireRepository;
import co.simplon.filrouge.service.AffaireService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AffaireController {

	@Autowired
	private AffaireRepository affaireRepository;
	@Autowired
	private AffaireService affaireService;

	@GetMapping(path = "/affaires")
	public @ResponseBody Iterable<Affaire> getAllAffaires() throws Exception {
		return affaireService.getAllAffaires();
	}

	@GetMapping(path = "/affaire/{id}")
	// public @ResponseBody Affaire getAffaire(@PathVariable Long id) throws
	// Exception {
	// return affaireService.getAffaire(id);

	ResponseEntity<Affaire> getAffaire(@PathVariable(value = "id") long id) {
		Affaire affaire = affaireRepository.findOne(id);
		if (affaire == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(affaire);

	}

	@DeleteMapping(path = "/affaire/{id}")
	// public @ResponseBody void deleteAffaire(@PathVariable Long id) {
	// affaireService.delete(id);
	ResponseEntity<Affaire> deleteAffaire(@PathVariable(value = "id") long id) {
		Affaire affaire = affaireRepository.findOne(id);
		if (affaire == null)
			return ResponseEntity.notFound().build();

		affaireRepository.delete(affaire);
		return ResponseEntity.ok().build();
	}
	// }

	@PostMapping(path = "/affaires")
	// public ResponseEntity<?> createAffaire(@RequestBody Affaire affaire) throws
	// Exception {
	// Affaire newAffaire = affaireService.addAffaire(affaire);
	// return ResponseEntity.status(HttpStatus.CREATED).body(newAffaire);
	Affaire addAffaire(@Valid @RequestBody Affaire affaire) {
		return affaireRepository.save(affaire);
	}

	@PutMapping(path = "/affaire/{id}")
	// public ResponseEntity<Affaire> updateAffaire(@PathVariable Long id,
	// @RequestBody Affaire affaire) throws Exception {
	// Affaire updateAffaire = affaireService.addAffaire(affaire);
	// return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateAffaire);
	// }
	ResponseEntity<Affaire> updateAffaire(@PathVariable(value = "id") long id, @Valid @RequestBody Affaire affaire) {
		Affaire affaireAModifier = affaireRepository.findOne(id);
		if (affaireAModifier == null)
			return ResponseEntity.notFound().build();

		// Mise à jour des attributs obligatoires
		affaireAModifier.setNom_affaire(affaire.getNom_affaire());
		affaireAModifier.setDate_creation(affaire.getDate_creation());

		// Mise à jour des attributs non null
		if (affaire.getDate_cloture() != null)
			affaireAModifier.setDate_cloture(affaire.getDate_cloture());

		if (affaire.getPieces_conviction() != null)
			affaireAModifier.setPieces_conviction(affaire.getPieces_conviction());

		if (affaire.getArme() != null)
			affaireAModifier.setArme(affaire.getArme());

		if (affaire.getVehicule() != null)
			affaireAModifier.setVehicule(affaire.getVehicule());

		if (affaire.getSuspect() != null)
			affaireAModifier.setSuspect(affaire.getSuspect());

		Affaire affaireModifiee = affaireRepository.save(affaireAModifier);
		return ResponseEntity.ok(affaireModifiee);
	}
}
