package com.example.consumer.termproject;

/**
 * Created by Alexis Cruz on 05/14/2016.
 */
public class UserInfo {
    int id;
    String name,address,email,pass;

    //setter and getter for ID
    public void setId( int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    //seter and getter for Name
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    //setter and getter for address
    public void setAdd(String add){
        this.address=add;
    }
    public String getAdd(){
        return this.address;
    }
    //setter and getter for email
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    //setter and getter for password
    public void setPass(String pass){
        this.pass = pass;
    }
    public String getPass(){
        return this.pass;
    }
}
