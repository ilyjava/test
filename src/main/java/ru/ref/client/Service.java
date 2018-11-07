package ru.ref.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.ref.shared.Contact;

import java.util.ArrayList;


@RemoteServiceRelativePath("service")
public interface Service extends RemoteService {
    ArrayList<Contact> getContacts();
    void updateFish(int id, String name, String address, String phone);
}

