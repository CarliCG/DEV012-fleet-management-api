package com.fleetmanagementAPI.fleet.repositorio;

import com.fleetmanagementAPI.fleet.entities.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Long> {

}
