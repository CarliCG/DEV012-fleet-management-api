package com.fleetmanagementAPI.fleet.services;
import com.fleetmanagementAPI.fleet.entities.Trajectories;
import com.fleetmanagementAPI.fleet.repositorio.TrajectoriesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

@Service
public class TrajectoriesService {
    @Autowired
    private TrajectoriesRepository repository;

    public Page<Trajectories> findByTaxiIdAndDate(int taxiId, String date, Pageable pageable) {
        return repository.findTrajectoriesByTaxiIdAndDate(taxiId, date, pageable);
    }
}
