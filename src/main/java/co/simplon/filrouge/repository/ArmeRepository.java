package co.simplon.filrouge.repository;

import co.simplon.filrouge.model.Arme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmeRepository extends JpaRepository<Arme, Long> {

}
