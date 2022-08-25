package com.downloadwink.contacts.model;

import java.sql.SQLException;
import java.util.List;

public class TestAddress {
    public static void main(String[] args) throws SQLException {
        AddressHome addressHome = AddressHome.getInstance();


//        //All addresses
//        List<Address> allAddresses = AddressHome.getInstance().allAddresses();
//        System.out.println("All addresses: ");
//        if (allAddresses.size() > 0) {
//            for (Address e : allAddresses) {
//                System.out.println(e);
//            }
//        } else {
//            System.out.println("No record found");
//        }


//        //Add new address
//        Address address = addressHome.addAddress("200", "1 street", "Calgary", "AB", "s2s2d5");
//        System.out.println("Added new address: ");
//        System.out.println(address);


//        //Find address by id
//        Address findById = addressHome.findById(1);
//        System.out.println(findById);


//        //Update address
//        Address updateText = addressHome.findById(4);
//        System.out.println("Old address: ");
//        System.out.println(updateText);
//        System.out.println();
////        updateText.setStreetNumber("777777");
//        Address address = AddressHome.getInstance().updateAddress(updateText, "88", "4 Ave", "Calgary", "Alberta", "s2d5f2");
//        System.out.println("New address: ");
//        System.out.println(address);


//        //Delete address
//        Address deleteAddress = addressHome.findById(4);
//        addressHome.deleteAddress(deleteAddress.getId());
//        System.out.println("Deleted address: ");
//        System.out.println(deleteAddress);


    }

}
