package com.toddsapp.mybookingapp.models;

/**
 * Created by margareticloud on 7/28/17.
 */

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.ConstraintValidator;
import javax.validation.Valid;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int aid;
    public int getAid() {
        return this.aid;
    }

}