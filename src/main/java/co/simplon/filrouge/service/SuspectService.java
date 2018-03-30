package co.simplon.filrouge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.simplon.filrouge.model.Suspect;
import co.simplon.filrouge.repository.SuspectRepository;
/**
 * 
 * @author Sylvain
 *
 */
@Service
public class SuspectService {

	@Autowired
	private SuspectRepository suspectRepository;

	public Iterable<Suspect> getAllSuspects() throws Exception {
		return suspectRepository.findAll();
	}

	public Suspect getSuspect(Long id) throws Exception {
		return suspectRepository.findOne(id);
	}

	public void deleteSuspect(Long id) throws Exception {
		suspectRepository.delete(id);
	}

	public Suspect addSuspect(Suspect suspect) throws Exception {
		return suspectRepository.save(suspect);
	}

	public Suspect editSuspect(Suspect suspect) throws Exception {
		return suspectRepository.save(suspect);
	}

}
