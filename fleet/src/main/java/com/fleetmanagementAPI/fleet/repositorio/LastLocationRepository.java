package com.fleetmanagementAPI.fleet.repositorio;

import com.fleetmanagementAPI.fleet.entities.LastLocation;

import com.fleetmanagementAPI.fleet.entities.Trajectories;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LastLocationRepository extends JpaRepository<Trajectories, Integer> {

    @Query("SELECT DISTINCT NEW com.fleetmanagementAPI.fleet.entities.LastLocation(t.taxiId, t.date, t.longitude, t.latitude) " +
            "FROM Trajectories t " +
            "WHERE (t.taxiId, t.date) IN " +
            "(SELECT t2.taxiId, MAX(t2.date) FROM Trajectories t2 GROUP BY t2.taxiId)")
    List<LastLocation> findLastLocationForAllTaxis();
}





