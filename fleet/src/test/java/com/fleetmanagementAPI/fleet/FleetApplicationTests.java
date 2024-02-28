package com.fleetmanagementAPI.fleet;

import com.fleetmanagementAPI.fleet.entities.Taxi;
import com.fleetmanagementAPI.fleet.repositorio.TaxiRepository;
import com.fleetmanagementAPI.fleet.services.TaxiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // indicar que este es un test de Spring Boot.
@AutoConfigureMockMvc
class FleetApplicationTests {
	@Autowired
	private MockMvc mockMvc; //crear un mock del repositorio de taxis.

	@MockBean
	private TaxiRepository taxiRepository;

	@Autowired
	private TaxiService taxiService;

	@Test //verifica cómo la aplicación maneja las solicitudes HTTP y responde a ellas
	@DisplayName("Test para controller taxis")
	void contextLoads() throws Exception {
		List<Taxi> taxis = new ArrayList<>();//crea una lista
		taxis.add(new Taxi(1L, "PBL"));//agrega un taxi a la lista
		Page<Taxi> pageTaxis = new PageImpl<>(taxis, PageRequest.of(1, 10), taxis.size());
		Pageable pageable = Pageable.ofSize(10).withPage(1);
		when(taxiRepository.findAll(pageable)).thenReturn(pageTaxis);
		mockMvc.perform(get("/api/taxis").param("page", "1").param("size", "10"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.content").isArray());
	}

	@Test
	@DisplayName("Test para servicio de taxis")
	void testTaxiService() {
		// Given
		List<Taxi> taxis = new ArrayList<>();//crea una lista
		taxis.add(new Taxi(1L, "PBL"));//agrega un taxi a la lista
		Page<Taxi> pageTaxis = new PageImpl<>(taxis, PageRequest.of(0, 10), taxis.size());
		when(taxiRepository.findAll(PageRequest.of(0, 10))).thenReturn(pageTaxis);
//comportamiento del mock del repositorio para que retorne una página de taxis cuando se llame a findAll()
		// When
		Page<Taxi> result = taxiService.getAllTaxis(PageRequest.of(0, 10));


		// Then
		assertEquals(pageTaxis, result);
	}
}
