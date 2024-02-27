package com.fleetmanagementAPI.fleet;
import com.fleetmanagementAPI.fleet.entities.Taxi;
import com.fleetmanagementAPI.fleet.repositorio.TaxiRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FleetApplicationTests {
   @Autowired
	private MockMvc mockMvc;

   @MockBean
   private TaxiRepository taxiRepository;

	@Test
	@DisplayName("Test primer endpoint Taxis") // Nombre del test
	void contextLoads() throws Exception { // todos los test deben ser tipo void, y con throw puede devolver un error
		List<Taxi> taxis=new ArrayList<>(); //crea una lista
		taxis.add(new Taxi(1L,"PBL"));//Agrega un taxi a la lista
		Page<Taxi> pageTaxis=new PageImpl<>(taxis,
				PageRequest.of(1, 10), taxis.size()
		);
		Pageable pageable = Pageable.ofSize(10).withPage(1);
		when(taxiRepository.findAll(pageable)).thenReturn(pageTaxis);
				mockMvc.perform(get("/api/taxis").param("page","1").param("size","10"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.content").isArray());
	}



}
