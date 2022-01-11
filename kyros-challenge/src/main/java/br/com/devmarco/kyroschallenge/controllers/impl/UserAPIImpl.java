package br.com.devmarco.kyroschallenge.controllers.impl;

import br.com.devmarco.kyroschallenge.controllers.UserAPI;
import br.com.devmarco.kyroschallenge.controllers.dtos.ResponseMessageDTO;
import br.com.devmarco.kyroschallenge.controllers.dtos.UserDTO;
import br.com.devmarco.kyroschallenge.controllers.token.JWTToken;
import br.com.devmarco.kyroschallenge.service.UserDetailsServiceImpl;
import br.com.devmarco.kyroschallenge.service.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserAPIImpl implements UserAPI {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public UserAPIImpl(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody UserDTO userDTO) {
        try {
            userDetailsService.save(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    ResponseMessageDTO.builder()
                            .message("Usuario " + userDTO.getEmail() + " cadastrado.").build());
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    ResponseMessageDTO.builder().message(e.getMessage()).build());
        }
    }

    @Override
    @PostMapping(value = "/data")
    public ResponseEntity data(@RequestHeader(value = "Authorization") String token) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseMessageDTO.builder().message("Acesso permitido para " +
                        JWTToken.decodeToken(token)).build());

    }
}
