package com.gl.lms.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UsersDTO {

    private Integer id;

    @NotBlank(message="Name should not be Blank or Null!")
    @Pattern(regexp = "[a-z]+", message = "Name should contain only Alphabets!")
    private String name;

    @NotBlank(message="email should not be blank or null!")
    @Email(message = "email should be in valid formate!")
    public String email;

    @Valid
    @NotNull(message="libraryCardsDTO should not be Null!")
    private LibraryCardsDTO libraryCardsDTO;
}
