package com.example.fingeso.models;

public class Login {
    String mail;
    String pass;
    public Login(String mail, String pass){
        this.mail = mail;
        this.pass = pass;
    }
    public String getMail(){
        return mail;
    }
    public String getPass(){
        return pass;
    }
}
