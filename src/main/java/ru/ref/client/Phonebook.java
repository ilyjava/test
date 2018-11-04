package ru.ref.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Phonebook implements EntryPoint {

    private VerticalPanel mainPanel = new VerticalPanel();

    Grid grid = new Grid(ContactList.getAllContacts().size(),4);

    public void onModuleLoad() {

        grid.setBorderWidth(3);

        grid.setText(0, 0, Integer.toString(ContactList.getAllContacts().get(0).getId()));
        grid.setText(0, 1, ContactList.getAllContacts().get(0).getName());
        grid.setText(0, 2, ContactList.getAllContacts().get(0).getAddress());
        grid.setText(0, 3, ContactList.getAllContacts().get(0).getPhone());
        grid.setText(1, 0, " ");
        grid.setText(1, 1, " ");
        grid.setText(1, 2, " ");
        grid.setText(1, 3, " ");
        grid.setText(2, 0, " ");
        grid.setText(2, 1, " ");
        grid.setText(2, 2, " ");
        grid.setText(2, 3, " ");
        grid.setText(3, 0, " ");
        grid.setText(3, 1, " ");
        grid.setText(3, 2, " ");
        grid.setText(3, 3, " ");
        grid.setText(4, 0, " ");
        grid.setText(4, 1, " ");
        grid.setText(4, 2, " ");
        grid.setText(4, 3, " ");
       mainPanel.add(grid);
       RootPanel.get("mainContainer").add(grid);
    }
}
