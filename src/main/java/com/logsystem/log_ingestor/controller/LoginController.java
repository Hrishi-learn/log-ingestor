package com.logsystem.log_ingestor.controller;

import com.logsystem.log_ingestor.model.AuthRequest;
import com.logsystem.log_ingestor.model.LogRequest;
import com.logsystem.log_ingestor.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {

    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest){
        System.out.println(authRequest.getServiceName());
        System.out.println(authRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getServiceName(), authRequest.getPassword())
        );
        if(authentication.isAuthenticated()){
            String token = jwtUtil.generateToken(authRequest.getServiceName());
            return ResponseEntity.ok().body("token: " +token);
        }else{
            return ResponseEntity.status(403).body("incorrect Service Name or password");
        }
    }
}
