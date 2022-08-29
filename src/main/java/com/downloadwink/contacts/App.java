package com.downloadwink.contacts;

import com.downloadwink.contacts.controller.EditContactController;
import com.downloadwink.contacts.controller.ListContactsController;
import com.downloadwink.contacts.model.Contact;
import com.downloadwink.contacts.model.ContactHome;
import com.downloadwink.contacts.view.EditContactPanel;
import com.downloadwink.contacts.view.ListContactsPanel;


import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Contacts");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ListContactsPanel listContactsPanel = new ListContactsPanel();
        mainFrame.getContentPane().add(listContactsPanel, BorderLayout.WEST);


        EditContactPanel editContactPanel = new EditContactPanel();
        mainFrame.getContentPane().add(editContactPanel);




        List<Contact> contacts = ContactHome.getInstance().allContacts();
        new ListContactsController(listContactsPanel, editContactPanel, contacts);


        mainFrame.pack();
        mainFrame.setVisible(true);

    }
}

