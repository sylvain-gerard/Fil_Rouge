package co.simplon.filrouge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.filrouge.model.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long>{

}