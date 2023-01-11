package com.springboot.rest.bootrestapi.controller;

import com.springboot.rest.bootrestapi.dto.BookRequest;
import com.springboot.rest.bootrestapi.exception.UserNotFoundException;
import com.springboot.rest.bootrestapi.global.dto.ApiResponse;
import com.springboot.rest.bootrestapi.global.utils.EndpointUtils;
import com.springboot.rest.bootrestapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RequestMapping(EndpointUtils.API_PREFIX)
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(EndpointUtils.BOOK_LIST)
    public ResponseEntity<ApiResponse> getBookList() {
        return new ResponseEntity<>(
                new ApiResponse(
                        HttpStatus.OK.value(),
                        "Book List",
                        bookService.fetchBookList()
                ), HttpStatus.OK);
    }

    @GetMapping(EndpointUtils.SHOW_BOOK)
    public ResponseEntity<ApiResponse> getBook(@PathVariable("id") Long bookId) throws UserNotFoundException {
        return new ResponseEntity<>(
                new ApiResponse(
                        HttpStatus.OK.value(),
                        "Book Information",
                        bookService.fetchBook(bookId)
                ), HttpStatus.OK);
    }

    @PostMapping(EndpointUtils.CREATE_BOOK)
    public ResponseEntity<ApiResponse> saveBook(@Valid @RequestBody BookRequest bookRequest) {
        return new ResponseEntity<>(
                new ApiResponse(
                        HttpStatus.OK.value(),
                        "Book Saved Successfully",
                        bookService.saveBook(bookRequest)
                ), HttpStatus.OK
        );
    }

    @PutMapping(EndpointUtils.UPDATE_BOOK)
    public ResponseEntity<ApiResponse> updateBook(@Valid @RequestBody BookRequest bookRequest, @PathVariable("id") Long bookId) throws UserNotFoundException {
        return new ResponseEntity<>(
                new ApiResponse(
                        HttpStatus.OK.value(),
                        "Book Updated Successfully",
                        bookService.updateBook(bookRequest, bookId)
                ), HttpStatus.OK
        );
    }

    @DeleteMapping(EndpointUtils.DELETE_BOOK)
    public ResponseEntity<ApiResponse> deleteBook(@PathVariable("id") Long bookId) throws UserNotFoundException {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(
                new ApiResponse(
                        HttpStatus.OK.value(),
                        "Book Deleted Successfully"
                ),
                HttpStatus.OK
        );
    }
}
