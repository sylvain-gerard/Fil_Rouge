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

import co.simplon.filrouge.controller.ArmeController;
import co.simplon.filrouge.dao.ArmeDAO;
import co.simplon.filrouge.model.Arme;
import co.simplon.filrouge.service.ArmeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ArmeController.class, secure=false)
public class ArmeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ArmeService armeService;
	
	@MockBean
	private ArmeDAO armeDAO;
	
	@Test
    public void getArmetOK() throws Exception {
		
		Arme arme = new Arme();
		arme.setId((long) 1);
		arme.setType("Test");
		
		Mockito.when(armeService.recupererArme((long) 1)).thenReturn(arme);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/arme/1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	       
        System.out.println(result.getResponse());
        String expected = "{id:1, type:Test}";
        
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
}
