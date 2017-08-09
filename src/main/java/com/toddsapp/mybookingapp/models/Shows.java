package com.toddsapp.mybookingapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by margareticloud on 7/25/17.
 */
@Entity
public class Shows {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=50, message="Name must be at least 3 letters")
    private String name;

    @NotNull
    @Size(min=3, max=100, message="Description must be at least 3 letters")
    private String description;

    @ManyToOne
    private Venue venue;

    public Shows(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Shows(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVenue(Venue venue) { this.venue = venue; }

    public Venue getVenue() { return venue;}
}
