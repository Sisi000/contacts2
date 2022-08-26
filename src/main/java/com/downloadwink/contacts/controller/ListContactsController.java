package com.downloadwink.contacts.controller;

import com.downloadwink.contacts.model.Contact;
import com.downloadwink.contacts.view.EditContactPanel;
import com.downloadwink.contacts.view.ListContactsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListContactsController {

    private EditContactController editContactController;

    public ListContactsController(ListContactsPanel view, EditContactPanel editView, List<Contact> contacts){
        for (Contact contact : contacts) {
            JButton contactRow = view.addContactRow(contact.getFirstName() + " " + contact.getLastName());
            contactRow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (editContactController != null) {
                        editContactController.unhook();
                    }
                    editContactController = new EditContactController(editView, contact);
//                    System.out.println(contact.getPersonalEmail().getEmail());
                }
            });
        }

    }
}
