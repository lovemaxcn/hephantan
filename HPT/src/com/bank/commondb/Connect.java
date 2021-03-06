/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.commondb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Quang Ha
 */
public class Connect {
    public static Connection getMySQLConnection(String dbName) throws SQLException,ClassNotFoundException {
        String hostName = "localhost";
        String userName = "root";
        String password = "hoilamchi123";
        return getMySQLConnection(hostName, dbName, userName, password);
    }
    public static Connection getMySQLConnection(String hostName, String dbName,
        String userName, String password) throws SQLException,ClassNotFoundException {
        // Khai báo class Driver cho DB MySQL
        // Việc này cần thiết với Java 5
        // Java6 tự động tìm kiếm Driver thích hợp.
        // Nếu bạn dùng Java6, thì ko cần dòng này cũng được.
//        Class.forName("com.bank.jdbc.Driver");
        // Cấu trúc URL Connection dành cho Oracle
        // Ví dụ: jdbc:mysql://localhost:3306/simplehr
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection conn = DriverManager.getConnection(connectionURL, userName,password);
        return conn;
    }
}
