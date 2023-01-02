package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Addressbook {
    String classname = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/paddressbook?useSSL=False";
    String username = "root";
    String password = "root";

    public Connection getCon() {
        Connection con = null;
        try {
            Class.forName(classname);
            con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                System.out.println("connected..");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public void showAllContactFromDatabase() {
        Connection con = getCon();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from addressbook");
            System.out.println("---------Records are---------");
            while (rs.next()) {
                Contact contact = new Contact(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                System.out.println(contact);
            }
            System.out.println("-----------------------------");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
