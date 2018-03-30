package co.simplon.filrouge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.simplon.filrouge.model.Suspect;
/**
 * 
 * @author Sylvain
 *
 */
@Repository
public interface SuspectRepository extends CrudRepository<Suspect, Long> {

}
