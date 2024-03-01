package com.p_noga.p_noga.controller;

import com.p_noga.p_noga.dto.UsersDto;
import com.p_noga.p_noga.dto.request.SignupReq;
import com.p_noga.p_noga.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;
    private final Logger logger = LoggerFactory.getLogger(UsersController.class);


    @PostMapping("/signup")
    public UsersDto signupUser(@RequestBody SignupReq signupReq){
        return usersService.saveUser(signupReq);
    }

    @GetMapping("login/result")
    public String loginSuccess(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if(principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        logger.warn("세션에 저장 된 사용자 정보: {}", username);

        return "login success";
    }

}
