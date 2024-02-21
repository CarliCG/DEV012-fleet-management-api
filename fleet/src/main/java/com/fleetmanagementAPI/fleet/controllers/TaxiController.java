package com.fleetmanagementAPI.fleet.controllers;
import com.fleetmanagementAPI.fleet.entities.Taxi;
import com.fleetmanagementAPI.fleet.services.TaxiService;
import com.fleetmanagementAPI.fleet.services.TrajectoriesService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api")

public class TaxiController {

    @Autowired
    private TaxiService taxiService;
    @Autowired
    private TrajectoriesService trajectoriesService;

    @GetMapping("/taxis")
    public Page<Taxi> getAllTaxis(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return taxiService.getAllTaxis(pageable);

    }

}