package co.simplon.filrouge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.filrouge.model.Affaire;
import co.simplon.filrouge.service.AffaireService;

@RestController
@RequestMapping("/api")
public class AffaireController {

	@Autowired
	private AffaireService affaireService;
	
	@GetMapping(path="/affaires")
	public @ResponseBody Iterable<Affaire> getAllAffaires() throws Exception{
		return affaireService.getAllAffaires();		
	}
	
	@GetMapping(path="/affaire/{id}")
	public @ResponseBody Affaire getAffaire(@PathVariable Long id) throws Exception{
		return affaireService.getAffaire(id);		
	}
	
	@DeleteMapping(path="/affaire/delete/{id}")
	public @ResponseBody void deleteAffaire(@PathVariable Long id) {
		affaireService.delete(id);
	}
	
	@PostMapping(path="/affaire/add")
	public Affaire createAffaire(Affaire affaire) throws Exception{
		return affaireService.addAffaire(affaire);
	}
	
	@PutMapping(path="/affaire/update")
	public Affaire updateAffaire(Affaire affaire) throws Exception{
		return affaireService.editAffaire(affaire);
	}
}
