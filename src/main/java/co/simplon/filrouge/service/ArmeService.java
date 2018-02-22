package co.simplon.filrouge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.filrouge.model.Arme;
import co.simplon.filrouge.repository.ArmeRepository;

@Service
public class ArmeService {

	@Autowired
	private ArmeRepository armeRepository ;
	
	public Iterable<Arme> getAllArmes() throws Exception {
		// return armeDAO.listArmes();
		return armeRepository.findAll();
	}
	public Arme getArme(Long id) throws Exception {
		// return armeDAO.affichertArme(id);
		return armeRepository.findOne(id);
	}
		
	public void delete(Long id) {
		armeRepository.delete(id);
	}

	public Arme addArme(Arme arme) throws Exception {		
		return armeRepository.save(arme);
	}

	public Arme editArme(Arme arme)  throws Exception {
		return armeRepository.save(arme);
	}
	
	public void clearArmeTable() {
		armeRepository.deleteAll();;
	}
}
