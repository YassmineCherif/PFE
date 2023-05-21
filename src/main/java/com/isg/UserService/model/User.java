package com.isg.UserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull
    @Size(min = 1, max = 10)
    private String firstname;
    @NotNull
    @Size(min = 1, max = 10)
    private String lastname;
    @NotNull
    @Size(min = 8, max = 8)
    private String phoneNumber;
    private String birthDate;
    @NotNull
    @Email
    private String mail;
    @NotNull
    @Size(min = 8, max = 20)
    private String password;
    private Boolean isActive;
    private List<Order> orders;


}
