/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bloodmanagement.common.ui;

import com.bloodmanagement.common.logic.DbConnection;
import com.bloodmanagement.common.logic.DbUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author ashu
 */
public class SearchDonorByLocation extends JFrame {

    /*JLabel jLabel1,jLabel2;
    JTextField  txtSearch;
    JSeparator jSeparator1;
    JScrollPane jScrollPane1;
    JTable jTable1;*/
   DbConnection dbconn=new DbConnection();
   Connection con;
  
    public SearchDonorByLocation() {
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(java.awt.Color.pink);
        setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Search Blood Donor (Blood Group)");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(83, 11, 332, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Blood group.png"))); // NOI18N
        jLabel2.setText("Blood Group");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(66, 51, 120, 20);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch);
        txtSearch.setBounds(196, 46, 199, 33);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 97, 770, 10);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "Blood Group"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(92, 113, 452, 337);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/print.png"))); // NOI18N
        jButton1.setText("Print");
        
        getContentPane().add(jButton1);
        jButton1.setBounds(146, 507, 130, 59);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Close.png"))); // NOI18N
        jButton2.setText("Close");
        getContentPane().add(jButton2);
        jButton2.setBounds(365, 507, 130, 59);
        
        label = new JLabel("");
        label.setIcon(new ImageIcon(SearchDonorByLocation.class.getResource("/res/all page background image.png")));
        label.setBounds(0, 0, 584, 461);
        getContentPane().add(label);
    }// </editor-fold>                        

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {                                      
        // TODO add your handling code here:
        
    	String textvalue = txtSearch.getText();
				try
				{ 
				con=dbconn.getConnection();
				String sql = "select * from donor where city like '%"+textvalue+"%' or address like '%"+textvalue+"%'";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				int i =0;
                                
				jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
				jTable1.setModel(DbUtils.resultSetToTableModel(rs));
				//DbUtils.updateTableModelData((DefaultTableModel) table.getModel(), rs);

				/*	DefaultTableModel m = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
			      String name = m.getColumnName(1);
			      table.setModel(m);*/
				}catch(Exception e){
					e.printStackTrace();
				}
			
		
    }                                     
                                         
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtSearch;
    private JLabel label;
    // End of variables declaration                   
}
