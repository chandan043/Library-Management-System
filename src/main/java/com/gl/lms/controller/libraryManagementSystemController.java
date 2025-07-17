package com.gl.lms.controller;

import com.gl.lms.dto.AuthorsDTO;
import com.gl.lms.dto.ResponseDTO;
import com.gl.lms.dto.ReviewsDTO;
import com.gl.lms.dto.UsersDTO;
import com.gl.lms.exception.LibraryManagementSystemException;
import com.gl.lms.service.LibraryManagementSystemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/LMS")
@CrossOrigin
@Validated
public class libraryManagementSystemController {
    @Autowired
    private LibraryManagementSystemService libraryManagementSystemService;

    @PostMapping("/addUser-and-IssueLibraryCard")
    public ResponseEntity<ResponseDTO> addUserAndIssueLibraryCard(@RequestBody @Valid UsersDTO usersDTO)
            throws LibraryManagementSystemException {
        ResponseDTO responseDTO = libraryManagementSystemService.addUserAndIssueLibraryCard(usersDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUser-and-IssuedLibraryCardByEmail/{email}")
    public ResponseEntity<UsersDTO> fetchUserAndIssuedLibraryCardByEmail(@PathVariable @Email(message = "email should be in valid formate!") String email) throws LibraryManagementSystemException{
        UsersDTO userDTO = libraryManagementSystemService.fetchUserAndIssuedLibraryCardByEmail(email);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/updateNameOfUser/{email}/{updateName}")
    public ResponseEntity<ResponseDTO> updateNameOfUser(@PathVariable @Email(message = "email should be in valid formate!") String email,@PathVariable @NotBlank(message="Name should not be Blank or Null!") String updateName) throws LibraryManagementSystemException {
        ResponseDTO responseDTO = libraryManagementSystemService.updateNameOfUser(email,updateName);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser-And-AssociatedLibraryCard/{email}")
    public ResponseEntity<ResponseDTO> deleteUserAndAssociatedLibraryCard(@PathVariable @Email(message = "email should be in valid formate!") String email) throws LibraryManagementSystemException {
        ResponseDTO responseDTO = libraryManagementSystemService.deleteUserAndAssociatedLibraryCard(email);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/addAuthor-And-ItsBooks")
    public ResponseEntity<ResponseDTO> addAuthorAndItsBooks(@RequestBody @Valid AuthorsDTO authorDTO) throws LibraryManagementSystemException {
        ResponseDTO responseDTO = libraryManagementSystemService.addAuthorAndItsBooks(authorDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/addReview-To-Book/{bookTitle}")
    public ResponseEntity<ResponseDTO> addReviewToBook(@PathVariable @NotBlank(message="bookTitle should not be Blank or Null!") String bookTitle, @RequestBody @Valid ReviewsDTO reviewsDTO) throws LibraryManagementSystemException {
        ResponseDTO responseDTO = libraryManagementSystemService.addReviewToBook(bookTitle,reviewsDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getAllReviewsOfBook/{bookTitle}")
    public ResponseEntity<List<ReviewsDTO>> getAllReviewsOfBook(@PathVariable @NotBlank(message="bookTitle should not be Blank or Null!") String bookTitle) throws LibraryManagementSystemException {
        List<ReviewsDTO> reviewsDTOList = libraryManagementSystemService.getAllReviewsOfBook(bookTitle);
        return new ResponseEntity<>(reviewsDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/delectBook-And-AssociatedReviews/{bookTitle}")
    public ResponseEntity<ResponseDTO> delectBookAndAssociatedReviews(@PathVariable @NotBlank(message="bookTitle should not be Blank or Null!") String bookTitle) throws LibraryManagementSystemException {
        ResponseDTO responseDTO = libraryManagementSystemService.delectBookAndAssociatedReviews(bookTitle);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

