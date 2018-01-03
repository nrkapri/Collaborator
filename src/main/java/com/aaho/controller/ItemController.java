package com.aaho.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aaho.exception.ValidateException;
import com.aaho.models.Item;
import com.aaho.services.ItemServices;

@RestController
public class ItemController {
	@Autowired
	ItemServices itemServices;


	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	@Produces({ "application/json"})
	Item createItem(@QueryParam(value = "userId") Long userId, @RequestBody Item newItem) throws ValidateException
	{
		return itemServices.createItem(userId, newItem);
	}
	
	

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Produces({ "application/json"})
	Item createItem(@QueryParam(value = "userId") Long userId, @QueryParam(value = "itemId") Long itemId) throws ValidateException
	{
		return itemServices.deleteItem(userId,itemId);
	}
	
	@RequestMapping(value = "/updateItem", method = RequestMethod.POST)
	@Produces({ "application/json"})
	Item updateItem(@QueryParam(value = "userId") Long userId, @RequestBody Item updatedItem) throws ValidateException
	{
		return itemServices.updateItem(userId, updatedItem);
	}

	@RequestMapping(value = "/addUserToItem", method = RequestMethod.POST)
	@Produces({ "application/json"})
	Item addUserToItem(@QueryParam(value = "userId") Long userId, @QueryParam(value = "itemId") Long itemId) throws ValidateException
	{
		
		return itemServices.addUserToItem(userId, itemId);
	}
	
	@RequestMapping(value = "/userItems", method = RequestMethod.POST)
	@Produces({ "application/json"})
	List<Item> getUserItems(@QueryParam(value = "userId") Long userId) throws ValidateException
	{
		return itemServices.getItemsByUser(userId);
	}
	
}
