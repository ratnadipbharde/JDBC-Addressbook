package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
