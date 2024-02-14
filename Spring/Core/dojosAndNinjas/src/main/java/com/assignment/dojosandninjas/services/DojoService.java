package com.assignment.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignment.dojosandninjas.models.Dojo;
import com.assignment.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> dojo = dojoRepository.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		} else {
			return null;
		}
	}
	
	public List<Dojo> getAllDojos() {
		return dojoRepository.findAll();
	}
	
	public Dojo editDojo(Long id, Dojo dojo) {
		Optional<Dojo> existingDojo = dojoRepository.findById(id);
		if(existingDojo.isPresent()) {
			dojo.setName(dojo.getName());
			dojo.setNinjas(dojo.getNinjas());
			return dojoRepository.save(dojo);
		} else {
			return null;
		}
	}
	
	public Dojo deleteDojo(Long id) {
		dojoRepository.deleteById(id);
		return null;
	}
}
