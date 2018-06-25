package co.simplon.filrouge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
//@Transactional
//@Rollback(true)
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = FilRougeApplication.class)
public class UtilisateurCrudTest {

	private Utilisateur utilisateur;
	private Utilisateur updatedUtilisateur;
	private ResponseEntity<?> newUtilisateur;
	private Utilisateur deletedUtilisateur;

	@Mock
	private UtilisateurRepository utilisateurRepository;
	
	@InjectMocks
	private UtilisateurService utilisateurService;

	@Before
	public void initUtilisateur() throws Exception {
		MockitoAnnotations.initMocks(this);
		utilisateur = new Utilisateur();
		//updatedUtilisateur = new Utilisateur();
	}
	
	@Test
	public void getUtilisateurTestOK() throws Exception {
		//Given
		Mockito.when(utilisateurRepository.findOne(1L)).thenReturn(utilisateur);	
		// When
		Utilisateur tested = utilisateurService.getUtilisateur(1L);
		// Then
		assertEquals(utilisateur, tested);
		Mockito.verify(utilisateurRepository).findOne(1L);//vérifie le repo utilise la methode UNE seule fois
		Mockito.verifyNoMoreInteractions(utilisateurRepository);//vérifie que le repo n'a fait que cette méthode
		
	}
	
	@Test
	public void testInsertUtilisateur() throws Exception {

		//Given
		utilisateur = createMock("Test", "Test");
		Mockito.when(utilisateurRepository.save(utilisateur)).thenReturn(utilisateur);
		// When
		Utilisateur newUser = utilisateurService.addUtilisateur(utilisateur);
		// Then
		assertEquals("Test", newUser.getNom());
		assertEquals("Test", newUser.getPrenom());
		Mockito.verify(utilisateurRepository).save(utilisateur);
		Mockito.verifyNoMoreInteractions(utilisateurRepository);
	
	}

	@Test
	public void testUpdateUtilisateur() throws Exception {
		//Given
		utilisateur = createMock("Lulu", "Berlu");
		updatedUtilisateur = createMock("NOM", "PRENOM");
		Mockito.when(utilisateurRepository.save(updatedUtilisateur)).thenReturn(updatedUtilisateur);
		// When
		Utilisateur newUser = utilisateurService.editUtilisateur(updatedUtilisateur);
		// Then
		assertEquals("NOM", newUser.getNom());
		assertEquals("PRENOM", newUser.getPrenom());
	}
	
	

	
//	@Test
//	public void testDeleteUtilisateur() {
//		
//		//Given
//		deletedUtilisateur = createMock("Test", "Test");
//		deletedUtilisateur.setId(1L);
//		//When
//				
//		//Then
//		try {
//			utilisateur = createMock("Test", "Test");
//			deletedUtilisateur = utilisateurController.createUtilisateur(utilisateur);
//			deletedUtilisateur = utilisateurController.deleteUtilisateur((long) 1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		assertTrue(deletedUtilisateur.getBody() == null);
//	}

	private Utilisateur createMock(String nom, String prenom) {
		Utilisateur mock = new Utilisateur();
		mock.setNom(nom);
		mock.setPrenom(prenom);
		mock.setId(1L);

		return mock;
	}

}
