/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;



import com.mysql.cj.xdevapi.*;
import java.awt.List;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.math.BigInteger;
import java.rmi.server.UID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;



/**
 *
 * @author Asus
 */
public class ProductModel {
   static int userID;
    static boolean isDuplicate =false;
    static JsonValue duplicateProfile;
    static boolean didFind = false;
    static JsonValue foundProfile;
    static DbDoc foundCartProfile;
    static boolean didCartFind = false;
    //for testing
    ProductView productView;
    //for debugging directly from the product model-->
    public ProductModel(int UID){
        this.userID = UID;
    }
    public static void main(String args[]) throws Exception{
        addProductToShoppingCart(1, 7, 3);
        addProductToShoppingCart(1, 3, 14);
        
    }
    public static void addProductToShoppingCart(int UID ,int productKey,int productQuantity){
        try {
           
            //make a parser duh
            JsonParser parser = new JsonParser();
            // make a new json array to store user's existing shopping cart
            JsonArray shoppingCartArray = new JsonArray();
            //get connection 
            Connection myCon = MySQLConnection.getConnection();
            DbDoc newProductProfile = productProfile(productKey, productQuantity);
            
            //to see if a user with the given id exists->
            String findUserQuery = "SELECT shopping_cart FROM users WHERE id = " + Integer.toString(UID);
            PreparedStatement preparedStatement = myCon.prepareStatement(findUserQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
             
            while (resultSet.next())
            {
               
                //get what the user currently has in the shopping_cart column
                String jsonString = resultSet.getString("shopping_cart");
               // if it's null then set it to an empty array so it can be forget into a json array later
                if (jsonString == null) jsonString = "[]";
                
             
                if (jsonString != null){ //if it's not null then->
                //forge it into an array 
                 
                //System.out.println("not null");   debugging
                shoppingCartArray = parser.parseArray(new StringReader(jsonString));//do the thing
                    
                
                isDuplicate = false; //to see if there is a duplicate, first assume that there is none
                shoppingCartArray.forEach((profile) -> { 
                    
                    try {
                        if (dbDocFromString(profile.toString()).get("product_id").toString().equals(Integer.toString(productKey))){
                            
                            System.out.println("this key exists!");
                            
                            isDuplicate = true; //but once you fount one , set isDuplicate to true
                            duplicateProfile = profile; //for later use
                        }
                        
                    } catch (IOException ex) {
                        //no exceptions cuz we're too good
                    }
                    
                
                
                });
                //if the object is not a duplicate:
                boolean doDelete = false;
                if (!isDuplicate){ 
                    //add it to the shopping cart array
                    shoppingCartArray.add(newProductProfile);
               
                
                    
                }
               
                //if it IS a duplicate
                else
                {
                    //get its index in the array
                    int duplicateIndex = shoppingCartArray.indexOf(duplicateProfile);
                    //make a DbDoc out of it cuz java hates me
                    DbDoc existingProfile = dbDocFromString(shoppingCartArray.get(duplicateIndex).toString());
                    //calculate the new quantity (old + new)
                    int newQuantity = Integer.parseInt(existingProfile.get("product_quantity").toString()) + productQuantity;
                    //make a merged profile to replace the old one
                    doDelete = (newQuantity <=0);
                    DbDoc mergedProfile = productProfile(productKey, newQuantity);
                    //do it
                    shoppingCartArray.set(duplicateIndex, mergedProfile);
                }
                //execute the sql update thingy
                String insertJsonUpdate = "UPDATE users SET shopping_cart ='"+shoppingCartArray.toString()+"' WHERE id ="+ Integer.toString(UID) ;
                preparedStatement = myCon.prepareStatement(insertJsonUpdate);
                preparedStatement.executeUpdate();
                    if (doDelete) removeProductFromShoppingCart(UID, productKey);
                }
                
                
                
                
           }
            
            
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            
        }
        
       
     
        
        
    }
    public static void removeProductFromShoppingCart(int UID,int productKey){
        try {
            
            Connection myCon = MySQLConnection.getConnection();
            JsonArray shoppingCartArray = new JsonArray();
            String findJsonQuery = "SELECT shopping_cart FROM users WHERE id = " + Integer.toString(UID);
            PreparedStatement preparedStatement = myCon.prepareStatement(findJsonQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String jsonString = resultSet.getString("shopping_cart");
                if (jsonString == null) jsonString = "[]";
                shoppingCartArray = JsonParser.parseArray(new StringReader(jsonString));
                didFind =false;
                shoppingCartArray.forEach((profile) -> {
                
                    String profileString = profile.toString();
                    
                    try {
                        DbDoc profileDoc;
                        profileDoc = dbDocFromString(profileString);
                        
                        if (profileDoc.get("product_id").toString().equals(Integer.toString(productKey)))
                        {
                       
                          didFind = true;  
                          foundProfile = profile;
                            
                        }
                    } catch (IOException ex) {
                        
                    }
                });
                
                
                if (didFind) shoppingCartArray.remove(foundProfile);
                String updateShoppingCartUpdate = "UPDATE users SET shopping_cart = '"+shoppingCartArray.toString()+"' WHERE id =" + Integer.toString(UID);
                preparedStatement = myCon.prepareStatement(updateShoppingCartUpdate);
                preparedStatement.executeUpdate();
            }
        
        } catch (Exception e) {
        }
    }
    public static void clearShoppingCart(int UID){
        try {
            Connection myCon = MySQLConnection.getConnection();
            String removeShoppingCartString ="UPDATE users SET shopping_cart ='[]' WHERE id="+Integer.toString(UID);
            PreparedStatement preparedStatement = myCon.prepareStatement(removeShoppingCartString);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static int getShoppingCartProductQuantityByID(int UID,int productID) throws Exception{
       
       int quantity = 0 ; 
       JsonArray shoppingCartArray = new JsonArray();
       Connection myCon = MySQLConnection.getConnection();
       String findQuery = "SELECT shopping_cart FROM users WHERE id = " + Integer.toString(UID) ;
       PreparedStatement preparedStatement = myCon.prepareStatement(findQuery);
       ResultSet resultSet = preparedStatement.executeQuery();
       while (resultSet.next()){
           String jsonArrayString = resultSet.getString("shopping_cart");
           jsonArrayString = (jsonArrayString == null)? "[]": jsonArrayString;
           shoppingCartArray = JsonParser.parseArray(new StringReader(jsonArrayString));
           
           for (int i=0;i<shoppingCartArray.size();i++){
               String jsonString = shoppingCartArray.get(i).toString();
               DbDoc jsonTemp = dbDocFromString(jsonString);
               if (jsonTemp.get("product_id").toString().equals(Integer.toString(productID))){
                   quantity = Integer.parseInt(jsonTemp.get("product_quantity").toString());
               }
           }
           
       }
        
       
       return quantity;
    }
    public static void setShoppingCartProductQuantity(int UID,int productKey,int productQuantity){
        removeProductFromShoppingCart(UID, productKey);
        addProductToShoppingCart(UID, productKey, productQuantity);
    }
    private static DbDoc productProfile(int productKey,int productQuantity) throws IOException{
        
        return JsonParser.parseDoc(new StringReader("{\"product_id\" :"+ productKey + ",\"product_quantity\":"+productQuantity+"}"));
    }
    private static DbDoc dbDocFromString(String string) throws IOException{
        return JsonParser.parseDoc(new StringReader(string));
    } 
    
    
    String getWelcomeMessage(String name){
        return "Welcome " + name + " !";
    }
    
    static void logOut(JFrame frame){
        frame.dispose();
        new LoginPage();
        
    }
   public ArrayList<ProductProfile> getProductProfilesByCategory(String category) throws SQLException{
       ArrayList<ProductProfile> array = new ArrayList<>();
       
       try {
           Connection myCon = MySQLConnection.getConnection();
           String findInCategoryQuery = "SELECT id,name,description,price,quantity FROM products WHERE category = '"+category+"'";
           PreparedStatement preparedStatement = myCon.prepareStatement(findInCategoryQuery);
           ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
              
               int productID = resultSet.getInt("id");
               
               int productQuantity = resultSet.getInt("quantity");
                
               int productPrice = resultSet.getInt("price");
             
               String productName = resultSet.getString("name");
            
               String productDescription = resultSet.getString("description");
         
               ProductProfile tempProfile = new ProductProfile(productID, productQuantity, productName, productDescription,productPrice,userID,this);
             
               array.add(tempProfile);
           }
           
       } catch (Exception e) {
           System.out.println(e);
       }
       clearProductsInview();
       array.forEach((product) -> {
           //System.out.println(product.getProductName()+" : "+product.getProductDescription());
           productView.addPanelToProductsPanel(product);
           
           
       }
       
       
       );
       ArrayList<ProductProfile> panelArray = productView.getProductsInCategoryView();
       System.out.println(panelArray.size());
       
       return array;
       
   }
   void clearProductsInview(){
       productView.clearExploreProducts();
   }
   public ArrayList<ShoppingCartProductProfile> getShoppingCartProductProfiles() throws SQLException, IOException, Exception{
       ArrayList<ShoppingCartProductProfile> profiles = new ArrayList<>();
       String findShoppingCartQuery = "SELECT shopping_cart FROM users WHERE id = "+Integer.toString(userID);
       Connection myCon = MySQLConnection.getConnection();
       PreparedStatement preparedStatement = myCon.prepareStatement(findShoppingCartQuery);
       ResultSet resultSet = preparedStatement.executeQuery();
       while (resultSet.next()){
           String jsonArrayString = resultSet.getString("shopping_cart");
           JsonArray shoppingCartJsonArray = JsonParser.parseArray(new StringReader(jsonArrayString));
           int jsonArraySize = shoppingCartJsonArray.size();
           System.out.println(jsonArraySize);
           for (int i = 0 ; i < jsonArraySize; i ++ ){
               DbDoc tempProfile = dbDocFromString(shoppingCartJsonArray.get(i).toString());
               ShoppingCartProductProfile shoppingCartProductProfile = new ShoppingCartProductProfile(
                       Integer.parseInt(tempProfile.get("product_id").toString()),userID, this);
               profiles.add(shoppingCartProductProfile);
           }
       }
       productView.clearExploreProducts();
       productView.setProductExplorerVisibility(false);
       profiles.forEach(profile ->{
           System.out.println(profile.getProductName());
       productView.addPanelToProductsPanel(profile);
       });
       
       
       return profiles;
       
   }
   public Object getProductPropertyByID(String property,int productID) throws SQLException, Exception{
       Object resultObject = null;
       
       String findObjectQuery = "SELECT "+ property+" FROM products WHERE id = "+ Integer.toString(productID);
       Connection myCon = MySQLConnection.getConnection();
       PreparedStatement preparedStatement = myCon.prepareStatement(findObjectQuery);
       ResultSet resultSet = preparedStatement.executeQuery();
       while (resultSet.next()){
           resultObject = resultSet.getObject(property);
       }
       return resultObject;
   }
   public ArrayList<DbDoc> getShoppingCartByID(int UID) throws Exception{
       ArrayList<DbDoc> shoppingCart = new ArrayList<>();
       ArrayList<ShoppingCartProductProfile> profiles = new ArrayList<>();
       String findShoppingCartQuery = "SELECT shopping_cart FROM users WHERE id = "+Integer.toString(UID);
       Connection myCon = MySQLConnection.getConnection();
       PreparedStatement preparedStatement = myCon.prepareStatement(findShoppingCartQuery);
       ResultSet resultSet = preparedStatement.executeQuery();
       JsonArray shoppingCartJsonArray = new JsonArray();
       while (resultSet.next()){
          String jsonArrayString = resultSet.getString("shopping_cart");
          shoppingCartJsonArray = JsonParser.parseArray(new StringReader(jsonArrayString));
          for (int i = 0 ; i < shoppingCartJsonArray.size();i++){
              String DbDocString = shoppingCartJsonArray.get(i).toString();
              DbDoc tempDbDoc = dbDocFromString(DbDocString);
              shoppingCart.add(tempDbDoc);
          }
       }
       return shoppingCart;
       
   }
}
