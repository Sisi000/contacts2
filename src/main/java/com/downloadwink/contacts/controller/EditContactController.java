package com.downloadwink.contacts.controller;

import com.downloadwink.contacts.model.Contact;
import com.downloadwink.contacts.model.ContactHome;
import com.downloadwink.contacts.model.EmailAddress;
import com.downloadwink.contacts.view.EditContactPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static javax.swing.JOptionPane.showMessageDialog;

public class EditContactController {
    private final EditContactPanel view;

    private final ActionListener saveListener;

    private Contact contact;

    public EditContactController(EditContactPanel view, Contact contact) {
        this.view = view;
        this.contact = contact;
        view.getFirstNameField().setText(contact.getFirstName());
        view.getLastNameField().setText(contact.getLastName());
        if (contact.getPersonalEmail() != null) {
            view.getPersonalEmailField().setText(contact.getPersonalEmail().getEmail());
        } else {
            view.getPersonalEmailField().setText("");
        }

        if (contact.getWorkEmail() != null) {
            view.getWorkEmailField().setText(contact.getWorkEmail().getEmail());
        } else {
            view.getWorkEmailField().setText("");
        }

        view.getPhoneField().setText(contact.getPhoneNumber());
        view.getBirthDayField().setText(contact.getBirthDay());
        view.getAgeField().setText(String.valueOf(contact.getAge()));
        view.getNotesField().setText(contact.getNotes());


        saveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    contact.setFirstName(view.getFirstNameField().getText());
                    contact.setLastName(view.getLastNameField().getText());
                    EmailAddress personalEmail = contact.getPersonalEmail();
//                    personalEmail.setEmail(view.getPersonalEmailField().getText());
                    if (personalEmail == null) {
                        personalEmail = new EmailAddress();
                        personalEmail.setEmail(view.getPersonalEmailField().getText());
                        contact.setPersonalEmail(personalEmail);
                    } else {
                        personalEmail.setEmail(view.getPersonalEmailField().getText());
                    }
                    EmailAddress workEmail = contact.getWorkEmail();
//                    workEmail.setEmail(view.getWorkEmailField().getText());
                    if (workEmail == null) {
                        workEmail = new EmailAddress();
                        workEmail.setEmail(view.getWorkEmailField().getText());
                        contact.setWorkEmail(workEmail);
                    } else {
                        workEmail.setEmail(view.getWorkEmailField().getText());
                    }

//                    System.out.println(contact.getPersonalEmail().getEmail());
//                    System.out.println(contact.getWorkEmail().getEmail());

                    contact.setPhoneNumber(view.getPhoneField().getText());
                    contact.setBirthDay(view.getBirthDayField().getText());
                    contact.setAge(Integer.parseInt(view.getAgeField().getText()));
                    contact.setNotes(view.getNotesField().getText());

                    ContactHome.getInstance().saveContact(contact);
                    showMessageDialog(null, "Changes saved");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        view.getSaveButton().addActionListener(saveListener);

    }

    public void unhook() {
//        System.out.println("Unhooking editor for" + contact.getFirstName());
        view.getSaveButton().removeActionListener(saveListener);
    }
}
