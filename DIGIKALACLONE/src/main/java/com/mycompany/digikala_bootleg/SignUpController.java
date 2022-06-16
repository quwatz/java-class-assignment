/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

/**
 *
 * @author Asus
 */
public class SignUpController {
    private SignUpModel signUpModel;
    private SignUpView signUpView;
    public SignUpController(SignUpModel signUpModel,SignUpView signUpView) {
        this.signUpModel = signUpModel;
        this.signUpView = signUpView;
        signUpView.addCreateAccountControllerActionListener(new CreateAccountControllerListener());
        this.signUpView.addRedirectLoginControllerActionListener(new RedirectLoginControllerListener());
    }
    
    class CreateAccountControllerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
                  
            try{
                String  enteredFirstName = signUpView.getFirstName();
                String  enteredLastName = signUpView.getLastName();
                String enteredUsername = signUpView.getUsername();
                String enteredEmailAddress = signUpView.getEmailAddress();
                String enteredPassword = signUpView.getPassword();
                String enteredConfirmPassword = signUpView.getConfirmPassword();
                BigInteger enteredPhoneNumber = signUpView.getPhoneNumber();
                signUpModel.canCreateAccount(enteredFirstName, enteredLastName, enteredUsername, enteredPassword, enteredConfirmPassword, enteredEmailAddress, enteredPhoneNumber, signUpView);
                
            }catch (Exception exception){
                
            }
                 
                  
            
        }  
    }
    class RedirectLoginControllerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //tell model to do stuff
            signUpModel.RedirectLogin(signUpView);
        }
    }
    
    
}
