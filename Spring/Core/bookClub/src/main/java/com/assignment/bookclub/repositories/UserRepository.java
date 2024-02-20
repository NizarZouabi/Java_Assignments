package com.assignment.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.assignment.bookclub.models.User;

public interface UserRepository extends CrudRepository<User,Long> {
	Optional<User> findByEmail(String email);
	List<User> findAll();
	Long findById(User id);
}
