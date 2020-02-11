package com.claim_academy.capstone.service;

import java.util.List;
import java.util.Optional;

import com.claim_academy.capstone.model.MaintenanceReports;



public interface MaintenanceService {

	Optional<MaintenanceReports> findById(long id);
	void delete(long id);
	void save(MaintenanceReports maintenanceReports);
	//void update(MaintenanceReports maintenanceReports);
	List<MaintenanceReports> findAll();
}
