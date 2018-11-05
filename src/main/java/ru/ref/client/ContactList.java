package ru.ref.client;

import java.io.Serializable;
import java.util.ArrayList;

public class ContactList implements Serializable {

    private ArrayList<Contact> contactList = new ArrayList<>();


    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }
}
