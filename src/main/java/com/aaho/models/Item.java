package com.aaho.models;

import java.sql.Date;
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

public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long itemId;
	
	@Column(name="itemName")
	private String itemName;
	
	@Column(name="totalEstimation")
	private double totalEstimation;
	
	@Column(name="itemCategory")
	private int itemCategory;
	
	@Column(name="creationDateTime")
	private Date creationDateTime;
	
	@Column(name="itemDetails")
	private String itemDetails;
	
	@Column(name="itemDocPath")
	private String itemDocPath;
	
	@Column(name="itemImagePath")
	private String itemImagePath;
	
	@Column(name="itemStatus")
	private int itemStatus;
	
	@Column(name="itemStatusDatetime")
	private Date itemStatusDatetime;
	
	@Column(name="itemSummary")
	private String itemSummary;
	
	@Column(name="itemTitle")
	private String itemTitle;
	
	@Column(name="origCreator")
	private Long origCreator ;
	
	@Column(name="parentId")
	private Long parentId;

	@Column(name="itemType")
	private ItemType itemType;
	
	@OneToMany
	@JoinColumn(name="itemId", referencedColumnName="itemId",insertable = false, updatable = false)
	private List<UserItem> userItems = new ArrayList<UserItem>(); 
	
	public Item ()
	{
		
	}
	
	public Item(Long itemId, String ItemName, double totalEstimation, int itemCategory, Date creationDateTime, String itemDetails,
			String itemDocPath, String itemImagePath, int itemStatus, Date itemStatusDatetime, String itemSummary,
			String itemTitle, Long origcreator, Long parentid) {
		super();
		this.itemId = itemId;
		this.itemName=ItemName;
		this.totalEstimation = totalEstimation;
		this.itemCategory = itemCategory;
		this.creationDateTime = creationDateTime;
		this.itemDetails = itemDetails;
		this.itemDocPath = itemDocPath;
		this.itemImagePath = itemImagePath;
		this.itemStatus = itemStatus;
		this.itemStatusDatetime = itemStatusDatetime;
		this.itemSummary = itemSummary;
		this.itemTitle = itemTitle;
		this.origCreator = origcreator;
		this.parentId = parentid;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public double getTotalEstimation() {
		return totalEstimation;
	}

	public void setTotalEstimation(double totalEstimation) {
		this.totalEstimation = totalEstimation;
	}

	public int getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(int itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Date getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public String getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	public String getItemDocPath() {
		return itemDocPath;
	}

	public void setItemDocPath(String itemDocPath) {
		this.itemDocPath = itemDocPath;
	}

	public String getItemImagePath() {
		return itemImagePath;
	}

	public void setItemImagePath(String itemImagePath) {
		this.itemImagePath = itemImagePath;
	}

	public int getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Date getItemStatusDatetime() {
		return itemStatusDatetime;
	}

	public void setItemStatusDatetime(Date itemStatusDatetime) {
		this.itemStatusDatetime = itemStatusDatetime;
	}

	public String getItemSummary() {
		return itemSummary;
	}

	public void setItemSummary(String itemSummary) {
		this.itemSummary = itemSummary;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public Long getOrigcreator() {
		return origCreator;
	}

	public void setOrigcreator(Long origcreator) {
		this.origCreator = origcreator;
	}

	public Long getParentid() {
		return parentId;
	}

	public void setParentid(Long parentid) {
		this.parentId = parentid;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	} 
	
	
	
}
