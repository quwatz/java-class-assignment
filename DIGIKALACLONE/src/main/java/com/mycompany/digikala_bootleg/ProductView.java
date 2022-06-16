/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.digikala_bootleg;

import com.mycompany.digikala_bootleg.productController.categoryComboBoxListener;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Asus
 */

public class ProductView extends javax.swing.JFrame {

    /**
     * Creates new form ProductView
     */
    public ProductView() {
        initComponents();
        categoryComboBox.setVisible(false);
        productsPanel.setLayout(new GridLayout(100,2));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        tabsList = new javax.swing.JList<>();
        logo = new javax.swing.JLabel();
        placeOrderJButton = new javax.swing.JButton();
        categoryComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        productsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(239, 76, 95));

        jPanel1.setBackground(new java.awt.Color(154, 13, 30));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        welcomeLabel.setBackground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setFont(new java.awt.Font("Source Code Pro Medium", 2, 14)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setText("WELCOME ARSHIA");

        tabsList.setBackground(new java.awt.Color(154, 13, 30));
        tabsList.setFont(new java.awt.Font("Source Code Pro Medium", 2, 14)); // NOI18N
        tabsList.setForeground(new java.awt.Color(255, 255, 255));
        tabsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Shopping cart", "Explore items", "Log out" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        tabsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabsList.setSelectionBackground(new java.awt.Color(0, 0, 71));
        tabsList.setSelectionForeground(new java.awt.Color(255, 255, 255));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/djkalalogosmall.png"))); // NOI18N

        placeOrderJButton.setBackground(new java.awt.Color(51, 255, 51));
        placeOrderJButton.setForeground(new java.awt.Color(0, 0, 0));
        placeOrderJButton.setText("Place Order");
        placeOrderJButton.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tabsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(welcomeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(placeOrderJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabsList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(placeOrderJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "food", "furniture", "fashion", "medicine", "tool", " " }));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        productsPanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout productsPanelLayout = new javax.swing.GroupLayout(productsPanel);
        productsPanel.setLayout(productsPanelLayout);
        productsPanelLayout.setHorizontalGroup(
            productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );
        productsPanelLayout.setVerticalGroup(
            productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(productsPanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 674, Short.MAX_VALUE)
                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        //System.out.println(categoryComboBox.getSelectedItem());
        
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    public ProductView(JComboBox<String> categoryComboBox, JPanel jPanel1, JPanel jPanel2, JScrollPane jScrollPane1, JScrollPane jScrollPane2, JLabel logo, JPanel productsPanel, JList<String> tabsList, JLabel welcomeLabel) throws HeadlessException {
        this.categoryComboBox = categoryComboBox;
        this.jPanel1 = jPanel1;
        this.jPanel2 = jPanel2;
        this.jScrollPane1 = jScrollPane1;
        this.jScrollPane2 = jScrollPane2;
        this.logo = logo;
        this.productsPanel = productsPanel;
        this.tabsList = tabsList;
        this.welcomeLabel = welcomeLabel;
    }
    public void toggleToState(int state) throws SQLException{
        switch(state){
                case 0 :
                    productsPanel.setVisible(true);
                    setProductExplorerVisibility(true);
                    setProductExplorerVisibility(false);
                    setProductExplorerVisibility(true);
                    break;

                case 1:
                   clearExploreProducts();
                   
                   setProductExplorerVisibility(false);
                   setProductExplorerVisibility(true);
                   setProductExplorerVisibility(false);
       
        }
                 
    
        
    }

    /**
     * @param args the command line arguments
     */
   public void setWelcomeLabelText(String text){
       welcomeLabel.setText(text);
       
   }
   
   public void addTabsListListener (ListSelectionListener listener){
       tabsList.addListSelectionListener(listener);
   }
   public String getTabsListSelectedValue(){
       return tabsList.getSelectedValue();
       
   }
   public void addPlaceOrderActionListener(productController.placeOrderListener listener){
       placeOrderJButton.addActionListener(listener);
   }
   void addCategorycomboBoxListener(categoryComboBoxListener listener){
       categoryComboBox.addActionListener(listener);
   }
   void addPanelToProductsPanel(JPanel panel){
       productsPanel.add(panel);
       productsPanel.setVisible(true);
       panel.setVisible(true);
       //idk why it works->
       
     //  System.out.println("i did add");
       
   }
   ArrayList<ProductProfile> getProductsInCategoryView(){
       var components = productsPanel.getComponents();
       ArrayList<ProductProfile> componentPanels = new ArrayList();
       for (int i = 0;i<components.length;i++){
           componentPanels.add((ProductProfile)components[i]);
       }
       return componentPanels;
   } 
   
   public void setProductExplorerVisibility(boolean value){
       categoryComboBox.setVisible(value);
   }
   
   public void clearExploreProducts(){
       var temp = productsPanel.getComponents();
       for (int i=0;i<temp.length;i++){
           productsPanel.remove(temp[i]);
       }
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logo;
    private javax.swing.JButton placeOrderJButton;
    private javax.swing.JPanel productsPanel;
    private javax.swing.JList<String> tabsList;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}