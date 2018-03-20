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

import co.simplon.filrouge.model.Vehicule;
import co.simplon.filrouge.service.VehiculeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VehiculeController {

	@Autowired
	private VehiculeService vehiculeService;

	@GetMapping(path = "/vehicules")
	public @ResponseBody Iterable<Vehicule> getAllVehicules() throws Exception {
		return vehiculeService.getAllVehicules();
	}

	@GetMapping(path = "/vehicule/{id}")
	public @ResponseBody Vehicule getVehicule(@PathVariable long id) throws Exception {
		return vehiculeService.getVehicule(id);
	}

	@DeleteMapping(path = "/vehicule/{id}")
	public @ResponseBody void deleteVehicule(@PathVariable long id) {
		vehiculeService.delete(id);
	}

	@PostMapping(path = "/vehicules")
	public ResponseEntity<?> createVehicule(@RequestBody Vehicule vehicule) throws Exception {
		Vehicule newVehicule = vehiculeService.addVehicule(vehicule);
		return ResponseEntity.status(HttpStatus.CREATED).body(newVehicule);
	}

	@PutMapping(path = "/vehicule/{id}")
	ResponseEntity<Vehicule> updateVehicule(@PathVariable(value = "id") long id, @Valid @RequestBody Vehicule vehicule) throws Exception {
		Vehicule vehiculeAModifier = vehiculeService.getVehicule(id);
		if (vehiculeAModifier == null)
			return ResponseEntity.notFound().build();

		// Mise à jour des attributs obligatoires
		vehiculeAModifier.setId(vehicule.getId());
		
		// Mise à jour des attributs non null
		if (vehicule.getType() != null)
			vehiculeAModifier.setType(vehicule.getType());

		if (vehicule.getMarque() != null)
			vehiculeAModifier.setMarque(vehicule.getMarque());
		
		if (vehicule.getModele() != null)
			vehiculeAModifier.setModele(vehicule.getModele());

		if (vehicule.getInfos_complementaire() != null)
			vehiculeAModifier.setInfos_complementaire(vehicule.getInfos_complementaire());

		if (vehicule.getImmatriculation() != null)
			vehiculeAModifier.setImmatriculation(vehicule.getImmatriculation());

		if (vehicule.getCouleur_vehicule() != null)
			vehiculeAModifier.setCouleur_vehicule(vehicule.getCouleur_vehicule());

		Vehicule vehiculeModifiee = vehiculeService.editVehicule(id, vehiculeAModifier);
		return ResponseEntity.ok(vehiculeModifiee);
	}

}
