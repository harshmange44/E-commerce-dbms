/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author harsh
 */
public class CartProduct extends javax.swing.JPanel {

    /**
     * Creates new form CartProduct
     */
    Connection con=null;
    Statement stmt=null;
    
    int productId;
    String tableName;
    JPanel screen;
    JLabel total_prod;
    JLabel total_price;
    public CartProduct() {
    }

    CartProduct(String id, String table_name, String model_name, String Price, String path,JPanel cartScreen,JLabel total_prod,JLabel total_price) throws SQLException {
        initComponents();
        con = MyConnection.connection();
        screen = cartScreen;
        this.total_prod = total_prod;
        productId= Integer.parseInt(id);
        tableName=table_name;
        name.setText(model_name);
        price.setText(Price);
        this.total_price = total_price;
        image.setIcon(new ImageIcon("C:/Users/harsh"+path));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        image = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        name.setText("title");

        price.setText("price");

        jButton1.setText("Remove");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(price)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(59, 59, 59))
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
//        System.out.println(productId+" "+tableName+" pressed");
           // stmt=con.createStatement();

           String Sql = "call remove_from_cart('"+productId+"','"+MainScreen.userId+"')";
            CallableStatement callableStatement = con.prepareCall(Sql);
            callableStatement.executeQuery();
            //String sql="DELETE FROM cart WHERE product_id = '"+productId+"' and user_id = '"+MainScreen.userId+"' ";
            //stmt.executeUpdate(sql);
            total_prod.setText(Integer.toString(Integer.parseInt(total_prod.getText())-1));
            total_price.setText(Integer.toString(Integer.parseInt(total_price.getText())-Integer.parseInt(price.getText())));
            screen.remove(this);
            screen.revalidate();
            screen.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(CartProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel price;
    // End of variables declaration//GEN-END:variables
}