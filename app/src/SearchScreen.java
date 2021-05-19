/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author harsh
 */
public class SearchScreen extends javax.swing.JFrame {

    /**
     * Creates new form SearchScreen
     */
    String modelNameLower;
    String modelname;
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    String likeFormat;
    String likeFormatReverse;
    
    ArrayList<String> arrOfStr_n = new ArrayList<String>();
   // int userId = MainScreen.userId;
        ArrayList<SearchedProduct> productList = new ArrayList<SearchedProduct>();
                
    public SearchScreen() throws SQLException {
        
        initComponents();                         
    }

    SearchScreen(String modelName) throws SQLException {
        initComponents();
        modelname = modelName;
        con = MyConnection.connection();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        no_of_prod = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(492, 402));
        jPanel1.setLayout(new org.jfree.ui.tabbedui.VerticalLayout());
        jScrollPane1.setViewportView(jPanel1);

        jPanel2.setBackground(new java.awt.Color(249, 246, 246));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Searched Products", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("No. of products:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(no_of_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(no_of_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.dispose();
            new MainScreen().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SearchScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SearchScreen().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SearchScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel no_of_prod;
    // End of variables declaration//GEN-END:variables

    private void init() throws SQLException {
        
        modelNameLower = modelname.toLowerCase();

//        stmt = con.createStatement();
        
        String[] modelNameToken = modelNameLower.split("\\s");
         likeFormat = "%";
         likeFormatReverse = "%";
        
        for (String token : modelNameToken) {
            likeFormat = likeFormat + token + "%";
        }
        System.out.println("modelNameToken len: "+modelNameToken.length);
        for (int i = modelNameToken.length - 1; i >= 0; i--) {
            likeFormatReverse = likeFormatReverse + modelNameToken[i] + "%";
        }
        
    ini(likeFormat,likeFormatReverse);

    }

    private void ini(String likeForm,String likeFormReverse) {
        //System.out.println("like format: "+likeForm+" "+likeFormReverse);
        try {
            stmt = con.createStatement();
            // String category= jTextField1.getText();
            try {
                logServerOutput(con, () ->
                        stmt.executeUpdate("declare begin search_records('"+likeForm+"','"+likeFormReverse+"'); end;"));         //filteropt is procedure name
            
                for (int i = 0; i < arrOfStr_n.size(); i++) {
                   // System.out.println("len: "+arrOfStr_n.size());
                    //System.out.println("rows: "+arrOfStr_n.get(i);
                    String[] recordTokens = arrOfStr_n.get(i).split(",");
                    productList.add(new SearchedProduct(Integer.parseInt(recordTokens[0]),recordTokens[1],Float.parseFloat(recordTokens[2]),recordTokens[3],recordTokens[4],recordTokens[5],recordTokens[6]));
                jPanel1.add(productList.get(i));
                productList.get(i).addMouseListener(new MouseListen(Integer.parseInt(recordTokens[0]),this));
                }
                no_of_prod.setText(Integer.toString((arrOfStr_n.size()-1)));
                
            } catch (Exception ex) {
                Logger.getLogger(SearchScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    interface WhyUNoCheckedExceptionRunnable {
    void run() throws Exception;
}
    void logServerOutput(
    Connection conn, 
    WhyUNoCheckedExceptionRunnable runnable
) throws Exception {
    try (Statement stmt1 = conn.createStatement()) {
       try {
           stmt1.executeUpdate("begin dbms_output.enable(); end;");
           runnable.run();
 
           try (CallableStatement call = conn.prepareCall(
               "declare "
             + "  num integer := 1000;"
             + "begin "
             + "  dbms_output.get_lines(?, num);"
             + "end;"
           )) {
               call.registerOutParameter(1, Types.ARRAY,
                   "DBMSOUTPUT_LINESARRAY");
               call.execute();
 
               Array array = null;
               try {

                   array = call.getArray(1);
                  int g=(int) Stream.of((Object[]) array.getArray()).count();
                   Consumer<Object> ChangeToJDBC=new Consumer<Object>(){                 
                       @Override
                       public void accept(Object t) {
                           String temp=String.valueOf(t);
                           
                           arrOfStr_n.add(temp);
                           //System.out.println("temp: "+temp);
                            //arrOfStr_n =temp.split("\n");
                           //System.out.println("arr len: "+arrOfStr_n.length);
//                           for(String records:arrOfStr_n){
//                               //                      
//                                 //String[]  arrOfStr_comma=a.split(",");
////                                 for(String b:arrOfStr_comma){
////                                    // System.out.println(b);
////                                 }
//                           }
                                                     
                       }

                       @Override
                       public Consumer<Object> andThen(Consumer<? super Object> after) {
                           return Consumer.super.andThen(after); //To change body of generated methods, choose Tools | Templates.
                       }
               };
                    Stream.of((Object[]) array.getArray(1,g-1))//(i,1)
                         .forEach(ChangeToJDBC);
//                   Stream.of((Object[]) array.getArray())
//                         .forEach(System.out::println);
                   
               }
               finally {
                   if (array != null)
                       System.out.println("");
                       //array.free();
               }
           }
       }
       finally {
           stmt1.executeUpdate("begin dbms_output.disable(); end;");
       }
   }
}
}