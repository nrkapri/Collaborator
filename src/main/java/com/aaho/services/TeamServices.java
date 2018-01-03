package com.aaho.services;

import java.util.List;

import com.aaho.exception.ValidateException;
import com.aaho.models.Team;
import com.aaho.models.User;

public interface TeamServices {

	Team addTeam(User creator,Team team);
	boolean deleteTeam();
	boolean removeUserFromTeam(User owner,User removedUser);
	
	List<Team> getTeamsByUser(Long userid) throws ValidateException;
	boolean addUsertoTeam(User owner, User newUser, Long teamId) throws ValidateException; 
	
}
