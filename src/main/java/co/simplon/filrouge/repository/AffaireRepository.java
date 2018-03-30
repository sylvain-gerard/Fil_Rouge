package co.simplon.filrouge.repository;

import co.simplon.filrouge.model.Affaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author Sylvain
 *
 */
@Repository
public interface AffaireRepository extends JpaRepository<Affaire, Long> {

}
