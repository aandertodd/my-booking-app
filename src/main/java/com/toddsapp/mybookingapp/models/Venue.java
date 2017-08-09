package com.toddsapp.mybookingapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by margareticloud on 8/7/17.
 */
@Entity
public class Venue {


    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @OneToMany
    @JoinColumn(name = "venue_id")
    private List<Shows> shows = new ArrayList<>();

    public Venue(){}

    public Venue(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shows> getShows(){
        return shows;
    }

}
