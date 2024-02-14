package com.assignment.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignment.relationships.models.License;
import com.assignment.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> getAllLicenses() {
		return licenseRepository.findAll();
	}
	
	public License findLicense(Long id) {
		Optional<License> license = licenseRepository.findById(id);
		if(license.isPresent()) {
			return license.get();
		} else {
			return null;
		}
	}
	
	public License addLicense(License license) {
		return licenseRepository.save(license);
	}
	
	public License updateLicense(Long id, License license) {
		Optional<License> licenseToUpdate = licenseRepository.findById(id);
		if(licenseToUpdate.isPresent()) {
			license.setNumber(license.getNumber());
			license.setExpirationDate(license.getExpirationDate());
			license.setState(license.getState());
			license.setPerson(license.getPerson());
			return licenseRepository.save(license);
		} else {
			return null;
		}
	}
	
	public License removeLicense(Long id) {
		licenseRepository.deleteById(id);
		return null;
	}
}
