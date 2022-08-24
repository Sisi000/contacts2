package com.downloadwink.contacts.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactHome {

    private static ContactHome instance = new ContactHome();

    public static ContactHome getInstance() {
        return ContactHome.instance;
    }

    private Connection connect;

    private List<Contact> contacts = new ArrayList<>(); // it will add new to contacts list

    private ContactHome() {

    }

    private void createInitialContacts() throws SQLException {
        addContact("Tony", "Enerson", "tony@enerson.ca", "587111111", "20/12/1985", 37, "Tony is a great guy", "Avenue 12", "brother", "wife");
        addContact("Messele", "Ghebreslassie", "messele@gmail.com", "587222222", "15/02/1990", 32, "Messele is a great guy", "Avenue 14", "cousin", "spouse");
        addContact("Sanja", "Ivansic", "sanja@invansic.ca", "587333333", "24/02/1990", 32, "Sanja is a great girl", "Avenue 16", "sister", "partner");
        addContact("Siri", "Lakku", "siri@lakku.ca", "587444444", "25/07/1991", 31, "Siri is a great girl", "Avenue 18", "cousin", "husband");
        addContact("siri", "Google", "siri@google.ca", "587555555", "18/05/1993", 29, "Siri is a second great girls", "Avenue 20", "sister", "husband");
    }

    public void addContact(String firstName, String lastName, String personalEmail, String phoneNumber, String birthDay, int age, String notes, String address, String siblings, String partner) throws SQLException {
        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        statement.execute("INSERT INTO contacts (firstName, lastName) VALUES ('" + firstName + "', '" + lastName + "')");
    statement.close();


    }

    public List<Contact> allContacts() throws SQLException {
        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        // Result set get the result of the SQL query
        ResultSet resultSet = statement
                .executeQuery("select * from mycontacts.contacts");
        List<Contact> allContacts = new ArrayList<>();
        while (resultSet.next()) {
            Contact contact = new Contact();
            extractContactFromResultSet(resultSet, contact);

            allContacts.add(contact);

        }
        statement.close();
        return allContacts;
    }

    private void extractContactFromResultSet(ResultSet resultSet, Contact contact) throws SQLException {
        contact.setId(resultSet.getInt("id"));
        contact.setFirstName(resultSet.getString("firstName"));
        contact.setLastName(resultSet.getString("lastName"));
        int personalEmailId = resultSet.getInt("personalEmailId");
        if (personalEmailId != 0) {
            contact.setPersonalEmail(EmailAddressHome.getInstance().findById(personalEmailId));
        }
    }

    public Contact findById(int id) throws SQLException, ClassNotFoundException {

        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        // Result set get the result of the SQL query
        ResultSet resultSet = statement
                .executeQuery("select * from mycontacts.contacts where id = " + id);
        Contact contact = new Contact();
        while (resultSet.next()) {
            extractContactFromResultSet(resultSet, contact);
        }
        statement.close();
        return contact;
    }

    private Connection getConnection() throws SQLException {
        if (connect == null) {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycontacts", "root", "password");
        }
        return connect;
    }

    public List<Contact> findByFirstName(String nameFragment) {
        List<Contact> matchingContacts = new ArrayList<Contact>();
        for (Contact i : contacts) {

            if (i.getFirstName().equalsIgnoreCase(nameFragment)) {
                matchingContacts.add(i);
            }
        }
        return matchingContacts;
    }

    public List<Contact> findByLastName(String nameFragment) {
        List<Contact> matchingContacts = new ArrayList<Contact>();
        for (Contact i : contacts) {

            if (i.getLastName().equalsIgnoreCase(nameFragment)) {
                matchingContacts.add(i);
            }

        }
        if (matchingContacts.size() == 0) {
            System.out.println("Contact lastname not found");
        }
        return matchingContacts;
    }

    public List<Contact> findByPhoneNumber(String nameFragment) {
        List<Contact> matchingContacts = new ArrayList<Contact>();
        for (Contact i : contacts) {

            if (i.getPhoneNumber().equalsIgnoreCase(nameFragment)) {
                matchingContacts.add(i);
            }
        }
        return matchingContacts;
    }

    public List<Contact> findByEmail(String emailAddress) {
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact i : contacts) {
            if (i.getPersonalEmail().getEmail().equals(emailAddress) || i.getWorkEmail().getEmail().equals(emailAddress)) {
                matchingContacts.add(i);
            }
        }
        return matchingContacts;
    }

    public List<Contact> findByBirthDate(String birthDate) {
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact i : contacts) {
            if (i.getBirthDay().equals(birthDate)) {
                matchingContacts.add(i);
            }
        }
        return matchingContacts;
    }

    public List<Contact> findByAge(int age) {
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact i : contacts) {
            if (i.getAge() == age) {
                matchingContacts.add(i);
            }
        }
        return matchingContacts;
    }


    public void remove(Contact contact) {
        contacts.remove(contact);
    }

    public void addNewContact(Contact contact) {
        contacts.add(contact);
    }
}
