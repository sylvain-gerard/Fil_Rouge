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

import co.simplon.filrouge.controller.SuspectController;
import co.simplon.filrouge.dao.SuspectDAO;
import co.simplon.filrouge.model.Suspect;
import co.simplon.filrouge.service.SuspectService;



@RunWith(SpringRunner.class)
@WebMvcTest(value=SuspectController.class, secure=false)
public class SuspectControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SuspectService suspectService;
	
	@MockBean
	private SuspectDAO suspectDAO;
	
	@Test
    public void getSuspectOK() throws Exception {
		
		Suspect suspect = new Suspect();
		suspect.setId((long) 1);
		suspect.setNom("Test");
		
		Mockito.when(suspectService.getSuspect((long) 1)).thenReturn(suspect);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/suspect/1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	       
        System.out.println(result.getResponse());
        String expected = "{id:1, nom:Test}";
        
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
}
