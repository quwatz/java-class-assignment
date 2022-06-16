/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.xdevapi.DbDoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InventoryManager {
   
    
    
    
    public void removeShoppingCartFromInventory(int UID) throws Exception{
        ProductModel productModel = new ProductModel(UID);
        ArrayList<DbDoc> shoppingCart = null;
        try {
           shoppingCart =  productModel.getShoppingCartByID(UID);
           String fileReportQuery = "INSERT INTO payments (user_id,shopping_cart) VALUES ("+UID+",'"+shoppingCart.toString()+"')";
           Connection newMyCon = MySQLConnection.getConnection();
           Statement statement = newMyCon.createStatement();
           statement.execute(fileReportQuery);
        } catch (Exception ex) {
            System.out.println("bruh failed");
        }
        shoppingCart.forEach((profile) -> {
            int productID = Integer.parseInt(profile.get("product_id").toString());
            int productQuantity = Integer.parseInt(profile.get("product_quantity").toString());
            
            
            try {
                String findProductQuery = "SELECT quantity FROM products WHERE id = " + Integer.toString(productID);
                Connection myCon = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = myCon.prepareStatement(findProductQuery);
                ResultSet resultSet  = preparedStatement.executeQuery();
                if (resultSet.next()){
                    int quantity = resultSet.getInt("quantity");
                    int newQuantity = quantity - productQuantity;
                    newQuantity = Math.max(newQuantity, 0);
                    String alterQuantityUpdate = "UPDATE products SET quantity = "+ newQuantity + " WHERE id = "+ productID;
                    System.out.println(alterQuantityUpdate);
                    System.out.println(newQuantity);
                    preparedStatement = myCon.prepareStatement(alterQuantityUpdate);
                    preparedStatement.executeUpdate();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            
            
            
            
            
        });
    }
    
}
