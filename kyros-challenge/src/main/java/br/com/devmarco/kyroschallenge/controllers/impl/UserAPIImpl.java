package br.com.devmarco.kyroschallenge.controllers.impl;

import br.com.devmarco.kyroschallenge.service.UserDetailsServiceImpl;
import br.com.devmarco.kyroschallenge.controllers.UserAPI;
import br.com.devmarco.kyroschallenge.controllers.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserAPIImpl implements UserAPI {

    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder encoder;

    @Autowired
    public UserAPIImpl(UserDetailsServiceImpl userDetailsService, PasswordEncoder encoder) {
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
    }

    @Override
    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody UserDTO userDTO) {
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        userDetailsService.save(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario " + userDTO.getEmail() + " cadastrado.");
    }
}
