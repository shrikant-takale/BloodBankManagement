package com.bloodmanagement.common.ui.bloodbank;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.bloodmanagement.common.logic.DbConnection;
import com.bloodmanagement.common.logic.DbUtils;
import com.bloodmanagement.common.logic.HintTextField;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class BloodBankList extends JFrame implements ActionListener {
	private JTextField txtname;
	private JTextField txtaddr;
	private JTable table;
    JScrollPane jScrollPane1;
    DbConnection dbconn=new DbConnection();
    Connection con=dbconn.getConnection();

    JButton btnGo,btnGo_1;
    private JButton btnPrint;
    private JButton btnClose;
    private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodBankList frame = new BloodBankList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BloodBankList() {
		int i=0;
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent arg0) {
				try
				{
					con=dbconn.getConnection();
					Statement  st=con.createStatement();
					ResultSet rs=st.executeQuery("select id,bloodBankName,address,phone,category from bloodbank");
					
					table.setAutoResizeMode(table.AUTO_RESIZE_ALL_COLUMNS);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Connection error"+e);
				}
			}
		});
		setBounds(100, 100, 601, 400);
		getContentPane().setLayout(null);
		
		JLabel lblBloodBankList = new JLabel("Blood Bank List");
		lblBloodBankList.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBloodBankList.setBounds(250, 11, 174, 14);
		getContentPane().add(lblBloodBankList);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 36, 585, 2);
		getContentPane().add(separator);
		
        jScrollPane1 = new JScrollPane();

		
		//textField = new JTextField( "label goes here");
		txtname = new HintTextField("Search Blood Bank by name");  
		txtname.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				if(txtname.equals("Search Blood Bank by name"))
				{
					txtname.setText("");
					txtname.setForeground(new Color(153,153,153));

				}
			}
			public void focusLost(FocusEvent arg0) {
				if(txtname.equals(""))
				{
					txtname.setText("Search Blood Bank by name");
					txtname.setForeground(new Color(153,153,153));

				}	
			}
		});
		txtname.setForeground(Color.LIGHT_GRAY);
		txtname.setToolTipText("Search Blood Bank by name");
		txtname.setBounds(29, 62, 179, 20);
		getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtaddr = new HintTextField("Search Blood Bank by address");
		txtaddr.setBounds(333, 62, 155, 20);
		getContentPane().add(txtaddr);
		txtaddr.setColumns(10);
		
		btnGo = new JButton("Go");
		btnGo.setBounds(228, 61, 61, 23);
		getContentPane().add(btnGo);
		
		btnGo_1 = new JButton("Go");
		btnGo_1.setBounds(508, 61, 50, 21);
		getContentPane().add(btnGo_1);
		
		table = new JTable();
		table.setBounds(58, 188, 113, -61);
		//getContentPane().add(table);
		
		table.setModel(new DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                 "Blood Group","Units"
	            }
	        ));
	        jScrollPane1.setViewportView(table);

	        getContentPane().add(jScrollPane1);
	        jScrollPane1.setBounds(100, 109, 388, 201);
	        
	        btnPrint = new JButton("Print");
	        btnPrint.setIcon(new ImageIcon(BloodBankList.class.getResource("/res/print.png")));
	        btnPrint.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnPrint.setBounds(39, 327, 89, 23);
	        getContentPane().add(btnPrint);
	        
	        btnClose = new JButton("Close");
	        btnClose.setIcon(new ImageIcon(BloodBankList.class.getResource("/res/Exit application.png")));
	        btnClose.setBounds(440, 327, 105, 23);
	        getContentPane().add(btnClose);
	        
	        label = new JLabel("");
	        label.setIcon(new ImageIcon(BloodBankList.class.getResource("/res/all page background image.png")));
	        label.setBounds(0, 0, 585, 361);
	        getContentPane().add(label);

	        //add actionlistener
	        btnGo.addActionListener(this);
	        btnGo_1.addActionListener(this);
	        btnPrint.addActionListener(this);
	        btnClose.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		String textvalue=txtname.getText().toString();
		String textaddr=txtaddr.getText().toString();
		//System.out.print("in action go");
		if(arg.getSource()==btnGo){
			try
			{
			//System.out.print("in btn go");
			Statement  st=con.createStatement();
			ResultSet rs=st.executeQuery("select id,bloodBankName,address,phone,category from bloodbank where bloodBankName like '%"+textvalue+"%'");
				
			table.setAutoResizeMode(table.AUTO_RESIZE_ALL_COLUMNS);
			table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Connection error"+e);
			}
		}
		if(arg.getSource()==btnGo_1){
			try
			{
				Statement  st=con.createStatement();
				ResultSet rs=st.executeQuery("select id,bloodBankName,address,phone,category from bloodbank where address like '%"+textvalue+"%'");
				
				table.setAutoResizeMode(table.AUTO_RESIZE_ALL_COLUMNS);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Connection error"+e);
			}
		}
		if(arg.getSource()==btnPrint)
    	{
    		try
    		{
    			table.print(JTable.PrintMode.NORMAL);	
    		}catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(null,e);
    		}
    	}
    	if(arg.getSource()==btnClose)
    	{
    		setVisible(false);
    	}
	}
}
