package com.aaho.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaho.models.UserTeam;

public interface UserTeamRepository extends JpaRepository<UserTeam, Long>{

	List<UserTeam> findByUserId(Long userid);

}
