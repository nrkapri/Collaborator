package com.aaho.controller;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaho.exception.ValidateException;
import com.aaho.models.User;
import com.aaho.services.UserServices;
import com.aaho.utility.ValidationUtility;

@RestController
public class UserController {


	@Autowired
	UserServices userservices;

	@RequestMapping("/login")
	@Produces({ "application/json"})
	public User login(HttpSession session,
			@QueryParam("email") String email,
			@QueryParam("password") String password)
					throws ValidateException  {

		if (email == null || password == null ) 
			throw new ValidateException("ERROR", "Email or password can't be empty");


		User user=  userservices.login(email,password );
		user.setPassword("*****");
		session.setAttribute("userid", user.getUserId());

		return user; 
	}

	@RequestMapping("/register")
	//	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ "application/json"})
	public Long register(
			@QueryParam("email") String email,
			@QueryParam("password") String password,
			@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName
			)  throws ValidateException  
	{

		User user = new User();

		user.setEmail(email);
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setPassword(password);

		validateUserForRegistration(user);

		Long userid=(long) 0;
		userid=userservices.register(user);
		return userid; 
	}

	private void validateUserForRegistration(User user) throws ValidateException {
		if (user == null )
		{
			throw new ValidateException("ERROR", "User can't be empty");
		}
		else if (user.getEmail()==null || user.getEmail().isEmpty())
		{
			throw new ValidateException("ERROR", "Email can't be empty");
		}
		else if (!ValidationUtility.isValidEmailAddress(user.getEmail()))
		{
			throw new ValidateException("ERROR", "Email is not valid");
		}
		else if (user.getFirstname()==null || user.getFirstname().isEmpty())
		{
			throw new ValidateException("ERROR", "Email can't be empty");
		}
		else if (user.getLastname()==null ||  user.getLastname().isEmpty())
		{
			throw new ValidateException("ERROR", "Last name can't be empty");
		}
		else if (user .getPassword()== null || user.getPassword().isEmpty())
		{
			throw new ValidateException("ERROR", "password can't be empty");
		}
	}

}
