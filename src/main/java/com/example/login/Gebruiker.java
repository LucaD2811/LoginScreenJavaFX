package com.example.login;

public class Gebruiker {
    private String naam;
    private String username;
    private String password;

    Gebruiker(String naam, String username, String password){
        this.naam = naam;
        this.password = password;
        this.username = username;
    }

    public String getNaam() {
        return naam;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
