package com.downloadwink.contacts.view;

import javax.swing.*;
import javax.xml.stream.XMLStreamReader;
import java.awt.*;


public class EditContactPanel extends JPanel {

    private final JButton saveButton;

    private final JButton deleteButton;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField personalEmailField;
    private final JTextField workEmailField;
    private final JTextField phoneField;
    private final JTextField birthDayField;
    private final JTextField ageField;
    private final JTextArea notesArea;


    public EditContactPanel() {


        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(0,2));
        this.add(jPanel, BorderLayout.NORTH);

        JLabel firstNameLabel = new JLabel();
        firstNameLabel.setText("First Name");
        jPanel.add(firstNameLabel);
        firstNameField = new JTextField();
        firstNameField.setColumns(15);
        jPanel.add(firstNameField);

        JLabel lastNameLabel = new JLabel();
        lastNameLabel.setText("Last Name");
        jPanel.add(lastNameLabel);
        lastNameField = new JTextField();
        lastNameField.setColumns(15);
        jPanel.add(lastNameField);

        JLabel personalEmailLabel = new JLabel();
        personalEmailLabel.setText("Personal Email");
        jPanel.add(personalEmailLabel);
        personalEmailField = new JTextField();
        personalEmailField.setColumns(15);
        jPanel.add(personalEmailField);

        JLabel workEmailLabel = new JLabel();
        workEmailLabel.setText("Work Email");
        jPanel.add(workEmailLabel);
        workEmailField = new JTextField();
        workEmailField.setColumns(15);
        jPanel.add(workEmailField);


        JLabel phoneLabel = new JLabel();
        phoneLabel.setText("Phone Number");
        jPanel.add(phoneLabel);
        phoneField = new JTextField();
        phoneField.setColumns(15);
        jPanel.add(phoneField);

        JLabel birthDayLabel = new JLabel();
        birthDayLabel.setText("Birthday");
        jPanel.add(birthDayLabel);
        birthDayField = new JTextField();
        birthDayField.setColumns(15);
        jPanel.add(birthDayField);

        JLabel ageLabel = new JLabel();
        ageLabel.setText("Age");
        jPanel.add(ageLabel);
        ageField = new JTextField();
        ageField.setColumns(15);
        jPanel.add(ageField);

        JLabel notesLabel = new JLabel();
        notesLabel.setText("Notes");
        jPanel.add(notesLabel);
        notesArea = new JTextArea();
        notesArea.setColumns(15);
//        notesArea.setRows(5);
        jPanel.add(notesArea);


        saveButton = new JButton();
        saveButton.setText("Save");
        this.add(saveButton, BorderLayout.SOUTH);

        deleteButton = new JButton();
        deleteButton.setText("Delete");
        this.add(deleteButton, BorderLayout.WEST);


    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public JTextField getPersonalEmailField() {
        return personalEmailField;
    }

    public JTextField getWorkEmailField() {
        return workEmailField;
    }

    public JTextField getPhoneField() { return phoneField; }

    public JTextField getBirthDayField() { return birthDayField; }

    public JTextField getAgeField() { return ageField; }

    public JTextArea getNotesField() { return notesArea; }






}
