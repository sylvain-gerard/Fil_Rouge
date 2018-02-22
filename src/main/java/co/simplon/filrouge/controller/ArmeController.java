package co.simplon.filrouge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import co.simplon.filrouge.service.ArmeService;

@RestController
@RequestMapping("/api")
public class ArmeController {
	
	@Autowired
	private ArmeService armeService;
	
	@GetMapping(path="/armes")
	public @ResponseBody Iterable<Arme> getAllArmes() throws Exception{
		return armeService.getAllArmes();		
	}
	
	@GetMapping(path="/arme/{id}")
	public @ResponseBody Arme getArme(@PathVariable Long id) throws Exception{
		return armeService.getArme(id);		
	}
	
	@DeleteMapping(path="/arme/{id}")
	public @ResponseBody void deleteArme(@PathVariable Long id) {
		armeService.delete(id);
	}
	
	@PostMapping(path="/armes")
	public ResponseEntity<?> createArme(@RequestBody Arme arme) throws Exception{
		Arme newArme = armeService.addArme(arme);
		return ResponseEntity.status(HttpStatus.CREATED).body(newArme);
	}
	
	@PutMapping(path="/armes")
	public ResponseEntity<?> updateArme(@RequestBody Arme arme) throws Exception{
		Arme updateArme = armeService.addArme(arme);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateArme);
	}

}
