package ru.ref.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.SelectionChangeEvent;

import com.google.gwt.view.client.SingleSelectionModel;


public class Phonebook implements EntryPoint {

    private ServiceAsync service = GWT.create(Service.class);



    public void onModuleLoad() {

        CellTable<Contact> cellTableOfContacts = new CellTable<>();
        cellTableOfContacts.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);

        TextColumn<Contact> columnIdLine = new TextColumn<Contact>() {
            @Override
            public String getValue(Contact contact) {
                return String.valueOf(contact.getId());
            }
        };
        cellTableOfContacts.addColumn(columnIdLine, "Id");

        TextColumn<Contact> columnNameLine = new TextColumn<Contact>() {
            @Override
            public String getValue(Contact contact) {
                return contact.getName();
            }
        };
        cellTableOfContacts.addColumn(columnNameLine, "Name");

        TextColumn<Contact> columnAddressLine = new TextColumn<Contact>() {
            @Override
            public String getValue(Contact contact) {
                return contact.getAddress();
            }
        };
        cellTableOfContacts.addColumn(columnAddressLine, "Address");

        TextColumn<Contact> columnPhoneLine = new TextColumn<Contact>() {
            @Override
            public String getValue(Contact contact) {
                return contact.getAddress();
            }
        };
        cellTableOfContacts.addColumn(columnPhoneLine, "Phone");

        final SingleSelectionModel<Contact> selectionModel = new SingleSelectionModel();
        cellTableOfContacts.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent selectionChangeEvent) {
                Contact selectedContact = selectionModel.getSelectedObject();
                if (selectedContact != null) {
                    Window.alert("Selected: Id line: " + selectedContact.getId() + ", Address line: " + selectedContact.getAddress());
                }
            }
        });
        cellTableOfContacts.setRowCount(5, true);


        VerticalPanel vp = new VerticalPanel();
        vp.setBorderWidth(1);
        vp.add(cellTableOfContacts);

        RootPanel.get().add(vp);

        service.getContacts(new AsyncCallback<ContactList>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(ContactList contactList) {
                cellTableOfContacts.setRowData(0,  contactList.getContactList());
            }
        });
    }
}