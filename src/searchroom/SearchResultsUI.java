/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchroom;

import static searchroom.SearchResultsUI.Username;
import java.sql.*;
import javax.swing.*;
import static searchroom.AboutUs.Username;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Smit
 */
public class SearchResultsUI extends javax.swing.JFrame {
   boolean [] availabilityC;
   String loc_ref="a";
   String fd_ref="a";
   String td_ref="a";
   int rooms_ref=0;
   int guests_ref=0;
   int flag = -2;
   String [][] result;
   String [] data = new String [9];
    /**
     * Creates new form SearchResultsUI1
     * 
     * 
     */
      
    static String Username;
    public SearchResultsUI(String name,String location) {
        Username = name;
        initComponents();
        this.setSize(1920,1080);
        this.setResizable(false);
        //availabilityC = isAvailable;
        loc_ref =location;
        displayHotel(location);        
        
    }
    public SearchResultsUI(String name, boolean isAvailable[],String location) {
        Username = name;
        initComponents();
        this.setSize(1920,1080);
        this.setResizable(false);
        availabilityC = isAvailable;
        loc_ref =location;
        displayHotel(location);        
    }
    
      public SearchResultsUI(String name, boolean isAvailable[],String location,int troom,int tguest,String fd,String td) {
        Username = name;
        initComponents();
        this.setSize(1920,1080);
        this.setResizable(false);
        availabilityC = isAvailable;
        loc_ref =location;
        fd_ref = fd;
        td_ref = td;
        rooms_ref = troom;
        guests_ref = tguest;
        displayHotel(location);        
    }
    
    public void displayHotel(String location){
        
        
        Cursor conn = new Cursor ();
        result = conn.getData(location); 
        displayInfo();
    }
    
    public void displayInfo(){
        DefaultTableModel model = (DefaultTableModel) hotelTable.getModel();
        for (int i = 0; i < 4; i++){
            String row[];
            row = result[i];
            Object t_row[] = {Boolean.valueOf(row[0]),row[1],row[2],row[3],row[4],row[5],row[6],row[7],row[8]};
            model.insertRow(i, t_row);
        }
    }
    
    public SearchResultsUI() {
        initComponents();
    }
    
