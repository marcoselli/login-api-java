package br.com.devmarco.kyroschallenge.repositories;

import br.com.devmarco.kyroschallenge.repositories.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
