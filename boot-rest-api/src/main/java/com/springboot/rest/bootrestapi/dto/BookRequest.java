package com.springboot.rest.bootrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class BookRequest {
    @NotNull(message = "title is required.")
    private String title;
    @NotNull(message = "author is required.")
    private String author;
    @Email(message = "invalid author email is given.")
    @NotNull(message = "author email is required.")
    private String authorEmail;
    @Pattern(regexp = "^\\+(964)[0-9]{10}$", message = "invalid author mobile is given.")
    @NotNull(message = "author mobile is required.")
    private String authorMobile;
    @NotBlank(message = "description can not be blank.")
    private String description;
}
