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

import co.simplon.filrouge.controller.AffaireController;
import co.simplon.filrouge.dao.AffaireDAO;
import co.simplon.filrouge.model.Affaire;
import co.simplon.filrouge.service.AffaireService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=AffaireController.class, secure=false)
public class AffaireControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AffaireService affaireService;
	
	@MockBean
	private AffaireDAO affaireDAO;
	
	@Test
    public void getAffaireByTeIdTest() throws Exception {
		
        Affaire affaire = new Affaire();
        affaire.setId_affaire((long) 1);
        affaire.setNom_affaire("Test");;
        
        Mockito.when(affaireService.getAffaire((long) 1)).thenReturn(affaire);
       
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/affaire/1").accept(MediaType.APPLICATION_JSON);
       
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
       
        System.out.println(result.getResponse());
        String expected = "{id_affaire:1, nom_affaire:Test}";
       
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
       
    }
	
}