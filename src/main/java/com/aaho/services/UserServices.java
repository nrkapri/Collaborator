package com.aaho.services;

import com.aaho.exception.ValidateException;
import com.aaho.models.User;

public interface UserServices {
	User login(String email, String password) throws ValidateException;
	Long register(User user) throws ValidateException;
	
}
