package com.fleetmanagementAPI.fleet.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    //delega la llamada al método findAll() del repositorio TaxiRepository, pasando el objeto Pageable proporcionado.
    public Page<Taxi> getAllTaxis(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}