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

import co.simplon.filrouge.controller.VehiculeController;
import co.simplon.filrouge.dao.VehiculeDAO;
import co.simplon.filrouge.model.Vehicule;
import co.simplon.filrouge.service.VehiculeService;


@RunWith(SpringRunner.class)
@WebMvcTest(value=VehiculeController.class, secure=false)
public class VehiculeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private VehiculeService vehiculeService;
	
	@MockBean
	private VehiculeDAO vehiculeDAO;
	
	@Test
    public void getVehiculeOK() throws Exception {
		
		Vehicule vehicule = new Vehicule();
		vehicule.setId((long) 1);
		vehicule.setType("Test");
		
		Mockito.when(vehiculeService.getVehicule((long) 1)).thenReturn(vehicule);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/vehicule/1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	       
        System.out.println(result.getResponse());
        String expected = "{id:1, type:Test}";
        
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
