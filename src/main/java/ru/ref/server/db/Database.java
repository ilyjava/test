package ru.ref.server.db;

import ru.ref.server.beans.Contact;
import ru.ref.client.ContactList;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static Connection conn = null;

    private static ArrayList<Contact> contactList = new ArrayList<>();

    public static ArrayList<Contact> getData(String str){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook?useUnicode=true&useJDBCCompliantTime zoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "24091996");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("contact_name"));
                contact.setAddress(rs.getString("addr"));
                contact.setPhone(rs.getString("phone"));
                contactList.add(contact);
            }
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContactList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return contactList;
    }

}
