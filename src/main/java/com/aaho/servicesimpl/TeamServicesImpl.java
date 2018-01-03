package com.aaho.servicesimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaho.exception.ValidateException;
import com.aaho.models.Team;
import com.aaho.models.User;
import com.aaho.models.UserTeam;
import com.aaho.repos.TeamRepository;
import com.aaho.repos.UserRepository;
import com.aaho.repos.UserTeamRepository;
import com.aaho.services.TeamServices;
@Service
public class TeamServicesImpl implements TeamServices{

	@Autowired
	UserTeamRepository userTeamRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TeamRepository  teamRepository;
	
	@Override
	public Team addTeam(User creator, Team team) {
		return teamRepository.save(team);
	}

	@Override
	public boolean deleteTeam() {
		
		return false;
	}

	@Override
	public boolean addUsertoTeam(User owner, User newUser, Long teamId) throws ValidateException {
		User u= userRepository.findOne(newUser.getUserId());
		Team t= teamRepository.findOne(teamId);
		
		if (u == null)  throw new ValidateException("ERROR","User is not found");
		if (t == null)  throw new ValidateException("ERROR","Tis not found");
		
		UserTeam ut= new UserTeam(u.getUserId(),t.getTeamid());
		userTeamRepository.save(ut);
		return true;
	}

	@Override
	public boolean removeUserFromTeam(User owner, User removedUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Team> getTeamsByUser(Long userid) throws ValidateException {
		Set<Team> ts= new HashSet<Team>();
		
		User user = userRepository.findOne(userid);
		if (user==null) throw new ValidateException("ERROR", "user does not exist");
		
		List<UserTeam> ut = userTeamRepository.findByUserId(userid) ;
		
		for (UserTeam u : ut )
		{
			Team t=  teamRepository.findOne(u.getTeamId());
			ts.add(t);
		}
		
		return new ArrayList<Team>(ts);
	}


}
