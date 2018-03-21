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

import co.simplon.filrouge.model.Suspect;
import co.simplon.filrouge.service.SuspectService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SuspectController {

	@Autowired
	private SuspectService suspectService;
	
	@GetMapping(path = "/suspects")
	public @ResponseBody Iterable<Suspect> getAllSuspects() throws Exception {
		return suspectService.getAllSuspects(); //SELECT * FROM suspect;
	}

	@GetMapping(path = "/suspect/{id}")
	public ResponseEntity<Suspect> getSuspect(@PathVariable Long id) throws Exception {
		Suspect suspect = suspectService.getSuspect(id); //SELECT `nom`, `prenom`, `adn`, `adresse`, `date_naissance`, `infos_suspect`, `photo`, `poids`, `sexe`, `signes_particuliers`, `taille` FROM suspect WHERE `id`=id;
		if(suspect==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(suspect);
		}
	}

	@DeleteMapping(path = "/suspect/{id}")
	public ResponseEntity<Suspect> deleteSuspect(@PathVariable Long id) throws Exception {
		Suspect suspect = suspectService.getSuspect(id);//DELETE FROM suspect WHERE `id`=id;
		if(suspect==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			suspectService.deleteSuspect(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}

	@PostMapping(path = "/suspects")
	public ResponseEntity<Suspect> createSuspect(@Valid @RequestBody Suspect suspect) throws Exception {
		Suspect newSuspect = suspectService.addSuspect(suspect);//INSERT INTO `suspect` (`id`, `nom`, `prenom`, `adn`, `adresse`, `date_naissance`, `infos_suspect`, `photo`, `poids`, `sexe`, `signes_particuliers`, `taille`) VALUES (?,?,?,?,?,?,?,?,?,?,?);
		return ResponseEntity.status(HttpStatus.CREATED).body(newSuspect);
	}
	
	@PutMapping(path = "/suspect/{id}")
	public ResponseEntity<Suspect> updateSuspect(@PathVariable Long id,@Valid @RequestBody Suspect suspect) throws Exception {
		Suspect suspectToEdit = suspectService.getSuspect(id); //SELECT `nom`, `prenom`, `adn`, `adresse`, `date_naissance`, `infos_suspect`, `photo`, `poids`, `sexe`, `signes_particuliers`, `taille` FROM suspect WHERE `id`=id;
		if(suspect==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		if(suspect.getNom()!=null)
			suspectToEdit.setNom(suspect.getNom());
		if(suspect.getPrenom()!=null)
			suspectToEdit.setPrenom(suspect.getPrenom());
		if(suspect.getAdn()!=null)
			suspectToEdit.setAdn(suspect.getAdn());
		if(suspect.getAdresse()!=null)
			suspectToEdit.setAdresse(suspect.getAdresse());
		if(suspect.getDate_naissance()!=null)
			suspectToEdit.setDate_naissance(suspect.getDate_naissance());
		if(suspect.getInfos_suspect()!=null)
			suspectToEdit.setInfos_suspect(suspect.getInfos_suspect());
		if(suspect.getPhoto()!=null)
			suspectToEdit.setPhoto(suspect.getPhoto());
		if(suspect.getSexe()!=null)
			suspectToEdit.setSexe(suspect.getSexe());
		if(suspect.getSignes_particuliers()!=null)
			suspectToEdit.setSignes_particuliers(suspect.getSignes_particuliers());
				
		Suspect updatedSuspect = suspectService.editSuspect(suspectToEdit);//INSERT INTO `suspect` (`id`, `nom`, `prenom`, `adn`, `adresse`, `date_naissance`, `infos_suspect`, `photo`, `poids`, `sexe`, `signes_particuliers`, `taille`) VALUES (?,?,?,?,?,?,?,?,?,?,?);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedSuspect);
	}
}
