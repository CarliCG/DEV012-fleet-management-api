package com.fleetmanagementAPI.fleet.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fleetmanagementAPI.fleet.entities.Trajectories;

import java.sql.Timestamp;

@Repository
public interface TrajectoriesRepository extends PagingAndSortingRepository<Trajectories, Long> {
    //definir consultas personalizadas en el repositorio de Spring Data JPA
    @Query(value="SELECT * FROM trajectories WHERE taxi_id = :taxiId AND TO_CHAR(date, 'DD-MM-YYYY') = :date",nativeQuery = true)
    Page<Trajectories> findTrajectoriesByTaxiIdAndDate(int taxiId, String date, Pageable pageable);
}
