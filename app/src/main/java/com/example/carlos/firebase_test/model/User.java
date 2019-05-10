package com.example.carlos.firebase_test.model;

/**
 * User class contains:
 *          User Mail
 *          User Password
 *          User Hardware Serial Number
 */


public class User {

    private String mail;
    private String password;
    private String hwserial;

    public User(String mail, String password,String hwserial) {
        this.mail = mail;
        this.password = password;
        this.hwserial = hwserial;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHWSerial() {
        return hwserial;
    }

    public void setHWSerial(String hwSerial) {
        this.hwserial = hwSerial;
    }


}
