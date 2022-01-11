package br.com.devmarco.kyroschallenge.service;

import br.com.devmarco.kyroschallenge.adapters.UserEntityAdapter;
import br.com.devmarco.kyroschallenge.data.UserDetailsData;
import br.com.devmarco.kyroschallenge.repositories.UserRepository;
import br.com.devmarco.kyroschallenge.repositories.entities.UserEntity;
import br.com.devmarco.kyroschallenge.controllers.dtos.UserDTO;
import br.com.devmarco.kyroschallenge.service.exceptions.UserException;
import br.com.devmarco.kyroschallenge.service.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByEmail(username);

        if(user.isEmpty())
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado");

        return new UserDetailsData(user);
    }

    public void save(UserDTO userDTO) throws UserException {
        UserUtil.testAllUserFields(userDTO);
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        userRepository.save(
                UserEntityAdapter.convertUserDTOToUserEntity(userDTO));
    }
}
