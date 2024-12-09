package org.example.bmsdec24.controllers;

import org.example.bmsdec24.dtos.ResponseStatus;
import org.example.bmsdec24.dtos.SignupRequestDto;
import org.example.bmsdec24.dtos.SignupResponseDto;
import org.example.bmsdec24.models.User;
import org.example.bmsdec24.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupResponseDto signUp(SignupRequestDto requestDto){
        SignupResponseDto responseDto = new SignupResponseDto();
        try {
            User user = this.userService.signupUser(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
            responseDto.setUserId(user.getId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
