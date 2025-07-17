package com.gl.lms.dto;

import com.gl.lms.entity.Books;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class AuthorsDTO {

    private Integer id;
    @NotBlank(message="Name should not be Blank or Null!")
    @Pattern(regexp = "[A-Z][a-z0-9]+\\s[a-z]+", message = "Name should be exactly 2 words!")
    private String name;
    @NotEmpty(message = "Books list should not be Empty or Null!")
    @Valid
    private List<BooksDTO> booksDTOs;
}
