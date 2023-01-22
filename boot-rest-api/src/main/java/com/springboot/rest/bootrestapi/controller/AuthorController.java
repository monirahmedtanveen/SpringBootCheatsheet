package com.springboot.rest.bootrestapi.controller;

import com.springboot.rest.bootrestapi.dto.AuthorRequest;
import com.springboot.rest.bootrestapi.exception.EntityNotFoundException;
import com.springboot.rest.bootrestapi.global.dto.ApiResponse;
import com.springboot.rest.bootrestapi.global.utils.EndpointUtils;
import com.springboot.rest.bootrestapi.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RequestMapping(EndpointUtils.API_PREFIX)
@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping(EndpointUtils.AUTHOR_LIST)
    public ResponseEntity<ApiResponse> getAuthorList() {
        return new ResponseEntity<>(
                new ApiResponse(
                        HttpStatus.OK.value(),
                        "Author List",
                        authorService.fetchAuthorList()
                ), HttpStatus.OK
        );
    }

    @GetMapping(EndpointUtils.SHOW_AUTHOR)
    public ResponseEntity<ApiResponse> getAuthorList(@PathVariable("id") Long authorId) throws EntityNotFoundException {
        return new ResponseEntity<>(
                new ApiResponse(
                        HttpStatus.OK.value(),
                        "Author Information",
                        authorService.fetchAuthor(authorId)
                ), HttpStatus.OK
        );
    }

    @PostMapping(EndpointUtils.CREATE_AUTHOR)
    public ResponseEntity<ApiResponse> saveAuthor(@Valid @RequestBody AuthorRequest request) throws EntityNotFoundException {
        return new ResponseEntity<>(
                new ApiResponse(
                        HttpStatus.OK.value(),
                        "Author Created Successfully",
                        authorService.saveAuthor(request)
                ), HttpStatus.OK
        );
    }

    @PutMapping(EndpointUtils.UPDATE_AUTHOR)
    public ResponseEntity<ApiResponse> updateAuthor(@Valid @RequestBody AuthorRequest request, @PathVariable("id") Long authorId) throws EntityNotFoundException {
        return new ResponseEntity<>(
                new ApiResponse(
                        HttpStatus.OK.value(),
                        "Author Updated Successfully",
                        authorService.updateAuthor(request, authorId)
                ), HttpStatus.OK
        );
    }

    @DeleteMapping(EndpointUtils.DELETE_AUTHOR)
    public ResponseEntity<ApiResponse> deleteAuthor(@PathVariable("id") Long authorId) throws EntityNotFoundException {
        authorService.deleteBook(authorId);
        return new ResponseEntity<>(
                new ApiResponse(
                        HttpStatus.OK.value(),
                        "Author Deleted Successfully"
                ), HttpStatus.OK
        );
    }
}
