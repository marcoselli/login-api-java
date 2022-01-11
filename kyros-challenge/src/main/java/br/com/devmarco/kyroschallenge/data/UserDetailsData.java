package br.com.devmarco.kyroschallenge.data;

import br.com.devmarco.kyroschallenge.repositories.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class UserDetailsData implements UserDetails {

    private final Optional<UserEntity> userEntity;

    public UserDetailsData(Optional<UserEntity> userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return userEntity.orElse(new UserEntity()).getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.orElse(new UserEntity()).getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
