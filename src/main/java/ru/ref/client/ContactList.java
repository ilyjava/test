package ru.ref.client;


import ru.ref.server.beans.Contact;

import java.util.ArrayList;

import static ru.ref.server.db.Database.getData;

public class ContactList {

    public static  ArrayList<Contact> getAllContacts() {
            return getData("select * from contacts");
    }
}


