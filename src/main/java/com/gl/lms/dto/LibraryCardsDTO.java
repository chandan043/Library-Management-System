package com.gl.lms.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class LibraryCardsDTO {

    private Integer id;
    @FutureOrPresent(message = "issueDate can not be in past!")
    private LocalDate issueDate;
    @Future(message ="expiryDate can not be in past!")
    private LocalDate expiryDate;
}
