package com.downloadwink.contacts.controller;

import com.downloadwink.contacts.model.Contact;
import com.downloadwink.contacts.model.ContactHome;
import com.downloadwink.contacts.view.ListContactsPanel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ButtonController implements Runnable{
    private ListContactsController listController;
    private EditContactController editController;
    private JButton addButton;
    private JButton deleteButton;
    private JButton saveButton;

    public ButtonController(ListContactsController listController, EditContactController editController) {
        this.listController = listController;
        this.editController = editController;
        editController.getView().getAddButton().addActionListener(e -> {
            System.out.println("Clicked from button controller");
            try {
                refreshContactCheckBoxList();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

    }
    public void refreshContactCheckBoxList() throws SQLException {
        System.out.println("Refresh Contact method");
        ListContactsPanel listPanel = listController.getView();
        listPanel.removeAll();
        listPanel.revalidate();
        listPanel.repaint();
        List<Contact> contactList = ContactHome.getInstance().allContacts();
//        listController.setContacts(contactList);
        System.out.println(contactList);
//        System.out.println(listController.getContacts());
//        listController.addingContactListAsCheckBoxes(listPanel, editController.getView(), listController.getContacts());
//        listPanel.revalidate();
//        listPanel.repaint();
//        listPanel.getTopLevelAncestor().repaint();
//        new Thread(this).start();
    }

    @Override
    public void run() {
        List<Contact> contactList = null;
        try {
            contactList = ContactHome.getInstance().allContacts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        listController.setContacts(contactList);
        System.out.println(contactList);
        System.out.println(listController.getContacts());
        try {
            listController.addingContactListAsCheckBoxes(listController.getView(), editController.getView(), listController.getContacts());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        listController.getView().revalidate();
        listController.getView().repaint();
        listController.getView().getTopLevelAncestor().repaint();
    }
}
