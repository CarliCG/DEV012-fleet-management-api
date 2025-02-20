package com.fleetmanagementAPI.fleet.controllers;
import com.fleetmanagementAPI.fleet.entities.LastLocation;
import com.fleetmanagementAPI.fleet.services.LastLocationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LastLocationController {
    private final LastLocationService lastLocationService;

    public LastLocationController(LastLocationService lastLocationService) {
        this.lastLocationService = lastLocationService;
    }

    @GetMapping("/lastLocation")
    public List<LastLocation> getLastLocation(){
        return lastLocationService.getLastLocation();
    }
}

