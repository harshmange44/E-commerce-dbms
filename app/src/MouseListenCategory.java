/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harsh
 */
public class MouseListenCategory implements MouseListener {

    CategoryScreen categScreen;
    int productId;
    String prod_category;
    
    public MouseListenCategory(int pro_id,String prod_categ ,CategoryScreen screen) {
        productId = pro_id;
        prod_category = prod_categ;
    this.categScreen = screen;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(prod_category.equals("phone")){
            try {
                categScreen.setVisible(false);
                phone phoneScreen = new phone(productId,categScreen);
                phoneScreen.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(MouseListenCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(prod_category.equals("laptop")){
            categScreen.setVisible(false);
            laptop laptopScreen = new laptop(productId,categScreen);
            laptopScreen.setVisible(true);  
        }else if(prod_category.equals("headphone")){
            try {
                categScreen.setVisible(false);
                headphone Screen = new headphone(productId,categScreen);  
                Screen.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(MouseListenCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(prod_category.equals("ac")){
            try {
                categScreen.setVisible(false);
                ac Screen = new ac(productId,categScreen);  
                Screen.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(MouseListenCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(prod_category.equals("tv")){
            try {
                categScreen.setVisible(false);
                tv Screen = new tv(productId,categScreen);  
                Screen.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(MouseListenCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
}
