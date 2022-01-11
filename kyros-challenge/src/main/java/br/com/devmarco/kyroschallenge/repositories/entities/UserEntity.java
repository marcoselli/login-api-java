package br.com.devmarco.kyroschallenge.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_USUARIOS")
@SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", initialValue = 1, allocationSize = 1)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name = "COD_USUARIO")
    private Long id;

    @Column(name = "DES_EMAIL", unique = true)
    private String email;

    @Column(name = "DES_SENHA")
    private String password;
}
