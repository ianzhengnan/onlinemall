package com.ian.onlinemall.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by I076453 on 10/24/2016.
 */
@Entity
@Table(name = "catalog")
public class Catalog extends BaseObject{

    private String id;
    private String name;



    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
