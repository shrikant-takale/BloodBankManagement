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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

/**
 *
 * @author ashu
 */
public class AllDonor extends JFrame implements ActionListener{

    /*JLabel jLabel1,jLabel2;
    JTextField  txtSearch;
    JSeparator jSeparator1;
    JScrollPane jScrollPane1;
    JTable jTable1;*/
   DbConnection dbconn=new DbConnection();
   Connection con;
	private JFrame frame;

  
    public AllDonor() {
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jScrollPane1 =new JScrollPane();
        jTable1 = new JTable();

       // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.pink);
        setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("All Donor Details");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(249, 11, 202, 17);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(-13, 50, 687, 10);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "Blood Group"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(92, 113, 452, 163);
        
        try
		{ 
		con=dbconn.getConnection();
		String sql = "select * from donor";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i =0;
                        
		jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
		jTable1.setModel(DbUtils.resultSetToTableModel(rs));
		
		separator = new JSeparator();
		separator.setBounds(0, 345, 684, 2);
		getContentPane().add(separator);
		
		 btnPrint = new JButton("Print");
		btnPrint.setIcon(new ImageIcon(AllDonor.class.getResource("/res/print.png")));
		btnPrint.setBounds(65, 380, 89, 29);
		getContentPane().add(btnPrint);
		btnPrint.addActionListener(this);
		
		btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon(AllDonor.class.getResource("/res/Exit application.png")));
		btnClose.setBounds(379, 380, 119, 23);
		getContentPane().add(btnClose);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AllDonor.class.getResource("/res/all page background image.png")));
		label.setBounds(0, 0, 600, 462);
		getContentPane().add(label);
		btnClose.addActionListener(this);
		

		//DbUtils.updateTableModelData((DefaultTableModel) table.getModel(), rs);

		/*	DefaultTableModel m = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
	      String name = m.getColumnName(1);
	      table.setModel(m);*/
		}catch(Exception e){
			e.printStackTrace();
		}

        
    }// </editor-fold>                        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
           }
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private JSeparator separator;
    private JButton btnClose,btnPrint;

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnClose)
		{
    		setVisible(false);
		}
		if(e.getSource()==btnPrint)
		{
			try
			{
			jTable1.print(JTable.PrintMode.NORMAL);
			}catch(Exception ex)
			{
			       JOptionPane.showMessageDialog(null,"Printer Error");

			}	
		}
	}
}
