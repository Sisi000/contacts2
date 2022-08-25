package com.downloadwink.contacts.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailAddressHome {
    private static EmailAddressHome instance = new EmailAddressHome();

    public static EmailAddressHome getInstance() {
        return EmailAddressHome.instance;
    }

    private Connection connect;

    private Connection getConnection() throws SQLException {
        if (connect == null) {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycontacts", "root", "password");
        }
        return connect;
    }

    //All emails
    public List<EmailAddress> allEmails() throws SQLException {
        List<EmailAddress> allEmails = new ArrayList<>();
        String sql = "SELECT * FROM emailaddresses";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EmailAddress emailAddress = new EmailAddress();
                emailAddress.setId(resultSet.getInt("id"));
                emailAddress.setEmail(resultSet.getString("email"));
                allEmails.add(emailAddress);
            }
        }
        return allEmails;
    }

    //Add new email
    public EmailAddress addEmail(String email) throws SQLException {
        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        statement.execute("INSERT INTO emailaddresses (email) VALUES ('" + email + "')");
        statement.close();

        ResultSet resultSet = connect.createStatement()
                .executeQuery("SELECT * FROM emailaddresses where email = '" + email + "'");
        EmailAddress newEmail = new EmailAddress();
        while (resultSet.next()) {
            extractEmailAddressFromResultSet(resultSet, newEmail);

        }
        return newEmail;
    }

    private static void extractEmailAddressFromResultSet(ResultSet resultSet, EmailAddress newEmail) throws SQLException {
        newEmail.setId(resultSet.getInt("id"));
        newEmail.setEmail(resultSet.getString("email"));
    }

    //Find email by id
    public EmailAddress findById(int id) throws SQLException {

        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        // Result set get the result of the SQL query
        ResultSet resultSet = statement
                .executeQuery("select * from mycontacts.emailaddresses where id = " + id);
        EmailAddress email = new EmailAddress();
        while (resultSet.next()) {
            extractEmailAddressFromResultSet(resultSet, email);

        }
        statement.close();
        return email;
    }


    //Edit email
    public EmailAddress editEmail(int id, String email) throws SQLException {
        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        statement.execute("UPDATE emailaddresses SET email = '" + email + "' WHERE id = " + id);
        statement.close();
        ResultSet resultSet = connect.createStatement()
                .executeQuery("SELECT * FROM emailaddresses where email = '" + email + "'");
        EmailAddress newEmail = new EmailAddress();
        while (resultSet.next()) {
            extractEmailAddressFromResultSet(resultSet, newEmail);

        }
        return newEmail;
    }
    //Delete email
    public EmailAddress deleteEmail(int id) throws SQLException {
        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        statement.execute("DELETE FROM emailaddresses WHERE id = " + id);
        statement.close();
        ResultSet resultSet = connect.createStatement()
                .executeQuery("SELECT * FROM emailaddresses where id = " + id);
        EmailAddress email = new EmailAddress();
        while (resultSet.next()) {
            extractEmailAddressFromResultSet(resultSet, email);

        }
        return email;
    }

}
