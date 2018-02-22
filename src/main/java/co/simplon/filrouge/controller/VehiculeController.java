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

import co.simplon.filrouge.model.Vehicule;
import co.simplon.filrouge.service.VehiculeService;

@RestController
@RequestMapping("/api")
public class VehiculeController {
	
	@Autowired
	private VehiculeService vehiculeService;
	
	@GetMapping(path="/vehicules")
	public @ResponseBody Iterable<Vehicule> getAllVehicules() throws Exception{
		return vehiculeService.getAllVehicules();		
	}
	
	@GetMapping(path="/vehicule/{id}")
	public @ResponseBody Vehicule getVehicule(@PathVariable Long id) throws Exception{
		return vehiculeService.getVehicule(id);		
	}
	
	@DeleteMapping(path="/vehicule/delete/{id}")
	public @ResponseBody void deleteVehicule(@PathVariable Long id) {
		vehiculeService.delete(id);
	}
	
	@PostMapping(path="/vehicules")
	public ResponseEntity<?> createVehicule(@RequestBody Vehicule vehicule) throws Exception{
		Vehicule newVehicule = vehiculeService.addVehicule(vehicule);
		return ResponseEntity.status(HttpStatus.CREATED).body(newVehicule);
	}
	
	@PutMapping(path="/vehicules")
	public ResponseEntity<?> updateVehicule(@RequestBody Vehicule vehicule) throws Exception{
		Vehicule updateVehicule = vehiculeService.addVehicule(vehicule);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateVehicule);
	}

}
