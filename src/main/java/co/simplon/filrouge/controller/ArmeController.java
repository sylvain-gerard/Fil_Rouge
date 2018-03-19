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

import co.simplon.filrouge.model.Arme;
import co.simplon.filrouge.repository.ArmeRepository;
import co.simplon.filrouge.service.ArmeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ArmeController {

	@Autowired
	private ArmeService armeService;

	@Autowired
	private ArmeRepository armeRepository;

	@GetMapping(path = "/armes")
	public @ResponseBody Iterable<Arme> getAllArmes() throws Exception {
		return armeService.getAllArmes();
	}

	@GetMapping(path = "/arme/{id}")
	// public @ResponseBody Arme getArme(@PathVariable Long id) throws Exception {
	// return armeService.getArme(id);
	ResponseEntity<Arme> getAffaire(@PathVariable(value = "id") long id) {
		Arme arme = armeRepository.findOne(id);
		if (arme == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(arme);
	}

	@DeleteMapping(path = "/arme/{id}")
	// public @ResponseBody void deleteArme(@PathVariable Long id) {
	// armeService.delete(id);
	// }
	ResponseEntity<Arme> deleteArme(@PathVariable(value = "id") long id) {
		Arme arme = armeRepository.findOne(id);
		if (arme == null)
			return ResponseEntity.notFound().build();

		armeRepository.delete(arme);
		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/armes")
	// public ResponseEntity<?> createArme(@RequestBody Arme arme) throws Exception
	// {
	// Arme newArme = armeService.addArme(arme);
	// return ResponseEntity.status(HttpStatus.CREATED).body(newArme);
	// }
	Arme addArme(@Valid @RequestBody Arme arme) {
		return armeRepository.save(arme);
	}

	@PutMapping(path = "/armes/{id}")
	// public ResponseEntity<?> updateArme(@RequestBody Arme arme) throws Exception
	// {
	// Arme updateArme = armeService.addArme(arme);
	// return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateArme);
	// }
	ResponseEntity<Arme> updateArme(@PathVariable(value = "id") long id, @Valid @RequestBody Arme arme) {
		Arme armeToUpdate = armeRepository.findOne(id);
		if (armeToUpdate == null)
			return ResponseEntity.notFound().build();

		// Mise à jour des attributs non null
		if (arme.getType() != null)
			armeToUpdate.setType(arme.getType());

		if (arme.getMarque() != null)
			armeToUpdate.setMarque(arme.getMarque());
		
		if (arme.getModele() != null)
			armeToUpdate.setModele(arme.getModele());

		if (arme.getInfos_complementaire() != null)
			armeToUpdate.setInfos_complementaire(arme.getInfos_complementaire());

		if (arme.getCalibre() != null)
			armeToUpdate.setCalibre(arme.getCalibre());

		if (arme.getNumero_serie() != null)
			armeToUpdate.setNumero_serie(arme.getNumero_serie());

		Arme updatedArme = armeRepository.save(armeToUpdate);
		return ResponseEntity.ok(updatedArme);
	}

}
