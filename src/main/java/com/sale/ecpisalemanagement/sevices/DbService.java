package com.sale.ecpisalemanagement.sevices;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbService {

    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sale", "root", "");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return con;
    }
}
