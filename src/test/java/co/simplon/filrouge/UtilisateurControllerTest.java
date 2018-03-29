package co.simplon.filrouge;

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
		utilisateur.setId((long) 1);
		utilisateur.setNom("nomTest");
		
		Mockito.when(utilisateurService.getUtilisateur((long) 1)).thenReturn(utilisateur);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/utilisateur/1").accept(MediaType.APPLICATION_JSON);
	       
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
       
        System.out.println(result.getResponse());
        String expected = "{id:1, nom:nomTest}";
       
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
}
