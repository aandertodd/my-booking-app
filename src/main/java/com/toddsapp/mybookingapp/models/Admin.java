package com.toddsapp.mybookingapp.models;


/**
 * Created by margareticloud on 7/25/17.
 */


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity //tells spring you want to store this class in a database
public class Admin extends AbstractEntity {


    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_-]{4,11}", message = "Invalid username")
    private String adminName;

    @NotNull
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Admin() {}

    public Admin(String adminName, String password) {
        this.adminName = adminName;
        this.pwHash = hashPassword(password);
    }

    public String getAdminName() {
        return adminName;
    }

    private static String hashPassword(String password) {
        return encoder.encode(password);
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
