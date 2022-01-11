package br.com.devmarco.kyroschallenge.controllers;

import br.com.devmarco.kyroschallenge.controllers.dtos.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserAPI {

    ResponseEntity save(UserDTO userDTO);
    ResponseEntity data(String key);

}
