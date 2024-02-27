package com.fleetmanagementAPI.fleet.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fleetmanagementAPI.fleet.entities.Trajectories;
import com.fleetmanagementAPI.fleet.services.TrajectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api")
public class TrajectoriesController {
    @Autowired
    private TrajectoriesService trajectoriesService;

    @GetMapping("/trajectories")
    public Page<Trajectories> getTrajectoriesByTaxiIdAndDate(
            @RequestParam int taxiId,
            @RequestParam String date,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return trajectoriesService.findByTaxiIdAndDate(taxiId, date, pageable);
    }
}
