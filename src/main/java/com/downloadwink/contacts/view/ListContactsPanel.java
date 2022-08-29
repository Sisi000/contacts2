package com.downloadwink.contacts.view;

import com.downloadwink.contacts.model.Contact;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class ListContactsPanel extends JPanel {
    public ListContactsPanel(){
        this.setLayout(new GridLayout(0,1));

    }

//    public JButton addContactRow(String contactName) {
//        JButton contactButton = new JButton(contactName);
//        contactButton.setBackground(Color.LIGHT_GRAY);
////        contactButton.setBorder(BorderFactory.createLineBorder(Color.lightGray));
//        contactButton.setBorderPainted(false);
//        contactButton.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                contactButton.setBackground(Color.GRAY);
//            }
//
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                contactButton.setBackground(Color.LIGHT_GRAY);
//            }
//        });
//
//        this.add(contactButton);
//        return contactButton;
//    }


    public JCheckBox addContactRow(String contactName) {
        JCheckBox contactButton = new JCheckBox(contactName);
        contactButton.setBackground(Color.LIGHT_GRAY);
//        contactButton.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        contactButton.setBorderPainted(false);
        contactButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contactButton.setBackground(Color.GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                contactButton.setBackground(Color.LIGHT_GRAY);
            }
        });

        this.add(contactButton);
        return contactButton;
    }


}
