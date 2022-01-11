package br.com.devmarco.kyroschallenge.adapters;

import br.com.devmarco.kyroschallenge.repositories.entities.UserEntity;
import br.com.devmarco.kyroschallenge.controllers.dtos.UserDTO;

public class UserDTOAdapter {

    private UserDTOAdapter(){
    }

    public static UserDTO convertUserEntityToUserDTO(UserEntity userEntity){
        return UserDTO.builder()
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .build();
    }
}
