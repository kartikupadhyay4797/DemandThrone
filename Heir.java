package com.example.demandthrone;

import java.io.Serializable;

public class Heir implements Serializable {
    private String name,house;

    public Heir(String name, String house) {
        this.name = name;
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public String getHouse() {
        return house;
    }
}
