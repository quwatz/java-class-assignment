/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class LoginController {
    //private model and view objects
    private LoginModel loginModel;
    private LoginView loginView;
    
    public LoginController(LoginModel loginModel,LoginView loginView){
        // on construct -> set the values for the model and view objects
        this.loginModel = loginModel;
        this.loginView = loginView;
        this.loginView.addLoginButtonListener(new loginControllerListeaner()); /* add new action listeners to the view model
        (for the buttons) so we can handle interactions in the controller object
        
        */
        this.loginView.addCreateAccountButtonListener(new CreateAccountControllerListener());//same as above
    }
    
    //inner classes --->
    class loginControllerListeaner implements ActionListener{
        //for storing username and password
        String username,password = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                //store the username and password into our variables->
                username = loginView.getEnteredUsername();
                password = loginView.getEnteredPassword();
                //use the model to check the username and password - >
                loginModel.canLogin(username, password, loginView);
                
                   
                
                
                
            }catch (Exception exception){
                loginView.displayErrorMessage(exception.getMessage()); //just incase something goes wrong, we surround everything in a try/catch
            }
        }

    }
    //same as above
    class CreateAccountControllerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                loginModel.RedirectSignup(loginView); //tell the model to do the required stuff
            }catch (Exception exception){
                loginView.displayErrorMessage(exception.getMessage()); //tell the view to display error
            }
        }
        
    }
}
