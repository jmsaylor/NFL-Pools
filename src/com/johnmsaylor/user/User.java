package com.johnmsaylor.user;

import java.time.LocalDate;

public class User {
    public String name;
    public String firstName;
    public String lastName;
    public String middleName;
    public LocalDate birthdate;

    public User(String name) {
        this.name = name;
    }
}
