package com.example.restservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

//    public Game(long id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public Integer getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
