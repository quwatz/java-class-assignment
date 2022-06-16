/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class SignUpModel {
    
    
    public static boolean canCreateAccount( String firstName,
    String lastName,
    String username,
    String password,
    String confirmPassword,
    String emailAddress,
    BigInteger phoneNumber,
    JFrame frame)
    {
        
        try
        {
            if ((isStringEmpty(firstName) ||
                    isStringEmpty(username)||
                    isStringEmpty(lastName)||
                    isStringEmpty(password)||
                    isStringEmpty(confirmPassword)||
                    isStringEmpty(emailAddress)) || (phoneNumber==BigInteger.ZERO)
                    
                    ) {
             JOptionPane.showMessageDialog(frame,"Please fill all the required items!");
                     return false;
            }
            //to see if the username already exists:-->
        Connection myCon = MySQLConnection.getConnection();
        String usernameQuery = "SELECT user_name FROM users where user_name = '"
                + username+"'";
        PreparedStatement preparedStatement = myCon.prepareStatement(usernameQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){ //i changed it from a while loop to an if statement because it made more sense
            JOptionPane.showMessageDialog(frame,"Username already exists!");
            return false;
        }
        //to see if the email is taken:-->
         String emailQuery = "SELECT email FROM users where email = '"
                + emailAddress+"'";
        preparedStatement = myCon.prepareStatement(emailQuery);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            JOptionPane.showMessageDialog(frame,"This email address has been used already!");
            return false;
        }
        
        //check if password and confirmPassword match-->
        if (!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(frame, "The passwords don't match!");
            return false;
        }
        //check if the password is strong enough
        if (password.length() < 7 ){
            JOptionPane.showMessageDialog(frame, "password is too short!(must be atleast 8 letters long)");
            return false;
        }
        //if the username and the email address are unique and the passwords match and the password is strong enough
        // -> create a new row in the database
        String createUserQuery = "INSERT INTO users (name,last_name,user_name,password,email,phone_number,shopping_cart) VALUES ('"+
                firstName+"','"+lastName+"','"+username+"','"+password+"','"+emailAddress+"','0"+phoneNumber.toString()+"','[]')";
        Statement statement = myCon.createStatement();
        int result = statement.executeUpdate(createUserQuery);
        JOptionPane.showMessageDialog(frame,"Account created successfully!!");
       // resultSet = preparedStatement.executeQuery();
        }
        
        catch (Exception exception){
            JOptionPane.showMessageDialog(frame,exception.getMessage());
        }
        
        
        
        
        return false;
    }
    
    private static boolean isStringEmpty(String string){
        return (string.trim().length() == 0);
    }
    void RedirectLogin(JFrame frame){
        frame.dispose();
        new LoginPage();
    }
}
