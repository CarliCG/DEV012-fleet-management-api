package com.fleetmanagementAPI.fleet.repositorio;

import com.fleetmanagementAPI.fleet.entities.LastLocation;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LastLocationRepository extends JpaRepository<LastLocation, Integer> {

    @Query("SELECT NEW com.fleetmanagementAPI.fleet.entities.LastLocation(l.taxiId, l.date, l.longitude, l.latitude) " +
            "FROM LastLocation l " +
            "WHERE (l.taxiId, l.date) IN " +
            "(SELECT ll.taxiId, MAX(ll.date) FROM LastLocation ll GROUP BY ll.taxiId)")
    List<LastLocation> findLastLocationForAllTaxis(Pageable pageable);
}
