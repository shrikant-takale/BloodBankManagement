package com.bloodmanagement.common.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.bloodmanagement.common.logic.DbConnection;

public class DeleteDonor extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField txtDonorId;
	private JTextField txtname;
	private JTextField txtAge;
	private JTextField txtMobile;
	private JTextField txtMail;
	JTextArea taAddress;
	private JButton btnSearch,btnReset,btnClose,btnDelete;
	DbConnection dbconn=new DbConnection();
	 Connection con;
	 private JTextField txtCity;
	 private JTextField txtBg;
	 private JTextField txtGen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				
				}
	/**
	 * Create the application.
	 */
	public DeleteDonor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		
		JLabel lblUpdateDetails = new JLabel("Update Details");
		lblUpdateDetails.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		JLabel lblUpdateDetails_1 = new JLabel("Delete Donor");
		lblUpdateDetails_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUpdateDetails_1.setBounds(239, 0, 147, 32);
		panel.add(lblUpdateDetails_1);
		
		JLabel lblDonorId = new JLabel("Donor ID");
		lblDonorId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDonorId.setBounds(10, 54, 56, 14);
		panel.add(lblDonorId);
		
		txtDonorId = new JTextField();
		txtDonorId.setBounds(88, 48, 145, 28);
		panel.add(txtDonorId);
		txtDonorId.setColumns(10);
		
		
		frame.setSize(670,442);    
		frame.getContentPane().add(panel);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setIcon(new ImageIcon(DeleteDonor.class.getResource("/res/search1.png")));
		btnSearch.setBounds(275, 43, 111, 37);
		panel.add(btnSearch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 80, 654, 8);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(32, 36, 542, -2);
		panel.add(separator_1);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFullName.setBounds(10, 108, 63, 14);
		panel.add(lblFullName);
		
		txtname = new JTextField();
		txtname.setBounds(83, 105, 150, 20);
		panel.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(275, 153, 46, 14);
		panel.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setBounds(386, 151, 113, 20);
		panel.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMobileNo.setBounds(10, 153, 63, 14);
		panel.add(lblMobileNo);
		
		txtMobile = new JTextField();
		txtMobile.setBounds(83, 150, 150, 20);
		panel.add(txtMobile);
		txtMobile.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 196, 56, 14);
		panel.add(lblEmail);
		
		txtMail = new JTextField();
		txtMail.setBounds(83, 193, 150, 20);
		panel.add(txtMail);
		txtMail.setColumns(10);
		
		JLabel lblBloodGoup = new JLabel("Blood Group");
		lblBloodGoup.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBloodGoup.setBounds(276, 108, 86, 14);
		panel.add(lblBloodGoup);
		
		JLabel lblAddess = new JLabel("Address");
		lblAddess.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddess.setBounds(10, 244, 56, 14);
		panel.add(lblAddess);
		
		taAddress = new JTextArea();
		taAddress.setBounds(83, 244, 150, 68);
		panel.add(taAddress);
		
		btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(DeleteDonor.class.getResource("/res/delete.png")));
		btnDelete.setBounds(88, 351, 118, 28);
		panel.add(btnDelete);
		
		btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(DeleteDonor.class.getResource("/res/Update details.png")));
		btnReset.setBounds(249, 351, 113, 28);
		panel.add(btnReset);
		
		btnSearch.addActionListener(this);
		btnReset.addActionListener(this);
		btnDelete.addActionListener(this);
  
		
		btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon(DeleteDonor.class.getResource("/res/Exit application.png")));
		btnClose.setBounds(419, 351, 104, 28);
		panel.add(btnClose);
		btnClose.addActionListener(this);

		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(275, 244, 46, 14);
		panel.add(lblGender);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(275, 197, 73, 14);
		panel.add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setBounds(386, 194, 113, 20);
		panel.add(txtCity);
		txtCity.setColumns(10);
		
		txtBg = new JTextField();
		txtBg.setBounds(382, 106, 117, 20);
		panel.add(txtBg);
		txtBg.setColumns(10);
		
		txtGen = new JTextField();
		txtGen.setBounds(387, 242, 112, 20);
		panel.add(txtGen);
		txtGen.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 30, 644, 2);
		panel.add(separator_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DeleteDonor.class.getResource("/res/all page background image.png")));
		label.setBounds(0, 0, 654, 413);
		panel.add(label);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 326, 644, 4);
		panel.add(separator_3);
		
		 frame.setVisible(true);
	     frame.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id;
		id=txtDonorId.getText().toString();

		
		if(e.getSource()==btnSearch)
		{
			try
			{
				if(id.length()!=0)
				{
	         con = DbConnection.getConnection();
	         String sqlStmt="select *from donor where donor_id=?";
	         PreparedStatement pStmt=con.prepareStatement(sqlStmt);
	         pStmt.setString(1, id);

	         ResultSet rs=pStmt.executeQuery();
	         if(rs.next())
	         {
	        	 txtname.setText(rs.getString("name")); 
	        	 txtMail.setText(rs.getString("email"));
	        	 txtMobile.setText(rs.getString("mobile"));
	        	 txtAge.setText(rs.getString("age"));
	        	 taAddress.setText(rs.getString("address"));
	        	 txtBg.setText(rs.getString("blood_group"));
	        	 txtGen.setText(rs.getString("gender"));
	        	 txtCity.setText(rs.getString("city"));
	        	 
	         }else
	         {
		       JOptionPane.showMessageDialog(null,"Donor id not found");
		       empty();
	         }
			}else{
			       JOptionPane.showMessageDialog(null,"Please enter donor id");

			}
				}catch(Exception ex)
			{
				       JOptionPane.showMessageDialog(null,"Connection Error");
				       ex.printStackTrace();
			}
		}
		if(e.getSource()==btnDelete)
		{
			try
			{
				if(id.length()!=0)
				{
				String sql="delete from donor where donor_id='"+id+"'";
				PreparedStatement pStmt=con.prepareStatement(sql);
				int a=pStmt.executeUpdate();
			     JOptionPane.showMessageDialog(null,"Successfully Deleted");
			     empty();
			       //setVisible(false);
			       //new DeleteDonor().setVisible(true);
				}else
				{
				       JOptionPane.showMessageDialog(null,"Please enter donor id");

				}
			}catch(Exception ex)
			{
			       JOptionPane.showMessageDialog(null,"Connection Error");
			}
		}
		if(e.getSource()==btnReset)
		{
			txtname.setText("");
			txtMobile.setText("");
			taAddress.setText("");
			txtAge.setText("");
			txtCity.setText("");
			txtMail.setText("");
			txtBg.setText("");
			txtGen.setText("");
			txtDonorId.setText("");
		}
		if(e.getSource()==btnClose)
		{
			frame.setVisible(false);
			//new UpdateDonor().setVisible(true);
		}
	}
	public void empty()
	{
		txtname.setText("");
		txtMobile.setText("");
		taAddress.setText("");
		txtAge.setText("");
		txtCity.setText("");
		txtMail.setText("");
		txtBg.setText("");
		txtGen.setText("");
		txtDonorId.setText("");
	}
}
