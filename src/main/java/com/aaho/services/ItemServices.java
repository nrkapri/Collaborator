package com.aaho.services;

import java.util.List;

import com.aaho.exception.ValidateException;
import com.aaho.models.Item;
import com.aaho.models.User;

public interface ItemServices {

	Item createItem( Long userId, Item newItem) throws ValidateException;
	Item deleteItem(Long userId,Long deletedItemId) throws ValidateException;
	Item updateItem(Long userId, Item updatedItem) throws ValidateException;
	Item addUserToItem(Long userId, Long itemId) throws ValidateException;
	User removeUserFromItem(Long userId, Long itemId) throws ValidateException;
	//	boolean updateItemStatus();

	boolean updateItemOwner(User actor,User newOwner, Item item);
	
	List<Item> getItemsByUser(Long userid);
	List<Item> getItemsByTeam(Long teamId);


}
