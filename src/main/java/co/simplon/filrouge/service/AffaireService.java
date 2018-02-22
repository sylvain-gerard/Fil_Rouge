package co.simplon.filrouge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.filrouge.model.Affaire;
import co.simplon.filrouge.repository.AffaireRepository;

@Service
public class AffaireService {

	@Autowired
	private AffaireRepository affaireRepository ;
	
	public Iterable<Affaire> getAllAffaires() throws Exception {
		// return affaireDAO.listAffaires();
		return affaireRepository.findAll();
	}
	public Affaire getAffaire(Long id) throws Exception {
		// return affaireDAO.affichertAffaire(id);
		return affaireRepository.findOne(id);
	}
		
	public void delete(Long id) {
		affaireRepository.delete(id);
	}

	public Affaire addAffaire(Affaire affaire) throws Exception {		
		return affaireRepository.save(affaire);
	}

	public Affaire editAffaire(Affaire affaire)  throws Exception {
		return affaireRepository.save(affaire);
	}
	
	public void clearAffaireTable() {
		affaireRepository.deleteAll();;
	}

}
