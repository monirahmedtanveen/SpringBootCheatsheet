package com.springboot.rest.bootrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class AuthorRequest {
    @NotBlank(message = "name is required.")
    private String name;
    @Email(message = "invalid email given.")
    @NotBlank(message = "email is required.")
    private String email;
    @Pattern(regexp = "^\\+(964)[0-9]{10}$", message = "invalid author mobile is given.")
    @NotBlank(message = "mobile number is required.")
    private String mobileNumber;
}
