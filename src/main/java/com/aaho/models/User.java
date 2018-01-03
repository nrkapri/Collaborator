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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity(name="aahuser")
@Table(uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId")
	private Long userId;

	@Column(name="firstName")
	private String firstName;

	@NotNull
	@Column(name="lastName")
	private String lastName;

	@Column(name="email",unique=true)
	@NotNull
	private String email;

	@Column(name="password")
	private String password;

	@OneToMany
	@JoinColumn(name="userId", referencedColumnName="userId",insertable = false, updatable = false)
	private List<UserTeam> userTeam = new ArrayList<UserTeam>(); 

	@OneToMany
	@JoinColumn(name="userId", referencedColumnName="userId",insertable = false, updatable = false)
	private List<UserItem> userItem = new ArrayList<UserItem>(); 


	//	@ManyToMany(cascade =  {CascadeType.PERSIST, CascadeType.MERGE})
	//	@JoinTable(name="user_items",
	//	joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "itemId") })
	//	List<Item> userItems;
	//	

	//	@ManyToMany(cascade =  {CascadeType.PERSIST, CascadeType.MERGE})
	//	@JoinTable(name="user_teams",
	//	joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "teamId") })
	//	private List<Team> userTeams;

	//	public List<Team> getUserTeams() {
	//		return userTeams;
	//	}
	//	public void setUserTeams(List<Team> userTeams) {
	//		this.userTeams = userTeams;
	//	}

	public List<UserItem> getUserItems() {
		return userItem;
	}
	public void setUserItems(List<UserItem> userItem) {
		this.userItem = userItem;
	}
	public List<UserTeam> getUserTeams() {
		return userTeam;
	}
	public void setUserTeams(List<UserTeam> userTeams) {
		this.userTeam = userTeams;
	}
	//	public List<Item> getUserItems() {
	//		return userItems;
	//	}
	//	public void setUserItems(List<Item> userItems) {
	//		this.userItems = userItems;
	//	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public User()
	{

	}

	public User(String firstname, String lastname, String email, String password) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
	}



	@Override
	public String toString() {
		return String.format(
				"User[id=%d, firstName='%s', lastName='%s']",
				userId, firstName, lastName);
	}

}
