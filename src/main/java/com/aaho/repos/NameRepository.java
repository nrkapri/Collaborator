package com.aaho.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaho.models.Person;

public interface NameRepository extends JpaRepository<Person, String> {
}