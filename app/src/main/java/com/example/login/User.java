/*
* This class is created for database structure
* This a sample not the real class to be used in actual app
*
* */

package com.example.login;

public class User {
    public String fullname;
    public String email;
    public String password;
    public String phone;
    public String address;
    public String aadharno;
    User(String fname,String em,String pass,String ph,String add,String aad){
        fullname = fname;
        email = em;
        password = pass;
        phone = ph;
        address = add;
        aadharno = aad;
    }
}
