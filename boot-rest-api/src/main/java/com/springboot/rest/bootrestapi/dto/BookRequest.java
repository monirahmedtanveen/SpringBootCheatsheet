package com.springboot.rest.bootrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class BookRequest {
    @NotNull(message = "author id is required.")
    private long authorId;
    @NotBlank(message = "title is required.")
    private String title;
    @NotBlank(message = "sub-title is required.")
    private String subTitle;
    @NotBlank(message = "description can not be blank.")
    private String description;
    @NotNull(message = "number of pages is required.")
    private int numberOfPages;
}
