package com.gl.lms.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReviewsDTO {

    private Integer id;

    @NotBlank(message = "The Rating should not be null or blank!")
    @Min(value =1 ,message="Rating must be At-least is 1")
    @Max(value =5 ,message="Rating must be At-most is 5")
    private Integer rating;

    @NotBlank(message = "The comment should not be null or blank!")
    private String comment;

    @Valid
    @NotNull(message = "The comment should not be null!")
    private BooksDTO booksDTO;
}
