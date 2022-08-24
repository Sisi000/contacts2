package com.downloadwink.contacts.model;

import java.util.List;

public class TestPrintContact {

    public static void main(String[] args) throws Exception {
        ContactHome contacts = ContactHome.getInstance();
        BirthDay birthDate = BirthDay.getInstance();
        Contact contact = contacts.findById(1);
        System.out.println(contact);

        //All contacts
        List<Contact> allContacts = contacts.allContacts();
        System.out.println("All contacts: ");
        if (allContacts.size() > 0) {
            for (Contact e : allContacts) {
                System.out.println(e);
            }
        } else {
            System.out.println("No record found");
        }

//        //Add contact
//        contacts.addContact("Jen", "Morisson", "1234567890", "  ", "  ", 0, null, null, null, null);
//        System.out.println("Added contact: ");
//        System.out.println("");
//        if (contacts.allContacts().size() > 0) {
//            System.out.println("New contact list: ");
//            for (Contact e : contacts.allContacts()) {
//                System.out.println(e);
//            }
//        }

        //Delete contact
//        System.out.println("Contact deleted");
//        List<Contact> someContacts2 = contacts.findByLastName("Ivansic");
//        if (someContacts2.size() > 0) {
//            for (Contact contact2 : someContacts2) {
//                contact2.remove(contacts);
//                System.out.println(contact2);
//                System.out.println("");
//                System.out.println("New contact list: ");
//                for (Contact e : contacts.allContacts()) {
//                    System.out.println(e);
//                }
//            }
//        } else {
//            System.out.println("No record found");
//        }

//       // Find by first name
//        List<Contact> someContacts = contacts.findByFirstName("Siri");
//        if (someContacts.size() > 0) {
//            for (Contact contact1 : someContacts) {
//                System.out.println(contact1);
//            }
//        }

//        //Find by last name
//        List<Contact> someContacts2 = contacts.findByLastName("Ivansic");
//        if (someContacts2.size() > 0) {
//            for (Contact contact2 : someContacts2) {
//                System.out.println(contact2);
//            }
//        }

//        //Find by phone number
//        List<Contact> someContacts3 = contacts.findByPhoneNumber("587444444");
//        if (someContacts3.size() > 0) {
//            for (Contact contact3 : someContacts3) {
//                System.out.println(contact3);
//            }
//        }

//        //Find by email
//        List<Contact> someContacts4 = contacts.findByEmail("messele@gmail.com");
//        if (someContacts4.size() > 0) {
//            for (Contact contact4 : someContacts4) {
//                System.out.println(contact4);
//            }
//        }

//        //Find by birthday
//        List<Contact> someContacts5 = contacts.findByBirthDate("24/02/1990");
//        if (someContacts5.size() > 0) {
//            for (Contact contact5 : someContacts5) {
//                System.out.println(contact5);
//            }
//        }

//        //Find by age
//        List<Contact> someContacts6 = contacts.findByAge(31);
//        if (someContacts6.size() > 0) {
//            for (Contact contact6 : someContacts6) {
//                System.out.println(contact6);
//            }
//        }

    }
}
