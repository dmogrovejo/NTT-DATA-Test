package com.nttdata.test.integral_test;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class AccountIntegralTest {

	@Autowired
    private MockMvc mockMvc;

	
	@Test
    public void perform() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cuentas/")
                        .contentType(MediaType.APPLICATION_JSON));
    }
	
	
	@Test
	public void whenCallAccountsThenHttpStatus_OK() throws Exception{
		 mockMvc.perform(MockMvcRequestBuilders.get("/api/cuentas/")
                 .contentType(MediaType.APPLICATION_JSON))
         .andExpect(MockMvcResultMatchers
                 .status()
                 .isOk())
         .andExpect(MockMvcResultMatchers
                 .content()
                 .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
}
