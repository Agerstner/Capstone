package com.claim_academy.capstone.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim_academy.capstone.model.MaintenanceReports;
import com.claim_academy.capstone.repository.MaintenanceRepository;



@Service
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService {

	@Autowired
	private MaintenanceRepository repository;


	@Override
	public Optional<MaintenanceReports> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public void save(MaintenanceReports maintenanceReports) {
		repository.save(maintenanceReports);
	}

//	@Override
//	public void update(MaintenanceReports maintenanceReports) {
//		MaintenanceReports report = findById(maintenanceReports.getId()).get();
//		if (report != null) {
//			report.setType(maintenanceReports.getType());
//			report.setDescription(maintenanceReports.getDescription());
//			report.setDateTime(maintenanceReports.getDateTime());
//		}
//	}

	@Override
	public List<MaintenanceReports> findAll() {
		return repository.findAll();
	}



}
