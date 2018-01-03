package com.aaho.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="teamId")
	Long teamId;

	@Column(name="teamOwner")
	Long teamOwner;

	@Column(name="teamName")
	String teamName;

	@Column(name="teamDesc")
	String teamDesc;

	@OneToMany
	@JoinColumn(name="teamId", referencedColumnName="teamId",insertable = false, updatable = false)
	private List<UserTeam> userTeams = new ArrayList<UserTeam>();
	
//	@ManyToMany(cascade = CascadeType.MERGE)
//	@JoinTable(name="user_teams",
//	joinColumns = { @JoinColumn(name = "teamId") }, inverseJoinColumns = { @JoinColumn(name = "userId") })
//	List<User>  teamMembers ;


	public Team()
	{
	}

	public Team(Long teamid, Long teamOwner, String teamName, String teamDesc) {
		super();
		this.teamId = teamid;
		this.teamOwner = teamOwner;
		this.teamName = teamName;
		this.teamDesc = teamDesc;
	}

	public Long getTeamid() {
		return teamId;
	}

	public void setTeamid(Long teamid) {
		this.teamId = teamid;
	}

	public Long getTeamOwner() {
		return teamOwner;
	}

	public void setTeamOwner(Long teamOwner) {
		this.teamOwner = teamOwner;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamDesc() {
		return teamDesc;
	}

	public void setTeamDesc(String teamDesc) {
		this.teamDesc = teamDesc;
	}


}
