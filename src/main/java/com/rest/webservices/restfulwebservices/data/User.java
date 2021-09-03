package com.rest.webservices.restfulwebservices.data;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private Date Birthdate;

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

    public Date getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(Date birthdate) {
        Birthdate = birthdate;
    }

    public User(int id, String name, Date birthdate) {
        this.id = id;
        this.name = name;
        Birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Birthdate=" + Birthdate +
                '}';
    }
}
