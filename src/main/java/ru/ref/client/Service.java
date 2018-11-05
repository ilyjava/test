package ru.ref.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;


@RemoteServiceRelativePath("service")
public interface Service extends RemoteService {
    ArrayList<Contact> getContacts();
}
