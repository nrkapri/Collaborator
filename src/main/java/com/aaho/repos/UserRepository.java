package com.aaho.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaho.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByEmailAndPassword(String emailAddress, String lastname);
}
