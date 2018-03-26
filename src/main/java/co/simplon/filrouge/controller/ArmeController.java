package co.simplon.filrouge.controller;

import java.util.List;

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

import co.simplon.filrouge.dao.ArmeDAO;
import co.simplon.filrouge.model.AffaireLien;
import co.simplon.filrouge.model.Arme;
import co.simplon.filrouge.service.ArmeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ArmeController {

	@Autowired
	private ArmeService armeService;
	@Autowired
	private ArmeDAO armeDAO;

	// exemple en SQL :
	// SELECT * FROM arme;
	@GetMapping(path = "/armes")
	public @ResponseBody Iterable<Arme> getAllArmes() throws Exception {
		return armeService.recupererToutesLesArmes();
	}

	@GetMapping(path = "/armes/{recherche}")
	public ResponseEntity<List<Arme>> recupererArmesTriees(@PathVariable(value = "recherche") String recherche)
			throws Exception {
		// @RequestParam(required = false, value="marque") String marque

		List<Arme> listeArme = armeDAO.recupererArmesTriees(recherche);
		if (listeArme == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listeArme);

	}

	// exemple en SQL :
	// SELECT * FROM arme WHERE id=3;
	@GetMapping(path = "/arme/{id}")
	ResponseEntity<Arme> recupererArme(@PathVariable(value = "id") long id) throws Exception {
		Arme arme = armeService.recupererArme(id);
		if (arme == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(arme);
	}

	// exemple en SQL :
	// DELETE FROM arme WHERE id=3;
	@DeleteMapping(path = "/arme/{id}")
	ResponseEntity<Arme> supprimerArme(@PathVariable(value = "id") long id) throws Exception {
		Arme arme = armeService.recupererArme(id);
		if (arme == null)
			return ResponseEntity.notFound().build();

		armeService.supprimerArme(id);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping(path = "/affaire/{id}/arme/{id_arme}")
	ResponseEntity<?> supprimerArmeAffaire(@Valid @PathVariable(value = "id_affaire") long id_affaire,
			@Valid @PathVariable(value = "id_arme") long id_arme) throws Exception {
		armeDAO.supprimerArmeAffaire(id_affaire, id_arme);

		return ResponseEntity.ok().build();
	}

	// exemple en SQL :
	// INSERT INTO arme (`marque`, `modele`, `type`, `calibre`, `numero_serie`,
	// `infos_complementaire`) VALUES ('Berretta', '93', 'Pistolet', '9mm', '1235TYU678', '');
	@PostMapping(path = "/armes")
	Arme ajouterArme(@Valid @RequestBody Arme arme) throws Exception {
		return armeService.ajouterArme(arme);
	}

	@PostMapping(path = "/affaire/lierArme")
	void lierArmeAffaire(@Valid @RequestBody AffaireLien affaireLien) throws Exception {
		long id_affaire = affaireLien.getIdAffaire();
		long id_arme = affaireLien.getIdObjet();
		armeDAO.lierArmeAffaire(id_affaire, id_arme);
		return;

	}

	// exemple en SQL :
	// UPDATE arme SET `marque` = "Berretta", `modele` = "92S" WHERE id = 3;
	@PutMapping(path = "/arme/{id}")
	ResponseEntity<Arme> miseAJourArme(@PathVariable(value = "id") long id, @Valid @RequestBody Arme arme)
			throws Exception {
		Arme armeAModifier = armeService.recupererArme(id);
		if (armeAModifier == null)
			return ResponseEntity.notFound().build();

		// Mise à jour des attributs obligatoires
		armeAModifier.setId(arme.getId());

		// Mise à jour des attributs non null
		if (arme.getType() != null)
			armeAModifier.setType(arme.getType());

		if (arme.getMarque() != null)
			armeAModifier.setMarque(arme.getMarque());

		if (arme.getModele() != null)
			armeAModifier.setModele(arme.getModele());

		if (arme.getInfos_complementaire() != null)
			armeAModifier.setInfos_complementaire(arme.getInfos_complementaire());

		if (arme.getCalibre() != null)
			armeAModifier.setCalibre(arme.getCalibre());

		if (arme.getNumero_serie() != null)
			armeAModifier.setNumero_serie(arme.getNumero_serie());

		Arme armeModifiee = armeService.miseAJourArme(id, armeAModifier);
		return ResponseEntity.ok(armeModifiee);
	}

}
