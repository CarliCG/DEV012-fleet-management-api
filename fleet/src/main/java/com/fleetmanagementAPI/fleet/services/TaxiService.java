package com.fleetmanagementAPI.fleet.services;

import com.fleetmanagementAPI.fleet.entities.Taxi;
import com.fleetmanagementAPI.fleet.repositorio.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaxiService {

    @Autowired
    private TaxiRepository repository;

    public List<Taxi> getAllTaxis() {

        return this.repository.findAll();

    }
}


