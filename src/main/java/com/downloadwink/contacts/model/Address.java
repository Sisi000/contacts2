package com.downloadwink.contacts.model;

public class Address {
    private int id;
    private String streetName;
    private String streetNumber;
    private String city;
    private String province;
    private String postalCode;


    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    @Override
    public String toString() {
        return String.format("%s %s %s, %s, %s", id, streetNumber, streetName, city, province, postalCode);
    }
}
