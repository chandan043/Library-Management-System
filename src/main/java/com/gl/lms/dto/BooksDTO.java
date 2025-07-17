package com.gl.lms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BooksDTO {

    private Integer id;
    @NotBlank(message="Title should not be blank or null!")
    private String title;

}