    private void payementButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payementButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        new ModeOfPayment(Username).setVisible(true);       
    }//GEN-LAST:event_payementButtonMouseClicked

    private void aboutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMenuMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        new AboutUs(Username).setVisible(true);
    }//GEN-LAST:event_aboutMenuMouseClicked

    private void contactMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactMenuMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        new ContactUs(Username).setVisible(true);
    }//GEN-LAST:event_contactMenuMouseClicked

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        resultPanel = new javax.swing.JPanel();
        displayPanel = new javax.swing.JPanel();
        displayLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hotelTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        bckgLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        homeMenu = new javax.swing.JMenu();
        searchMenu = new javax.swing.JMenu();
        profileMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenu();
        contactMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultPanel.setPreferredSize(new java.awt.Dimension(1920, 954));
        resultPanel.setLayout(null);

        displayPanel.setBackground(new java.awt.Color(204, 255, 0));

        displayLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        displayLabel.setText("THESE ARE THE AVAILABLE HOTELS : ");

        hotelTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hotelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "HOTEL NAME", "COST", "RATING", "REVIEWS", "WI-FI", "BREAKFAST", "CAR RENTAL", "TOILETRIES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hotelTable.setAutoscrolls(false);
        hotelTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        hotelTable.setPreferredSize(new java.awt.Dimension(600, 300));
        hotelTable.setRowHeight(50);
        hotelTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        hotelTable.getTableHeader().setReorderingAllowed(false);
        hotelTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hotelTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(hotelTable);

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton1.setText("BOOK ROOM");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton2.setText("ADD TO WAITING LIST");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(displayPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(displayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(displayPanelLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(194, 194, 194)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, displayPanelLayout.createSequentialGroup()
                .addGap(0, 184, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(displayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addGap(85, 85, 85)
                .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        resultPanel.add(displayPanel);
        displayPanel.setBounds(140, 150, 1610, 600);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        backButton.setText("BACK");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        resultPanel.add(backButton);
        backButton.setBounds(120, 780, 320, 100);

        bckgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/searchroom/bckg2.jpg"))); // NOI18N
        resultPanel.add(bckgLabel);
        bckgLabel.setBounds(0, 0, 1920, 950);

        menuBar.setPreferredSize(new java.awt.Dimension(1920, 126));

        homeMenu.setText("HOME");
        homeMenu.setToolTipText("Homepage");
        homeMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        homeMenu.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        homeMenu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        homeMenu.setPreferredSize(new java.awt.Dimension(384, 24));
        homeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMenuMouseClicked(evt);
            }
        });
        menuBar.add(homeMenu);

        searchMenu.setText("SEARCH ");
        searchMenu.setToolTipText("Search for hotels");
        searchMenu.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        searchMenu.setPreferredSize(new java.awt.Dimension(384, 24));
        searchMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMenuMouseClicked(evt);
            }
        });
        menuBar.add(searchMenu);

        profileMenu.setText("MY PROFILE");
        profileMenu.setToolTipText("View your account details");
        profileMenu.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        profileMenu.setPreferredSize(new java.awt.Dimension(384, 24));
        profileMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMenuMouseClicked(evt);
            }
        });
        menuBar.add(profileMenu);

        aboutMenu.setText("ABOUT US");
        aboutMenu.setToolTipText("Get to know more about our sites and other services");
        aboutMenu.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        aboutMenu.setPreferredSize(new java.awt.Dimension(384, 24));
        aboutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMenuMouseClicked(evt);
            }
        });
        menuBar.add(aboutMenu);

        contactMenu.setText("CONTACT US");
        contactMenu.setToolTipText("Contact informtation");
        contactMenu.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        contactMenu.setPreferredSize(new java.awt.Dimension(384, 24));
        contactMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactMenuMouseClicked(evt);
            }
        });
        menuBar.add(contactMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(resultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        int flag = 1,check=1; String [] insert_array = new String[9];int index;
        
        try{
          index = hotelTable.getSelectedRow();
          
        TableModel model = hotelTable.getModel();
            insert_array[0] = loc_ref;
            insert_array[1] = (String) model.getValueAt(index, 1);
            insert_array[2] = Username;
            insert_array[3] = fd_ref;
            insert_array[4] = td_ref;
            insert_array[5] = Integer.toString(rooms_ref);
            insert_array[6] = Integer.toString(guests_ref);
            insert_array[7] = Integer.toString(ThreadLocalRandom.current().nextInt(1000, 2500 + 1));
            //insert_array[8] = Integer.toString((Integer)(model.getValueAt(index, 2))*rooms_ref);
            insert_array[8] = (String)(model.getValueAt(index, 2));
            
            for (int i = 0; i < 4; i++) System.out.println(availabilityC[i]);
            if(availabilityC[index] == false)
            {
                System.out.println("acheck");
                check=0;
                flag =1;
            }
        }
        catch(Exception e){
           flag=0;
            JOptionPane.showMessageDialog(null, "You have to select a Hotel first!");
        }
            
            
           
                if(check==0)
                {
                    flag =1;
                    JOptionPane.showMessageDialog(null, "Hotel Room not available!");
                }
                else
                {
                    if(flag == 1){
                        this.setVisible(false);
                        this.dispose();
                        new ModeOfPayment(Username,insert_array).setVisible(true);
                    }
                  }


    }//GEN-LAST:event_jButton1MouseClicked

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
       
        this.setVisible(false);
        this.dispose();
        new BookFrame().setVisible(true);

    }//GEN-LAST:event_backButtonMouseClicked

    private void searchMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMenuMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        System.out.println("Searchclick");
        this.dispose();
        new BookFrame().setVisible(true);
    }//GEN-LAST:event_searchMenuMouseClicked

    private void profileMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMenuMouseClicked
        // TODO add your handling code here:
        System.out.println("profileclick");
        this.dispose();
        new persDetails(Username).setVisible(true);
    }//GEN-LAST:event_profileMenuMouseClicked

    private void homeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMenuMouseClicked
        // TODO add your handling code here:
         System.out.println("homeclick");
        this.dispose();
        new home(Username).setVisible(true);
    }//GEN-LAST:event_homeMenuMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        /*if(flag >= 0){
            JOptionPane.showMessageDialog(null, "Kindly book the available rooms before being added here!");
        }
        else if(flag == -2){
            JOptionPane.showMessageDialog(null, "You have to select a Hotel first!");
        }*/
        
        int flag=1,switch1=1;String [] insert_array = new String[9];
        try{
        int index = hotelTable.getSelectedRow();        
        TableModel model = hotelTable.getModel();
        
            insert_array[0] = loc_ref;
            insert_array[1] = (String) model.getValueAt(index, 1);
            insert_array[2] = Username;
            insert_array[3] = fd_ref;
            insert_array[4] = td_ref;
            insert_array[5] = Integer.toString(rooms_ref);
            insert_array[6] = Integer.toString(guests_ref);
            insert_array[7] = Integer.toString(ThreadLocalRandom.current().nextInt(1000, 2500 + 1));
            //insert_array[8] = Integer.toString((Integer)(model.getValueAt(index, 2))*rooms_ref);
            insert_array[8] = (String)(model.getValueAt(index, 2));
            
            if(availabilityC[index] == true)
                   {
                       flag =1;
                       switch1 =0;
                       //JOptionPane.showMessageDialog(null, "Kindly book the available rooms before being added here!");
                   }
        }
            catch (Exception e){
                flag =0;
                JOptionPane.showMessageDialog(null, "You have to select a Hotel first!");
                
            }
               // JOptionPane.showMessageDialog(null, "You have to select a Hotel first!");
            
             if(switch1 == 0)
            {
                flag=1;
                JOptionPane.showMessageDialog(null, "This hotel is available for booking.");
                   
                  
            }
             else if(switch1==1)
             {
                 if(flag == 1){
                     
                     Cursor conn = new Cursor();
                    
                    //SearchResultsUI1 makepayment = new SearchResultsUI1 ();
                    //int randomNum = makepayment.addToDB();
                    
                        
                        
                        String query_pref="select Preference from 'waitList' where Location = '"+insert_array[0]+"' and HotelName = '"+insert_array[1]+"'";
                        String preference = conn.getPref(query_pref); 
                        
                        String query = "Insert into 'waitList' Values('"+insert_array[0]+"','"+insert_array[1]+"','"+insert_array[2]+"','"+insert_array[3]+"','"+insert_array[4]+"','"+insert_array[5]+"','"+insert_array[6]+"','"+insert_array[7]+"','"+insert_array[8]+"','"+preference+"')";
                        conn.insert(query);
                        
                        this.setVisible(false);
                        this.dispose();
                        new home(Username).setVisible(true);
                        JOptionPane.showMessageDialog(null, "You have been added to the waitlist with priority number "+ preference);
                    }
                 //JOptionPane.showMessageDialog(null, "You have to select a Hotel first!");
             }
        
           
            
        
       
        
            
                
              
           
                
        
        
            
        
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void hotelTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotelTableMouseClicked
        // TODO add your handling code here:
        int index = hotelTable.getSelectedRow();
        TableModel model = hotelTable.getModel();
        for (int i = 0; i < 4; i++){
            if (i != index) model.setValueAt(false, i,0);
        }
        
    }//GEN-LAST:event_hotelTableMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SearchResultsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchResultsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchResultsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchResultsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchResultsUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel bckgLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu contactMenu;
    private javax.swing.JLabel displayLabel;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JMenu homeMenu;
    public javax.swing.JTable hotelTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu profileMenu;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JMenu searchMenu;
    // End of variables declaration//GEN-END:variables
}
