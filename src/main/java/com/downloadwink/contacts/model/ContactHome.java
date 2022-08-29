package com.downloadwink.contacts.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactHome {

    private static ContactHome instance = new ContactHome();

    public static ContactHome getInstance() {
        return ContactHome.instance;
    }

//    private Connection connect;

    private List<Contact> contacts = new ArrayList<>();

    public ContactHome() {

    }

    Connection getConnection() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycontacts", "root", "password");

        return connect;
    }

    //All contacts
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

    //Add contacts
    public Contact addContact(String firstName, String lastName) throws SQLException {

        Connection connect = getConnection();
        PreparedStatement preparedS = connect.prepareStatement("Insert into mycontacts.contacts (firstName, lastName) values (?, ?)");
        preparedS.setString(1, firstName);
        preparedS.setString(2, lastName);
//        preparedS.setString(3, null);
//        preparedS.setString(4, null);
//        preparedS.setString(5, null);
//        preparedS.setString(6, null);
//            preparedS.setInt(7, 0);
//        preparedS.setString(8, null);
        preparedS.executeUpdate();
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        return contact;
    }

    public Contact saveContact(Contact contact) throws SQLException {
        Connection connect = ContactHome.getInstance().getConnection();
        PreparedStatement preparedS = connect.prepareStatement("update mycontacts.contacts set firstName = ?, lastName = ?, personalEmailId = ?, workEmailId = ?, phoneNumber = ?, birthDay = ?, age = ?, notes = ? where id = ?");
        preparedS.setString(1, contact.getFirstName());
        preparedS.setString(2, contact.getLastName());
        int pid = contact.getPersonalEmail() != null && contact.getPersonalEmail().getId() != 0 ? contact.getPersonalEmail().getId() : 0;
        preparedS.setInt(3, pid);
        int wid = contact.getWorkEmail() != null && contact.getWorkEmail().getId() != 0 ? contact.getWorkEmail().getId() : 0;
        preparedS.setInt(4, wid);
        preparedS.setString(5, contact.getPhoneNumber());
        preparedS.setString(6, contact.getBirthDay());
        preparedS.setInt(7, contact.getAge());
        preparedS.setString(8, contact.getNotes());
        preparedS.setInt(9, contact.getId());
        preparedS.executeUpdate();
        return contact;
    }


    public Contact updateContact(Contact contact, String firstName, String lastName, String primaryEmail, String workEmail, String phoneNumber, String birthDay, int age, String notes) throws SQLException {
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        EmailAddress newEmail = new EmailAddress();
        newEmail.setEmail(primaryEmail);
        contact.setPersonalEmail(newEmail);
        contact.setWorkEmail(newEmail);
        contact.setPhoneNumber(phoneNumber);
        contact.setBirthDay(birthDay);
        contact.setAge(age);
        contact.setNotes(notes);
        return saveContact(contact);


    }

    //Delete contacts
    public void deleteContact(Contact contact) throws SQLException {
        Connection connect = ContactHome.getInstance().getConnection();
        PreparedStatement preparedS = connect.prepareStatement("delete from mycontacts.contacts where id = ?");
        preparedS.setInt(1, contact.getId());
        preparedS.executeUpdate();
        System.out.println("Contact deleted" + " " + contact.getFirstName() + " " + contact.getLastName());
        preparedS.close();

    }


    //Find contact by id
    public Contact findById(int id) throws SQLException {

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

    //Find contact by first name
    public Contact findByFirstName(String firstName) throws SQLException {
        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        // Result set get the result of the SQL query
        ResultSet resultSet = statement
                .executeQuery("select * from mycontacts.contacts where firstName = '" + firstName + "'");
        Contact contact = new Contact();
        while (resultSet.next()) {
            extractContactFromResultSet(resultSet, contact);

        }
        statement.close();
        return contact;
    }

    private void extractContactFromResultSet(ResultSet resultSet, Contact contact) throws SQLException {
        contact.setId(resultSet.getInt("id"));
        contact.setFirstName(resultSet.getString("firstName"));
        contact.setLastName(resultSet.getString("lastName"));
        contact.setPhoneNumber(resultSet.getString("phoneNumber"));
        contact.setBirthDay(resultSet.getString("birthDay"));
        contact.setAge(resultSet.getInt("age"));
        contact.setNotes(resultSet.getString("notes"));

        int personalEmailId = resultSet.getInt("personalEmailId");
        if (personalEmailId != 0) {
            contact.setPersonalEmail(EmailAddressHome.getInstance().findById(personalEmailId));
        }
        int workEmailId = resultSet.getInt("workEmailId");
        if (workEmailId != 0) {
            contact.setWorkEmail(EmailAddressHome.getInstance().findById(workEmailId));
        }
    }

    //Find contact by last name
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

    //Find contact by phone number
    public List<Contact> findByPhoneNumber(String nameFragment) {
        List<Contact> matchingContacts = new ArrayList<Contact>();
        for (Contact i : contacts) {

            if (i.getPhoneNumber().equalsIgnoreCase(nameFragment)) {
                matchingContacts.add(i);
            }
        }
        return matchingContacts;
    }

    //Find contact by email address
    public List<Contact> findByEmail(String emailAddress) {
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact i : contacts) {
            if (i.getPersonalEmail().getEmail().equals(emailAddress) || i.getWorkEmail().getEmail().equals(emailAddress)) {
                matchingContacts.add(i);
            }
        }
        return matchingContacts;
    }

    //Find contact by birth date
    public List<Contact> findByBirthDate(String birthDate) {
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact i : contacts) {
            if (i.getBirthDay().equals(birthDate)) {
                matchingContacts.add(i);
            }
        }
        return matchingContacts;
    }

    //Find contact by age
    public List<Contact> findByAge(int age) {
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact i : contacts) {
            if (i.getAge() == age) {
                matchingContacts.add(i);
            }
        }
        return matchingContacts;
    }



}
