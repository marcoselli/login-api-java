package br.com.devmarco.kyroschallenge.adapters;

import br.com.devmarco.kyroschallenge.repositories.entities.UserEntity;
import br.com.devmarco.kyroschallenge.controllers.dtos.UserDTO;

public class UserEntityAdapter {

    private UserEntityAdapter(){
    }

    public static UserEntity convertUserDTOToUserEntity(UserDTO userDTO){
        return UserEntity.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }
}
