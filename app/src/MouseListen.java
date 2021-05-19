/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harsh
 */
public class MouseListen implements MouseListener {

    int productId;
    SearchScreen searchScreen;
    Connection con=null;
    Statement stmt1=null;
    Statement stmt2=null;
    Statement stmt3=null;
    Statement stmt4=null;
    Statement stmt5=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    ResultSet rs3=null;
    ResultSet rs4=null;
    ResultSet rs5=null;
    String phoneSql;
    String laptopSql;
    String headphoneSql;
    String acSql;
    String tvSql;
    
    MouseListen(int i, SearchScreen searchScreen) throws SQLException {
     productId = i;
    this.searchScreen = searchScreen;
    con = MyConnection.connection();
    phoneSql = "select count(*) from phone where id='"+productId+"'";
    laptopSql = "select count(*) from laptop where id='"+productId+"'";
    headphoneSql = "select count(*) from headphone where id='"+productId+"'";
    acSql = "select count(*) from ac where id='"+productId+"'";
    tvSql = "select count(*) from tv where id='"+productId+"'";
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        
        try {
            stmt1 = con.createStatement();
            stmt2 = con.createStatement();
            stmt3 = con.createStatement();
            stmt4 = con.createStatement();
            stmt5 = con.createStatement();
            rs1 = stmt1.executeQuery(phoneSql);
            rs2 = stmt2.executeQuery(laptopSql);
            rs3 = stmt3.executeQuery(headphoneSql);
            rs4 = stmt4.executeQuery(acSql);
            rs5 = stmt5.executeQuery(tvSql);
            
            if(rs1.next()){
            if(rs1.getInt(1)==1){
                searchScreen.setVisible(false);
            phone phoneScreen = new phone(productId,searchScreen);
            phoneScreen.setVisible(true);
            }else if(rs2.next()){
                if(rs2.getInt(1)==1){
            searchScreen.setVisible(false);
            laptop laptopScreen = new laptop(productId,searchScreen);
            laptopScreen.setVisible(true);  
                }
            else if(rs3.next())
            {
                if(rs3.getInt(1)==1){
            searchScreen.setVisible(false);
            headphone headphoneScreen = new headphone(productId,searchScreen);
            headphoneScreen.setVisible(true);  
                }
            else if(rs4.next())
            {
                if(rs4.getInt(1)==1)
                {
            searchScreen.setVisible(false);
            ac acScreen = new ac(productId,searchScreen);
            acScreen.setVisible(true);     
                }
            else if(rs5.next()){
            searchScreen.setVisible(false);
            tv tvScreen = new tv(productId,searchScreen);
            tvScreen.setVisible(true);          
            }
            }
            }
            }
            }
            
            System.out.println("Product ID: "+ productId+" clicked");
            
        } catch (SQLException ex) {
            Logger.getLogger(MouseListen.class.getName()).log(Level.SEVERE, null, ex);
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
