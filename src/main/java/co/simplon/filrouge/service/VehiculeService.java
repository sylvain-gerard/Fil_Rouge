package co.simplon.filrouge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.filrouge.model.Vehicule;
import co.simplon.filrouge.repository.VehiculeRepository;


@Service
public class VehiculeService {
	@Autowired
	private VehiculeRepository vehiculeRepository ;
	
	public Iterable<Vehicule> getAllVehicules() throws Exception {
		// return vehiculeDAO.listVehicules();
		return vehiculeRepository.findAll();
	}
	public Vehicule getVehicule(Long id) throws Exception {
		// return vehiculeDAO.affichertVehicule(id);
		return vehiculeRepository.findOne(id);
	}
		
	public void delete(Long id) {
		vehiculeRepository.delete(id);
	}

	public Vehicule addVehicule(Vehicule vehicule) throws Exception {		
		return vehiculeRepository.save(vehicule);
	}

	public Vehicule editVehicule(Vehicule vehicule)  throws Exception {
		return vehiculeRepository.save(vehicule);
	}
	
	public void clearVehiculeTable() {
		vehiculeRepository.deleteAll();;
	}

}
