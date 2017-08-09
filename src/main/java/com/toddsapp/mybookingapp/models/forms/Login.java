package com.toddsapp.mybookingapp.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by margareticloud on 8/3/17.
 */
public class Login {

    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_-]{4,20}", message = "Admin Names must be at least 5 characters, start with a letter, and contain only letters and numbers")
    private String adminName;

    @NotNull
    @Pattern(regexp = "(\\S){4,15}", message = "Password must be 4-15 non-whitespace characters")
    private String password;

    public Login() {}

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}