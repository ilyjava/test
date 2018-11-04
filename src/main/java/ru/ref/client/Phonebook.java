package ru.ref.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class Phonebook implements EntryPoint {

    private ServiceAsync service = GWT.create(Service.class);

    private FlexTable table = new FlexTable();
    private TextBox id;
    private TextBox name;
    private TextBox address;
    private TextBox phone;
    private VerticalPanel mainPanel = new VerticalPanel();

    AsyncCallback<ContactTable> contactTableCallback = new AsyncCallback<ContactTable>() {
        @Override
        public void onFailure(Throwable throwable) {
            String details = throwable.getMessage();

            System.out.println(details);
        }

        @Override
        public void onSuccess(ContactTable result) {
            table.removeAllRows();

            table.setBorderWidth(6);

            table.setText(0, 0, "id");
            table.setText(0, 1, "name");
            table.setText(0, 2, "address");
            table.setText(0, 3, "phone");
            table.setCellPadding(6);

            mainPanel.add(table);

            for (int i = 0; i < result.getIdArray().length; i++) {
                //Button updateBtn = new Button("update");

                id = new TextBox();
                id.setText(String.valueOf(result.getIdArray()[i]));
                id.setReadOnly(true);

                name = new TextBox();
                name.setText(result.getNameArray()[i]);

                address = new TextBox();
                address.setText(result.getAddressArray()[i]);

                phone = new TextBox();
                phone.setText(result.getPhoneArray()[i]);

                final int row = table.getRowCount();

                table.setWidget(row, 0, id);
                table.setWidget(row, 1, name);
                table.setWidget(row, 2, address);
                table.setWidget(row, 3, phone);

            }
        }
    };

    public void onModuleLoad() {
        mainPanel.add(table);
        mainPanel.setWidth("100%");
        mainPanel.setHeight("100%");
        mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        mainPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        RootPanel.get("mainContainer").add(mainPanel);

        ContactTable();


    }
    public void ContactTable() {
        if (service == null) {
            service = GWT.create(Service.class);
        }

        service.getContacts(contactTableCallback);
    }
}