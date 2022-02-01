package com.example.mengaji_java.Model;

public class UserModel {
    private String name;
    private String username;
    private String password;
    private  String date;

    public UserModel(String name, String username, String password, String date) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
