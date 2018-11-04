package ru.ref.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.ref.client.ContactTable;
import ru.ref.client.Service;

import java.sql.*;

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

    private int i = 0;

    private int[] idArray;
    private String[] nameArray;
    private String[] addressArray;
    private String[] phoneArray;

    @Override
    public ContactTable getContacts() {
        ContactTable contactTable = new ContactTable();

        query = "select * from contacts";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            int rowCount = 0;

            while (rs.next()) {
                rowCount++;
            }

            idArray = new int[rowCount];
            nameArray = new String[rowCount];
            addressArray = new String[rowCount];
            phoneArray = new String[rowCount];

            try {
                rs.beforeFirst();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            while (rs.next()) {
                idArray[i] = rs.getInt(1);
                nameArray[i] = rs.getString(2);
                addressArray[i] = rs.getString(3);
                phoneArray[i] = rs.getString(4);

                i++;
            }

            contactTable.setIdArray(idArray);
            contactTable.setNameArray(nameArray);
            contactTable.setAddressArray(addressArray);
            contactTable.setPhoneArray(phoneArray);

            i = 0;
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
        return contactTable;
    }
}
