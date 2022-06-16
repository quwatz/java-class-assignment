/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;

import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class LogOut {
    public static void LogOut(JFrame context, com.mycompany.digikala_bootleg.LoginView loginScreen){
        LoginSession.isLoggedIn = false;
        context.setVisible(false);
        loginScreen.setVisible(true);
         
    }
}
