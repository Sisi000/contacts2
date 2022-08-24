package com.downloadwink.contacts.model;


public class EmailAddress {
    private int id;
    private String email;

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void validate() {
        int locationOfAt = email.indexOf('@');
        if (locationOfAt == -1) {
            throw new RuntimeException("Invalid email address");
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }

}
