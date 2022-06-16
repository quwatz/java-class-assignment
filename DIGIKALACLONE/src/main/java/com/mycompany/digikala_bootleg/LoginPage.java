
package com.mycompany.digikala_bootleg;

import com.mysql.cj.conf.StringProperty;


public class LoginPage {

    public LoginPage() {
        //on construct -->
        //make new view and model objects and feed them into a new controller
        LoginView loginView = new LoginView();
        LoginModel loginModel = new LoginModel();
        LoginController loginController = new LoginController(loginModel, loginView);
        loginView.setVisible(true);//set the view object's visibility to true just incase
    }
    
}
