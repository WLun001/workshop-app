package com.company.workshop.domain;

import java.util.UUID;

public class Participant {

    private String name;
    private String id;

    public Participant(String name){
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
