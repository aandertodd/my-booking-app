package com.toddsapp.mybookingapp.models.forms;

import javax.validation.constraints.NotNull;

/**
 * Created by margareticloud on 8/3/17.
 */
public class Signup extends Login {

    @NotNull(message = "Passwords to not match")
    private String verifyPassword;

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
        checkPasswordForRegistration();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPasswordForRegistration();
    }

    private void checkPasswordForRegistration() {
        if (!getPassword().equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}