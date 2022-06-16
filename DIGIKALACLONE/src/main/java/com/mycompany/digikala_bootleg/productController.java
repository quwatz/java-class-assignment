/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digikala_bootleg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Asus
 */

enum ProductViewerState {
EXPLORER,
SHOPPINGCART
}

public class productController {
    private ProductViewerState state = ProductViewerState.EXPLORER;
    
    private ProductModel productModel;
    private ProductView productView;
    public productController(ProductModel productModel,ProductView productView) throws SQLException{
        this.productModel = productModel;
        this.productView = productView;
        this.productModel.productView = productView;
        productView.addTabsListListener(new TabsListener());
        productView.addCategorycomboBoxListener(new categoryComboBoxListener());
        productView.addPlaceOrderActionListener(new placeOrderListener());
       
        
    }
    
    class TabsListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                String selected = productView.getTabsListSelectedValue();
                switch (selected){
                    case "Explore items":
                        state = ProductViewerState.EXPLORER;
                        productView.toggleToState(state.ordinal());
                        
                        break;
                    case "Log out":
                        productModel.logOut(productView);
                        break;
                    case "Shopping cart":
                        state = ProductViewerState.SHOPPINGCART;
                        productView.toggleToState(state.ordinal());
                        productModel.getShoppingCartProductProfiles();
                        break;
                    default:
                        
                        
                        
                        
                        
                        
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(productController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(productController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    class categoryComboBoxListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                productModel.getProductProfilesByCategory((String)productView.categoryComboBox.getSelectedItem());
            } catch (SQLException ex) {
                
            }
        }
        
    }
    class placeOrderListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new PayForm(productModel.userID, productModel).setVisible(true);
        }
        
    }
}
