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
import java.awt.event.ComponentAdapter;

/**
 *
 * @author ashu
 */
public class StockDec extends JFrame implements ActionListener  {

    /*JLabel jLabel1,jLabel2;
    JTextField  txtSearch;
    JSeparator jSeparator1;
    JScrollPane jScrollPane1;
    JTable jTable1;*/
   DbConnection dbconn=new DbConnection();
   Connection con;
   JComboBox comboBox;
  
    public StockDec() {
    	addComponentListener(new ComponentAdapter() {
    		public void componentShown(ComponentEvent arg0) {
    			try
    			{
    				con=dbconn.getConnection();
    				Statement  st=con.createStatement();
    				ResultSet rs=st.executeQuery("select * from stock");
    				jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_ALL_COLUMNS);
    				jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    				
    			}catch(Exception e)
    			{
    				JOptionPane.showMessageDialog(null,"Connection error"+e);
    			} 
    		}
    	});
    	//setResizable(false);
    	//setUndecorated(true);
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txtUnits = new JTextField();
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setBackground(java.awt.Color.pink);
        setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Stock (Decrease)");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 11, 231, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Blood group.png"))); // NOI18N
        jLabel2.setText("Blood Group");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(66, 51, 120, 20);

        
        getContentPane().add(txtUnits);
        txtUnits.setBounds(360, 51, 67, 23);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 97, 770, 10);

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                 "Blood Group","Units"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 109, 150, 176);
        
        lblUnits = new JLabel("Units");
        lblUnits.setBounds(315, 55, 46, 14);
        getContentPane().add(lblUnits);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setIcon(new ImageIcon(StockDec.class.getResource("/res/save.png")));
        btnUpdate.setBounds(500, 51, 102, 23);
        getContentPane().add(btnUpdate);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
        comboBox.setBounds(193, 52, 53, 20);
        getContentPane().add(comboBox);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 314, 685, 2);
        getContentPane().add(separator);
        
        btnPrint = new JButton("Print");
        btnPrint.setIcon(new ImageIcon(StockDec.class.getResource("/res/print.png")));
        btnPrint.setBounds(174, 341, 102, 23);
        getContentPane().add(btnPrint);
        
        btnClose = new JButton("Close");
        btnClose.setIcon(new ImageIcon(StockDec.class.getResource("/res/Exit application.png")));
        btnClose.setBounds(414, 341, 111, 23);
        getContentPane().add(btnClose);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(StockDec.class.getResource("/res/all page background image.png")));
        label.setBounds(0, 0, 664, 384);
        getContentPane().add(label);
        
        btnUpdate.addActionListener(this);
        btnPrint.addActionListener(this);
        btnClose.addActionListener(this);
		
		/*Display data in a table*/
		/*try
		{
			con=dbconn.getConnection();
			Statement  st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from stock");
			
			jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
			jTable1.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Connection error"+e);
		} */

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtUnits;
    private JLabel lblUnits;
    private JButton btnUpdate,btnPrint,btnClose;

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
    	if(evt.getSource()==btnUpdate)
    	{
    		String bloodGroup=(String) comboBox.getSelectedItem();
    		System.out.print("bloodGroup");
    		String Units=txtUnits.getText();
    		System.out.println("Units");
    		int unit =Integer.parseInt(Units);
    		try
    		{
    			con=dbconn.getConnection();
    			Statement  st=con.createStatement();
    			//ResultSet rs=st.executeQuery("select stock_blood as BloodGroup,units from stock");
    			st.executeUpdate("update stock set units=units-'"+unit+"'where bloodGroup ='"+bloodGroup+"'");
    			JOptionPane.showMessageDialog(null,"SuccessFully Updated");
    			setVisible(false);
    			new StockDec().setVisible(true);
    		}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Connection error");

    	}}
	}


}
