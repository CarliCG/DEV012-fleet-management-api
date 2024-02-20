package com.fleetmanagementAPI.fleet.repositorio;

import com.fleetmanagementAPI.fleet.entities.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Long> {

    //Page es parte de Spring Data y permite la paginación de resultados.
    Page<Taxi> findAll(Pageable pageable); //findAll devuelve una página de resultados de taxis
}
