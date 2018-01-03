package com.aaho.servicesimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaho.exception.ValidateException;
import com.aaho.models.User;
import com.aaho.repos.UserRepository;
import com.aaho.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired 
	UserRepository userRepository;

	@Override
	@Transactional
	public User login(String email, String password) throws ValidateException{
		User user =  userRepository.findOneByEmailAndPassword(email, password);
		if (user  == null || user.getUserId()==0 ) 
			throw new ValidateException("ERROR","User does not exist with specified email and password!");  
		return user;
	}

	@Override
	@Transactional
	public Long register(User user) throws ValidateException {
		Long newuserid=new Long (0);
		try {
			User u=userRepository.save(user);
			if(u!=null )
			{
				newuserid=u.getUserId();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ValidateException("ERROR", e.getCause().getMessage());
		}


		return newuserid;
	} 


}
