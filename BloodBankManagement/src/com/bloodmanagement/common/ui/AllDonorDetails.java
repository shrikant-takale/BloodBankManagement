package com.bloodmanagement.common.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import com.bloodmanagement.common.logic.DbConnection;
import com.bloodmanagement.common.logic.DbUtils;

public class AllDonorDetails  extends JFrame implements ActionListener {
		DbConnection dbconn=new DbConnection();
	    Connection con;
	   	private JLabel jLabel1;
	    private JScrollPane jScrollPane1;
	    private JSeparator jSeparator1;
	    private JTable jTable1;
	    private JSeparator separator;
	    private JButton btnClose,btnPrint;
	
	    public AllDonorDetails() {
	        initComponents();
	    }
	   
	    private void initComponents() {
	    	
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
	    }
	    
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
	    public void componentShown(ComponentEvent evt)
	    {
	    	try
			{
				con=dbconn.getConnection();
				Statement  st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from donor");
				
				jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
				jTable1.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Connection error"+e);
			}
	    }
}