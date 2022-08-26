package com.downloadwink.contacts.view;

import javax.swing.*;
import java.awt.*;

public class ListContactsPanel extends JPanel {
    public ListContactsPanel(){
        this.setLayout(new GridLayout(0,1));


    }

    public JButton addContactRow(String contactName) {
        JButton contactButton = new JButton(contactName);
        this.add(contactButton);
        return contactButton;
    }
}
