package com.rest.webservices.restfulwebservices.data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    private int id;
    @Size(min = 5, message = "Name should have atleast 5 characters")
    private String name;
    @Past
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
