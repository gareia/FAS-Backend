package com.acme.elegant.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SaveUserResource {

    @Column(unique = true, length = 200)
    @NotNull
    @NotBlank
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
