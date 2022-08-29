package com.downloadwink.contacts.controller;

import com.downloadwink.contacts.model.Contact;
import com.downloadwink.contacts.model.ContactHome;
import com.downloadwink.contacts.model.EmailAddress;
import com.downloadwink.contacts.view.EditContactPanel;
import com.downloadwink.contacts.view.ListContactsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class EditContactController {
    private final EditContactPanel view;

    private final ActionListener saveListener;

    private Contact contact;
    private List<Contact> updatedContacts;
private ListContactsController listController;

    public EditContactPanel getView() {
        return view;
    }

    public EditContactController(EditContactPanel view, Contact contact, ListContactsController listController) throws SQLException {
        this.view = view;
        this.contact = contact;
        this.listController = listController;

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

        //Add button
        ActionListener addListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String firstName = view.getFirstNameField().getText();
                    String lastName = view.getLastNameField().getText();
                    ContactHome.getInstance().addContact(firstName, lastName);

                    view.getFirstNameField().setText("");
                    view.getLastNameField().setText("");
                    System.out.println("add button clicked");
                    showMessageDialog(null, "Contact added successfully");

//                        EmailAddress personalEmail = contact.getPersonalEmail();
//                        if (personalEmail == null) {
//                            personalEmail = new EmailAddress();
//                            personalEmail.setEmail(view.getPersonalEmailField().getText());
//                            contact.setPersonalEmail(personalEmail);
//                        } else {
//                            personalEmail.setEmail(view.getPersonalEmailField().getText());
//                        }
//
//                        EmailAddress workEmail = contact.getWorkEmail();
//                        if (workEmail == null) {
//                            workEmail = new EmailAddress();
//                            workEmail.setEmail(view.getWorkEmailField().getText());
//                            contact.setWorkEmail(workEmail);
//                        } else {
//                            workEmail.setEmail(view.getWorkEmailField().getText());
//                        }
//                        contact.setPhoneNumber(view.getPhoneField().getText());
//                        contact.setBirthDay(view.getBirthDayField().getText());
//                        contact.setAge(Integer.parseInt(view.getAgeField().getText()));
//                        contact.setNotes(view.getNotesField().getText());


//                    showMessageDialog(null, "Changes saved");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        view.getAddButton().addActionListener(addListener);


        //Delete button
        ActionListener deleteListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ContactHome.getInstance().deleteContact(contact);

                    listController.extracted(listController.getView(), view, ContactHome.getInstance().allContacts());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        };
        view.getDeleteButton().addActionListener(deleteListener);


        //Save button
        saveListener = new

                ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            contact.setFirstName(view.getFirstNameField().getText());
                            contact.setLastName(view.getLastNameField().getText());

                            EmailAddress personalEmail = contact.getPersonalEmail();
                            if (personalEmail == null) {
                                personalEmail = new EmailAddress();
                                personalEmail.setEmail(view.getPersonalEmailField().getText());
                                contact.setPersonalEmail(personalEmail);
                            } else {
                                personalEmail.setEmail(view.getPersonalEmailField().getText());
                            }

                            EmailAddress workEmail = contact.getWorkEmail();
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
                            //                    showMessageDialog(null, "Changes saved");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }

        ;
        view.getSaveButton().

                addActionListener(saveListener);

    }



    public void unhook() {
//        System.out.println("Unhooking editor for" + contact.getFirstName());
        view.getSaveButton().removeActionListener(saveListener);
        view.getDeleteButton().removeActionListener(saveListener);
    }
}
