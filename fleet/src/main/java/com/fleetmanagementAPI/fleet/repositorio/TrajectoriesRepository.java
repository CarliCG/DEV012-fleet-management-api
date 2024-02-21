package com.fleetmanagementAPI.fleet.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fleetmanagementAPI.fleet.entities.Trajectories;

import java.sql.Timestamp;

@Repository
public interface TrajectoriesRepository extends PagingAndSortingRepository<Trajectories, Long> {
    Page<Trajectories> findByTaxiIdAndDate(int taxiId, Timestamp date, Pageable pageable);
}
