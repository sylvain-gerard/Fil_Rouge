package co.simplon.filrouge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import co.simplon.filrouge.controller.UtilisateurController;
import co.simplon.filrouge.model.Utilisateur;
import co.simplon.filrouge.repository.UtilisateurRepository;
import co.simplon.filrouge.service.UtilisateurService;

/**
 * 
 * @author Sylvain
 *
 */
@Transactional
@Rollback(true)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FilRougeApplication.class)
public class UtilisateurCrudTest {
	
	static Utilisateur utilisateur;
	static Utilisateur updatedUtilisateur;
	static UtilisateurService utilisateurService;
	static ResponseEntity<?> newUtilisateur;
	static ResponseEntity<?> deletedUtilisateur;
	
	@Autowired
	private UtilisateurController utilisateurController;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@BeforeClass
	public static void initUtilisateur() throws Exception{
		utilisateurService = new UtilisateurService();
		utilisateur = new Utilisateur();
	}
		
    @Test
	public void testUpdateUtilisateur() {

		updatedUtilisateur = null;
		utilisateur = createMock("Lulu", "Berlu");
		
		try {
			updatedUtilisateur = utilisateurRepository.save(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(updatedUtilisateur != null);
		assertEquals("Lulu", updatedUtilisateur.getNom());
	}
		
	@Test
	public void testInsertUtilisateur() {
		
		try {
			utilisateur = createMock("Test", "Test");
			newUtilisateur = utilisateurController.createUtilisateur(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(newUtilisateur != null);
	}
	
	@Test
	public void testDeleteUtilisateur() {
		try {
			utilisateur = createMock("Test", "Test");
			deletedUtilisateur = utilisateurController.createUtilisateur(utilisateur);
			deletedUtilisateur = utilisateurController.deleteUtilisateur((long) 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(deletedUtilisateur.getBody() == null);
	}
	
	private Utilisateur createMock(String nom, String prenom) {
		Utilisateur mock = new Utilisateur();
		mock.setNom(nom);
		mock.setPrenom(prenom);
     	mock.setId(new Long(1));

		return mock;
	}

}
