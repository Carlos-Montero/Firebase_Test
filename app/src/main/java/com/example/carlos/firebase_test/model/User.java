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

    /**
     * getMail()
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * setMail()
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * getPassword()
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword()
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getHWSerial
     * @return hwserial
     */
    public String getHWSerial() {
        return hwserial;
    }

    /**
     * setHWSerial
     * @param hwSerial
     */
    public void setHWSerial(String hwSerial) {
        this.hwserial = hwSerial;
    }


}
