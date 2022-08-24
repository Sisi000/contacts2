package com.downloadwink.contacts.model;

import java.sql.SQLException;

public class TestEmailContact {
    public static void main(String[] args) throws Exception {
        EmailAddressHome emailAddresses = EmailAddressHome.getInstance();
        EmailAddress emailAddress = emailAddresses.addEmail("sss@gmail.com");
        System.out.println(emailAddress);

    }
}
