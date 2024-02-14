package com.assignment.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.relationships.models.License;

public interface LicenseRepository extends CrudRepository<License,Long>{
	List<License> findAll();
	Long findById(License id);
	Long deleteById(License id);
}
