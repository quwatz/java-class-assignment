/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    public static Connection getConnection() throws Exception{
        String dbroot = "jdbc:mysql://";
        String hostName = "localhost:3306/";
        String dbname = "mysql";
        String dbUrl = dbroot + hostName + dbname;
        
        String hostUsername = "root";
        String hostPassword = "MySqlD1giKal@";
        
        Connection myCon = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL",hostUsername,hostPassword);
        return myCon;
    }
    
}
