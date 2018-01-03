package com.aaho.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserItem {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long uiid ;
	
	
//	@ManyToOne(optional = false,targetEntity = User.class)
//	@JoinColumn(name = "aaho_user", referencedColumnName = "userid")
	@Column(name="userId")
	Long userId;

//	@ManyToOne(optional = false,targetEntity = Item.class)
//	@JoinColumn(name = "item", referencedColumnName = "itemid")
	@Column(name="itemId")
	Long itemId;


	public Long getUiid() {
		return uiid;
	}

	public void setUiid(Long utid) {
		this.uiid = utid;
	}
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

	public UserItem() {
		// TODO Auto-generated constructor stub
	}
	public UserItem(Long userId2, Long itemId) {
		// TODO Auto-generated constructor stub
	}
}