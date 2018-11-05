package ru.ref.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.ref.client.Contact;
import ru.ref.client.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ServiceImpl extends RemoteServiceServlet implements Service {

    private String user = "root";
    private String pass = "24091996";
    private String host = "localhost";
    private String port = "3306";
    private String database = "phonebook";
    private String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    private String query;

    private PreparedStatement ps = null;
    private Connection conn = null;
    private ResultSet rs;

    @Override
    public ArrayList<Contact> getContacts() {

        ArrayList<Contact> contactList = new ArrayList();
        query = "select * from contacts";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            try {
                rs.beforeFirst();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            while (rs.next()) {
                contactList.add(new Contact(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4)));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {

                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {

                }
            }
        }
        return contactList;
    }
}
