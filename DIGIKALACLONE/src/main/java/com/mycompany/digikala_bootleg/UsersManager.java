/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class UsersManager {
    
    public Object getUserPropertyByID(int UID,String columnName) throws SQLException, Exception{
        String query = "SELECT "+columnName+" FROM users WHERE id = " + Integer.toString(UID);
        Connection myCon = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = myCon.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) return resultSet.getObject(columnName);
        else return null;
        
    }
    public Object getUserPropertyByUsername(String username,String columnName) throws SQLException, Exception{
        String query = "SELECT "+columnName+" FROM users WHERE user_name = '" + username+"'";
        Connection myCon = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = myCon.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) return resultSet.getObject(columnName);
        else return null;
        
    }
    
}
