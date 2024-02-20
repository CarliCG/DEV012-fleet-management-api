package com.fleetmanagementAPI.fleet.controllers;
import com.fleetmanagementAPI.fleet.entities.Taxi;
import com.fleetmanagementAPI.fleet.services.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    @GetMapping("/taxis")
    //Pageable para definir el tamaño de la página y el número de página.
    public Page<Taxi> getAllTaxis(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return taxiService.getAllTaxis(pageable); //solicitud GET para obtener todos los taxis
    }
}
