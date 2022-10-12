package com.app.mobil_service_api.repository;

import com.app.mobil_service_api.model.ServiceMobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceMobilRepository extends JpaRepository<ServiceMobil, Integer> {

    @Query(value = "SELECT * FROM service_mobil WHERE status = ?", nativeQuery = true)
    List<ServiceMobil> findByStatus(String status);
}
