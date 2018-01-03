package com.aaho.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaho.models.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
