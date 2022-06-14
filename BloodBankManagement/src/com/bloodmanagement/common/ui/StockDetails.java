/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bloodmanagement.common.ui;

import com.bloodmanagement.common.logic.DbConnection;
import com.bloodmanagement.common.logic.DbUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ashu
 */
public class StockDetails extends JFrame implements ActionListener {

    /*JLabel jLabel1,jLabel2;
    JTextField  txtSearch;
    JSeparator jSeparator1;
    JScrollPane jScrollPane1;
    JTable jTable1;*/
   DbConnection dbconn=new DbConnection();
   Connection con;
  
    public StockDetails() {
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setBackground(java.awt.Color.pink);
        setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Stock (Details)");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(141, 11, 149, 17);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 53, 574, 8);

        jTable1.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"A+", "8"},
        		{"A-", "2"},
        		{"B+", "3"},
        		{"B-", "0"},
        		{"AB+", "0"},
        		{"AB-", "0"},
        		{"O+", "2"},
        		{"O-", "0"},
        	},
        	new String[] {
        		"bloodGroup", "units"
        	}
        ));
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(165);
        jTable1.getColumnModel().getColumn(0).setMinWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(165);
        jTable1.getColumnModel().getColumn(1).setMinWidth(165);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(141, 66, 180, 161);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 269, 685, 2);
        getContentPane().add(separator);
        
        btnPrint = new JButton("Print");
        btnPrint.setIcon(new ImageIcon(StockDetails.class.getResource("/res/print.png")));
        btnPrint.setBounds(49, 299, 102, 23);
        getContentPane().add(btnPrint);
        
        btnClose = new JButton("Close");
        btnClose.setIcon(new ImageIcon(StockDetails.class.getResource("/res/Exit application.png")));
        btnClose.setBounds(319, 299, 111, 23);
        getContentPane().add(btnClose);
        
        btnPrint.addActionListener(this);
        btnClose.addActionListener(this);
		
		/*Display data in a table*/
		try
		{
			con=dbconn.getConnection();
			Statement  st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from stock");
			
			jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_ALL_COLUMNS);
			jTable1.setModel(DbUtils.resultSetToTableModel(rs));
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(StockDetails.class.getResource("/res/all page background image.png")));
			label.setBounds(0, 0, 596, 362);
			getContentPane().add(label);
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Connection error"+e);
		} 

    }// </editor-fold>                        


       
    public void componentShown(ComponentEvent evt)
    {
    	try
		{
			con=dbconn.getConnection();
			Statement  st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from stock");
			
			jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
			jTable1.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Connection error"+e);
		}
    }
    /*
     **
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        
    }
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private JButton btnPrint,btnClose;

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getSource()==btnPrint)
    	{
    		try
    		{
    			jTable1.print(JTable.PrintMode.NORMAL);	
    		}catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(null,e);
    		}
    	}
    	if(evt.getSource()==btnClose)
    	{
    		setVisible(false);
    	}
    	
    	
	}
}
