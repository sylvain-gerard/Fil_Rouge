package co.simplon.filrouge;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.simplon.filrouge.controller.UtilisateurController;
import co.simplon.filrouge.model.Utilisateur;
import co.simplon.filrouge.service.UtilisateurService;
/**
 * 
 * @author Sylvain
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value=UtilisateurController.class, secure=false)
public class UtilisateurControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UtilisateurService utilisateurService;
	
	@Test
	public void getUtilisateurOK() throws Exception {
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(1L);
		utilisateur.setNom("nomTest");
		
		Mockito.when(utilisateurService.getUtilisateur(1L)).thenReturn(utilisateur);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/utilisateur/1").accept(MediaType.APPLICATION_JSON);
	       
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
       
        System.out.println(result.getResponse());
        String expected = "{id:1, nom:nomTest}";
       
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void getutilisateurKO_ID_inexistant() throws Exception {
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(999L);
		
		Mockito.when(utilisateurService.getUtilisateur(999L)).thenReturn(utilisateur);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/utilisateur/999").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	       
        System.out.println(result.getResponse());
        String expected = "{}";
        
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}
	
	@Test
	public void getAllUtilisateursOK() throws Exception {
		
		List<Utilisateur> listUtil = new ArrayList<Utilisateur>();
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId(1L);
		utilisateur1.setNom("nom1");
		
		Utilisateur utilisateur2 = new Utilisateur();
		utilisateur2.setId(2L);
		utilisateur2.setNom("nom2");
		
		listUtil.add(utilisateur1);
		listUtil.add(utilisateur2);
		
		Mockito.when(utilisateurService.getAllUtilisateurs()).thenReturn(listUtil);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/utilisateurs/").accept(MediaType.APPLICATION_JSON);		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
        String expected = "[{id: 1, nom:nom1},{id: 2, nom:nom2}]";       
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}
	
}
