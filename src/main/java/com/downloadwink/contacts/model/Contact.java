package com.downloadwink.contacts.model;

import java.util.List;

public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private EmailAddress personalEmail;
    private EmailAddress workEmail;
    private String birthDay;
    private int age;
    private String notes;
    private List<Contact> siblings;
    private Contact partner;
    private String primaryAddress;


    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EmailAddress getPersonalEmail() {
        return personalEmail;
    }


    public void setPersonalEmail(EmailAddress personalEmail) {
        this.personalEmail = personalEmail;
    }

    public EmailAddress getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(EmailAddress workEmail) {
        this.workEmail = workEmail;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Contact> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Contact> siblings) {
        this.siblings = siblings;
    }

    public Contact getPartner() {
        return partner;
    }

    public void setPartner(Contact partner) {
        this.partner = partner;
    }

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", personalEmail=" + personalEmail +
                ", workEmail=" + workEmail +
                ", birthDay='" + birthDay + '\'' +
                ", age=" + age +
                ", notes='" + notes + '\'' +
                ", primaryAddress='" + primaryAddress + '\'' +
                ", siblings=" + siblings +
                ", partner=" + partner +
                '}';
    }
}
