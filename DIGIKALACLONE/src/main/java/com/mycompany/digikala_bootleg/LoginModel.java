/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class LoginModel {
    private static int userID;
    // boolean , returns true if username and password are correct
    public static boolean canLogin(String username,String password,JFrame frame){
        try {
            //connecting to mysql using the predefined class mysqlconnection
            Connection myCon = MySQLConnection.getConnection();
            String query =  //we run this in the sql to try and find a row with the giver username and password
                    "SELECT id, user_name , password FROM users WHERE user_name = '" + username +"' AND password = '" + password + "'";
            PreparedStatement preparedStatement = myCon.prepareStatement(query);//prepared statement
            ResultSet resultSet = preparedStatement.executeQuery();//run sql statement
            while (resultSet.next()){ //if we found any results ->
                //store the found username and password in new local variables->
                String foundPassString = resultSet.getString("password");
                String foundUsernameString = resultSet.getString("user_name");
                
                //store the UID because someone in the internet told me to do so :/
                int foundUserID =  resultSet.getInt("id");
                //because mysql select command isn't case sensitive we check we manually check the password one more time-> 
                boolean isPass = (foundPassString.equals(password));
                if(!isPass) break;//we break out of the loop if they don't match
                
                //for debugging will be replaced by actual code later
                userID = foundUserID;
                RedirectDashboard(frame,username);
                return true;
            }
            
            
        }catch (Exception e){ JOptionPane.showMessageDialog(frame,"error: "+ e.getMessage());
            
        }
        JOptionPane.showMessageDialog(frame,"Invalid username or password"); //just to be safe
        return false;// if we didn't succeed , return false
        
    }
    // for redirecting to a sign up page
    void RedirectSignup(JFrame frame){
        frame.dispose(); //close the given Jframe which is log in page
        new SignUpPage(); //open a new instance of signuppage class 
    }
    // for redirecting to digikala dashboard (temporarily empty)
    static void RedirectDashboard(JFrame frame,String user_name) throws Exception{
        frame.dispose();
        UsersManager usersManager = new UsersManager();
        new productPage(userID);
        
    }
    
}
