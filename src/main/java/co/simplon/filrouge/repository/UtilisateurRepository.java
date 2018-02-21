package co.simplon.filrouge.repository;

import org.springframework.data.repository.CrudRepository;
import co.simplon.filrouge.model.Utilisateur;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

}
