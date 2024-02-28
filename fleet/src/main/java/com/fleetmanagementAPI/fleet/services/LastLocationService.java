package com.fleetmanagementAPI.fleet.services;
import com.fleetmanagementAPI.fleet.entities.LastLocation;
import com.fleetmanagementAPI.fleet.repositorio.LastLocationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class LastLocationService {
    @Autowired
    private LastLocationRepository lastLocationRepository;

    public List<LastLocation> getLastLocation() {
        return lastLocationRepository.findLastLocationForAllTaxis();
    }
}

