package com.acme.elegant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
@Getter
@Setter
public class User extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 200)
    //@NotNull
    //@NotBlank
    private String email;

    @Column(unique = true, length = 100)
    @NotNull
    @NotBlank
    private String username;

    @Column(length = 100)
    @NotNull
    @NotBlank
    private String password;

}