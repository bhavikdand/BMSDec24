package org.example.bmsdec24.services;

import org.example.bmsdec24.exceptions.UserAlreadyPresentException;
import org.example.bmsdec24.models.User;

public interface UserService {

    public User signupUser(String name, String email, String password) throws UserAlreadyPresentException;
}
