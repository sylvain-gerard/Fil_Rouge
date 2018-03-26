package co.simplon.filrouge.controller;

import java.util.List;

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

import co.simplon.filrouge.dao.AffaireDAO;
import co.simplon.filrouge.model.Affaire;
import co.simplon.filrouge.model.Arme;
import co.simplon.filrouge.model.Suspect;
import co.simplon.filrouge.model.Vehicule;
import co.simplon.filrouge.service.AffaireService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AffaireController {

	@Autowired
	private AffaireService affaireService;
	@Autowired
	private AffaireDAO affaireDAO;

	@GetMapping(path = "/affaires")
	public @ResponseBody Iterable<Affaire> getAllAffaires() throws Exception {
		return affaireService.getAllAffaires();
	}

	@GetMapping(path = "/affaire/{id}")
	ResponseEntity<Affaire> getAffaire(@PathVariable(value = "id") long id) throws Exception {
		Affaire affaire = affaireService.getAffaire(id);
		if (affaire == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(affaire);

	}

	@DeleteMapping(path = "/affaire/{id}")
	ResponseEntity<Affaire> deleteAffaire(@PathVariable(value = "id") long id) throws Exception {
		Affaire affaire = affaireService.getAffaire(id);
		if (affaire == null)
			return ResponseEntity.notFound().build();

		affaireService.deleteAffaire(id);
		return ResponseEntity.ok().build();
	}
	// }

	@PostMapping(path = "/affaires")
	Affaire addAffaire(@Valid @RequestBody Affaire affaire) throws Exception {
		return affaireService.addAffaire(affaire);
	}

	@PutMapping(path = "/affaire/{id}")
	ResponseEntity<Affaire> updateAffaire(@PathVariable(value = "id") long id, @Valid @RequestBody Affaire affaire) throws Exception {
		Affaire affaireAModifier = affaireService.getAffaire(id);
		if (affaireAModifier == null)
			return ResponseEntity.notFound().build();

		// Mise à jour des attributs obligatoires
		affaireAModifier.setId_affaire(affaire.getId_affaire());
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

		Affaire affaireModifiee = affaireService.editAffaire(id, affaireAModifier);
		return ResponseEntity.ok(affaireModifiee);
	}
	
	@GetMapping(path = "/affaire/{id}/armes")
	public ResponseEntity<?> recupererArmesDeAffaire(@PathVariable(value = "id") long id) throws Exception {
		List<Arme> armes = 	null;
		Affaire affaire = affaireService.getAffaire(id);
		try {
		armes = affaireDAO.recupererArmesDeAffaire(id);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		if (affaire == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(armes);

		
	}
	
	@GetMapping(path = "/affaire/{id}/suspects")
	public ResponseEntity<?> recupererSuspectsDeAffaire(@PathVariable(value = "id") long id) throws Exception {
		List<Suspect> suspects = null;
		Affaire affaire = affaireService.getAffaire(id);
		try {
		suspects = affaireDAO.recupererSuspectsDeAffaire(id);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);			
		}
		if (affaire == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(suspects);

		
	}
	
	@GetMapping(path = "/affaire/{id}/vehicules")
	public ResponseEntity<?> recupererVehiculesDeAffaire(@PathVariable(value = "id") long id) throws Exception {
		List<Vehicule> vehicules = null;
		Affaire affaire = affaireService.getAffaire(id);
		try {
		vehicules = affaireDAO.recupererVehiculesDeAffaire(id);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		if (affaire == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(vehicules);
	}
}
