package com.google.ar.core.examples.java.helloar;

public class User {

    String id = "";
    String name = "";
    String password = "";


    public User(){ }

    public User(String id){this.id = id;}

    public User(String id , String pw, String name){
        this.id = id;
        this.password = pw;
        this.name = name;

    }

    public User(User user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.name = user.getName();
    }

    public void setId(String ID) { this.id = ID; }
    public void setPW(String pw){ this.password = pw; }

    public void setName(String Name){
        this.name = Name;
    }

    public String getId() { return id; }
    public String getPassword() { return password; }
    public String getName() { return name; }
}
