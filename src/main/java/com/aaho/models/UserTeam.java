package com.aaho.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserTeam {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long utid;
 	
//	@ManyToOne(optional = false,targetEntity = User.class)
//	@JoinColumn(name = "aaho_user", referencedColumnName = "userid")
	@Column(name="userId")
	Long userId;

//	@ManyToOne(optional = false,targetEntity = Team.class)
//	@JoinColumn(name = "team", referencedColumnName = "teamid")
	@Column(name="teamId")
	Long teamId;

	public Long getUtid() {
		return utid;
	}

	public void setUtid(Long utid) {
		this.utid = utid;
	}

	public UserTeam(Long userId, Long teamid) {

		this.userId=userId;
		this.teamId=teamid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}


}
