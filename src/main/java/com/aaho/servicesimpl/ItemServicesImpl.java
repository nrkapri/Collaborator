package com.aaho.servicesimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaho.exception.ValidateException;
import com.aaho.models.Item;
import com.aaho.models.User;
import com.aaho.models.UserItem;
import com.aaho.repos.ItemRepository;
import com.aaho.repos.UserItemRepository;
import com.aaho.repos.UserRepository;
import com.aaho.services.ItemServices;

@Service
public class ItemServicesImpl implements ItemServices{

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired 
	UserItemRepository userItemRespository ; 
	
	@Override
	public Item createItem(Long userId, Item newItem) throws ValidateException {
		User user=userRepository.findOne(userId);

		if(user==null ) throw new ValidateException("ERROR","given user not found");
		newItem.setOrigcreator(userId);
		
		Item item =itemRepository.save(newItem);

		UserItem ui= new UserItem(userId,item.getItemId());
		user.getUserItems().add(ui);
		userRepository.save(user);
		
		
		return item;
	}

	@Override
	public Item  deleteItem(Long userId,Long  deletedItemId) throws ValidateException {
		// TODO Auto-generated method stub
		Item deletedItem =itemRepository.findOne(deletedItemId);
		
		if(deletedItem==null)	 
			throw new ValidateException("ERROR","Item does not exist");
		
		
		itemRepository.delete(deletedItem);
		return deletedItem;
	}

	
	@Override
	public Item updateItem(Long userId, Item updatedItem) throws ValidateException {
		User user=userRepository.findOne(userId);

		if(user==null ) throw new ValidateException("ERROR","given user not found");
		
		Item item =itemRepository.save(updatedItem);
		
//		UserItem ui= new UserItem(userId,item.getItemId());
//		user.getUserItems().add(ui);
//		userRepository.save(user);
		
		return item;		
		
	}
	
	@Override
	public Item addUserToItem(Long userId, Long itemId) throws ValidateException {
		User user=userRepository.findOne(userId);
		if(user==null ) throw new ValidateException("ERROR","given user not found");
		
		Item item=  itemRepository.findOne(itemId); 
		if(item==null ) throw new ValidateException("ERROR","given user not found");
		
		UserItem ui= new UserItem(userId,itemId);
		user.getUserItems().add(ui);
		userRepository.save(user);
		
		return itemRepository.findOne(itemId);
	}

	@Override
	public User removeUserFromItem(Long userId, Long itemId) throws ValidateException  {
		User user=userRepository.findOne(userId);
		if(user==null ) throw new ValidateException("ERROR","given user not found");
		
		Item item=  itemRepository.findOne(itemId); 
		if(item==null ) throw new ValidateException("ERROR","given item not found");
		
		UserItem ui= null;
		
		for(UserItem u:user.getUserItems())
		{
			if (u.getUserId()==userId &&  u.getItemId()==itemId)
				{
					ui=u;
					break;
				}
		}
		
		if(ui==null) throw new ValidateException("ERROR","the item and user are  not associated");
		
		user.getUserItems().remove(ui);
		return userRepository.save(user);
	}

	@Override
	public boolean updateItemOwner(User actor, User newOwner, Item item) {
		
		return false;
	}

	@Override
	public List<Item> getItemsByUser(Long userid) {
		Set<Item> resultset = new HashSet<Item>();
		List<UserItem> useritems = userItemRespository.findByUserId(userid);
		
		for(UserItem ui: useritems)
		{
			Item it= itemRepository.findOne(ui.getItemId());
			resultset.add(it);
		}
		
		return new ArrayList<Item>(resultset);
	}

	@Override
	public List<Item> getItemsByTeam(Long teamId) {
		
		return null;
	}

}
