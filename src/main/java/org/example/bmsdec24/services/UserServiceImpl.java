package org.example.bmsdec24.services;

import org.example.bmsdec24.exceptions.UserAlreadyPresentException;
import org.example.bmsdec24.models.User;
import org.example.bmsdec24.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signupUser(String name, String email, String password) throws UserAlreadyPresentException {
        if(userRepository.findByEmail(email) != null){
            throw new UserAlreadyPresentException("User is already present in DB");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        User user = new User();
        user.setPassword(encodedPassword);
        user.setName(name);
        user.setEmail(email);

        return userRepository.save(user);
    }
}
