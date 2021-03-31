package pe.mycompany.reto.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import pe.mycompany.reto.RetoApplication;

@SpringBootTest(classes=RetoApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class RetoControllerTest {

	 @Autowired
	 private MockMvc mvc;
	 
	@Test
	void testController() throws Exception {
		mvc.perform(post("/reto")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}

}
