/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;

import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class productPage {
    public productPage(int UID) throws SQLException, Exception{
        ProductView productView = new ProductView();
        ProductModel productModel = new ProductModel(UID);
        productController productController1 = new productController(productModel, productView);
        productView.setVisible(true);
        UsersManager usersManager = new UsersManager();
        productView.setWelcomeLabelText((String)usersManager.getUserPropertyByID(UID,"name"));
    
}
}
