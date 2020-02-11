package com.claim_academy.capstone.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.claim_academy.capstone.model.MaintenanceReports;



public interface MaintenanceRepository extends JpaRepository<MaintenanceReports, Long> {

	MaintenanceReports findByType(String Type);

	@Query("FROM Users WHERE priority=?1")
	Optional<MaintenanceReports> findPriority(String priority);

	@Query("FROM MaintenanceReports WHERE type=?1 OR priority=?1 OR id=?1")
	List<MaintenanceReports> findByReport(String report);

//	@Query("FROM Users WHERE type=?1 OR user=?1")
//	List<MaintenanceReports> findByUser(String user);
}
