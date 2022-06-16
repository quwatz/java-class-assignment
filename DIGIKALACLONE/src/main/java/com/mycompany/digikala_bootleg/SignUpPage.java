/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;

/**
 *
 * @author Asus
 */
public class SignUpPage {
//constructor -> (shouldn't be static so we can make more than one instance whenever we want i guess...
    public SignUpPage() {
        //make new instances of the view model and controller objects 
        SignUpView signUpView = new SignUpView();
        SignUpModel signUpModel = new SignUpModel();
        SignUpController signUpController = new SignUpController(signUpModel, signUpView); //feed the view and model objects to the controller
        signUpView.setVisible(true);//just incase set the visibility to true
    }
    
    
}
