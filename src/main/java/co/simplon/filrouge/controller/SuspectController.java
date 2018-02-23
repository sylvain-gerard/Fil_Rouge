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
		return suspectService.getAllSuspects();
	}

	@GetMapping(path = "/suspect/{id}")
	public @ResponseBody Suspect getSuspect(@PathVariable Long id) throws Exception {
		return suspectService.getSuspect(id);
	}

	@DeleteMapping(path = "/suspect/{id}")
	public @ResponseBody void deleteSuspect(@PathVariable Long id) throws Exception {
		suspectService.deleteSuspect(id);
	}

	@PostMapping(path = "/suspects")
	public ResponseEntity<?> createSuspect(@RequestBody Suspect suspect) throws Exception {
		Suspect newSuspect = suspectService.addSuspect(suspect);
		return ResponseEntity.status(HttpStatus.CREATED).body(newSuspect);
	}

	@PutMapping(path = "/suspects")
	public ResponseEntity<?> updateSuspect(@RequestBody Suspect suspect) throws Exception {
		Suspect updatedSuspect = suspectService.editSuspect(suspect);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedSuspect);
	}
}
