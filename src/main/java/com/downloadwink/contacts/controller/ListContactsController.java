package com.downloadwink.contacts.controller;

import com.downloadwink.contacts.model.Contact;
import com.downloadwink.contacts.view.EditContactPanel;
import com.downloadwink.contacts.view.ListContactsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ListContactsController {

    private EditContactController editContactController;
    private final ListContactsPanel view;
    private List<Contact> contacts;

    public ListContactsPanel getView() {
        return view;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public ListContactsController(ListContactsPanel view, EditContactPanel editView, List<Contact> contacts) throws SQLException {
        this.contacts = contacts;
        this.view = view;
        this.editContactController = new EditContactController(editView, contacts.get(0), this);
        addingContactListAsCheckBoxes(view, editView, contacts);
    }

    public void addingContactListAsCheckBoxes(ListContactsPanel view, EditContactPanel editView, List<Contact> contacts) throws SQLException {
        extracted(view, editView, contacts);
    }

    public void extracted(ListContactsPanel view, EditContactPanel editView, List<Contact> contacts) throws SQLException {
            new ButtonController(ListContactsController.this, editContactController);
        System.out.println("Clicked from list controller");
        for (Contact contact : contacts) {
            JCheckBox contactRow = view.addContactRow(contact.getFirstName() + " " + contact.getLastName());
            contactRow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (editContactController != null) {
                        editContactController.unhook();
                    }
                    try {
                        editContactController = new EditContactController(editView, contact, ListContactsController.this);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

//                    System.out.println(contact.getPersonalEmail().getEmail());
                }
            });

        }


    }
}
