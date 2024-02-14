package com.assignment.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignment.dojosandninjas.models.Ninja;
import com.assignment.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
    	this.ninjaRepository = ninjaRepository;
    }
    
    public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> ninja = ninjaRepository.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		} else {
			return null;
		}
	}
	
	public List<Ninja> getAllNinjas() {
		return ninjaRepository.findAll();
	}
	
	public Ninja editNinja(Long id, Ninja ninja) {
		Optional<Ninja> existingNinja = ninjaRepository.findById(id);
		if(existingNinja.isPresent()) {
			ninja.setFirstName(ninja.getFirstName());
			ninja.setLastName(ninja.getLastName());
			ninja.setAge(ninja.getAge());
			ninja.setDojo(ninja.getDojo());
			return ninjaRepository.save(ninja);
		} else {
			return null;
		}
	}
	
	public Ninja deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
		return null;
	}
}
