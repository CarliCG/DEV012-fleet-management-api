package com.fleetmanagementAPI.fleet.services;
import com.fleetmanagementAPI.fleet.entities.Taxi;
import com.fleetmanagementAPI.fleet.repositorio.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Service
public class TaxiService {

    @Autowired
    private TaxiRepository repository;

    public Page<Taxi> getAllTaxis(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}