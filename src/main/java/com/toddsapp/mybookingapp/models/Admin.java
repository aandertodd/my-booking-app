package com.toddsapp.mybookingapp.models;


/**
 * Created by margareticloud on 7/25/17.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Admin{

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15, message="Name must be at least 3 letters")
    private String name;

    @NotNull
    @Size(min=3, max=15, message="Description must be at least 3 letters")
    private String password;


    public Admin(String name, String password){
        this.name = name;
        this.password = password;
    }

    public Admin(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}