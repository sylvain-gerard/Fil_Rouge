package co.simplon.filrouge;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

import co.simplon.filrouge.model.Affaire;
import co.simplon.filrouge.model.Arme;
import co.simplon.filrouge.model.Vehicule;
import co.simplon.filrouge.repository.AffaireRepository;
import co.simplon.filrouge.repository.ArmeRepository;
import co.simplon.filrouge.repository.VehiculeRepository;

@SpringBootApplication
public class FilRougeApplication {
	
	@Autowired
    private ArmeRepository armeRepository;
	@Autowired
	private AffaireRepository affaireRepository;

	@Autowired
    private VehiculeRepository vehiculeRepository;

	public static void main(String[] args) {
		SpringApplication.run(FilRougeApplication.class, args);
	}
	//@Override
    public void run(String... args) throws Exception {
        // Cleanup database tables.
        //armeRepository.deleteAll();
//        List<Affaire> affaires= new ArrayList<Affaire>();
//        List<String> photos= new ArrayList<String>();
        //Arme arme = new Arme (1,"fusil","FN","FAMAS",affaires,"",photos,"5.56","1234");
        Arme arme = new Arme("5.56","1234");
        armeRepository.save(arme);
        Affaire affaire = new Affaire();
        affaireRepository.save(affaire);
        Vehicule vehicule = new Vehicule("AZE123RTY", "bleu");
        vehiculeRepository.save(vehicule);
    }
}
