package co.simplon.filrouge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.simplon.filrouge.model.Arme;
import co.simplon.filrouge.repository.ArmeRepository;

@Service
public class ArmeService {

	@Autowired
	private ArmeRepository armeRepository;

	public Iterable<Arme> recupererToutesLesArmes() throws Exception {
		return armeRepository.findAll();
	}

	public Arme recupererArme(Long id) throws Exception {
		return armeRepository.findOne(id);
	}

	public void supprimerArme(Long id) {
		armeRepository.delete(id);
	}

	public Arme ajouterArme(Arme arme) throws Exception {
		return armeRepository.save(arme);
	}

	public Arme miseAJourArme(Long id, Arme arme) throws Exception {
		return armeRepository.save(arme);
	}

	public void clearArmeTable() {
		armeRepository.deleteAll();
		;
	}
}
