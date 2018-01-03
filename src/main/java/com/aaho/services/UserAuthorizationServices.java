package com.aaho.services;

import com.aaho.models.User;

public interface UserAuthorizationServices {

	boolean validateUserAction(User user, AahoAction act);
}
