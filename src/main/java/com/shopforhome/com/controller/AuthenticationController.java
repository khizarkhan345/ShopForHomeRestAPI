package com.shopforhome.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.com.Util.JwtUtil;
import com.shopforhome.com.entity.User;
import com.shopforhome.com.request.LogInRequest;
import com.shopforhome.com.response.LogInResponse;
import com.shopforhome.com.service.UserServiceDaoImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
    private UserServiceDaoImpl userServiceImpl;

  
    @PostMapping("/signup")
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        User registeredUser = userServiceImpl.saveUser(user);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LogInResponse> authenticate(@RequestBody LogInRequest loginRequest) {
    	
        User authenticatedUser = userServiceImpl.authenticate(loginRequest);

        String jwtToken = jwtUtil.generateToken(authenticatedUser);

        LogInResponse loginResponse = new LogInResponse(jwtToken, jwtUtil.getExpirationTime(),
                authenticatedUser.getRole(), authenticatedUser.getEmail(),
                authenticatedUser.getUserId(), authenticatedUser.getCart(), authenticatedUser.getCoupons(), authenticatedUser.getWishlist());

        return ResponseEntity.ok(loginResponse);
    }
}
