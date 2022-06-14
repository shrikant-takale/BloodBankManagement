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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.bloodmanagement.common.logic.DbConnection;

import java.util.regex.Matcher;

public class UpdateDonor extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField txtDonorId;
	private JTextField txtname;
	private JTextField txtAge;
	private JTextField txtMobile;
	private JTextField txtMail;
	JTextArea taAddress;
	private JButton btnSearch,btnReset,btnClose,btnUpdate;
	DbConnection dbconn=new DbConnection();
	Connection con;
	JComboBox cb_bg,cb_gen;
	private JTextField txtCity;
	//Regular expression to accept valid email id
    String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    //Creating a pattern object
    Pattern pattern = Pattern.compile(regex);
   /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				try {
					java.awt.EventQueue.invokeLater(new Runnable() {
			            public void run() {
			                new UpdateDonor().setVisible(true);
			            }
			        });
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	/**
	 * Create the application.
	 */
	public UpdateDonor() {
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
		
		JLabel lblUpdateDetails_1 = new JLabel("Update Donor Details");
		lblUpdateDetails_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUpdateDetails_1.setBounds(153, 11, 191, 14);
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
		btnSearch.setIcon(new ImageIcon(UpdateDonor.class.getResource("/res/search1.png")));
		btnSearch.setBounds(275, 43, 111, 37);
		panel.add(btnSearch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 86, 650, 2);
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
		txtAge.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg) {
				char c=arg.getKeyChar();
				if(!(Character.isDigit(c)))
				{
					arg.consume();
					//System.out.print("key");
				}
			}
		});
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMobileNo.setBounds(10, 153, 63, 14);
		panel.add(lblMobileNo);
		
		txtMobile = new JTextField();
		txtMobile.setBounds(83, 150, 150, 20);
		panel.add(txtMobile);
		txtMobile.setColumns(10);
		
		txtMobile.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg) {
				char c=arg.getKeyChar();
				if(!(Character.isDigit(c)))
				{
					arg.consume();
					//System.out.print("key");
				}
			}
		});
		
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
		taAddress.setBounds(83, 224, 150, 68);
		panel.add(taAddress);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(UpdateDonor.class.getResource("/res/save.png")));
		btnUpdate.setBounds(90, 318, 118, 28);
		panel.add(btnUpdate);
		
		btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(UpdateDonor.class.getResource("/res/Update details.png")));
		btnReset.setBounds(240, 318, 113, 28);
		panel.add(btnReset);
		
		btnSearch.addActionListener(this);
		btnReset.addActionListener(this);
		btnUpdate.addActionListener(this);
  
		btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon(UpdateDonor.class.getResource("/res/Exit application.png")));
		btnClose.setBounds(386, 318, 104, 28);
		panel.add(btnClose);
		btnClose.addActionListener(this);

		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(275, 244, 46, 14);
		panel.add(lblGender);
		
		cb_bg = new JComboBox();
		cb_bg.setModel(new DefaultComboBoxModel(new String[] {"Select","A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		cb_bg.setBounds(386, 106, 73, 20);
		panel.add(cb_bg);
		
		cb_gen = new JComboBox();
		cb_gen.setModel(new DefaultComboBoxModel(new String[] {"Select","Male", "Female"}));
		cb_gen.setBounds(386, 242, 86, 20);
		panel.add(cb_gen);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(275, 197, 73, 14);
		panel.add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setBounds(386, 194, 113, 20);
		panel.add(txtCity);
		txtCity.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UpdateDonor.class.getResource("/res/all page background image.png")));
		lblNewLabel.setBounds(0, 0, 664, 392);
		panel.add(lblNewLabel);
		
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
	        	 cb_bg.setSelectedItem(rs.getString("blood_group"));
	        	 cb_gen.setSelectedItem(rs.getString("gender"));
	        	 txtCity.setText(rs.getString("city"));
	        	 
	        	 
	         }else{
			       JOptionPane.showMessageDialog(null,"Donor not found");

	         }
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		if(e.getSource()==btnUpdate)
		{
			String name,mobile,bloodgroup = null,gender = null,address,age,city,email;
			name=txtname.getText().toString();
			mobile=txtMobile.getText().toString();
			address=taAddress.getText().toString();
			age=txtAge.getText().toString();
			city=txtCity.getText().toString();
			email=txtMail.getText().toString();
			
			gender = (String) cb_gen.getSelectedItem();
			bloodgroup=(String) cb_bg.getSelectedItem();
	
			 //Creating a Matcher object
		    Matcher matcher = pattern.matcher(email);
		    /*if(matcher.matches()) {
			 JOptionPane.showMessageDialog(null,"Invalid Email");
		    }*/
			if(name.length()!=0 && mobile.length()!=0 && address.length()!=0 && age.length()!=0 && email.length()!=0&&
					city.length()!=0 && cb_gen.getSelectedIndex()!=0 && cb_bg.getSelectedIndex()!=0  && matcher.matches() )
			{
			try
			{
				String sql="update donor set name=? ,mobile= ?,address=?,city=?, blood_group=? ,email=?,gender=?,age=? where donor_id=?";
				
		         PreparedStatement pStmt=con.prepareStatement(sql);
		         	pStmt.setString(9, id);
		         	pStmt.setString(1,name);
					pStmt.setString(2,mobile );
					pStmt.setString(3,address );
					pStmt.setString(4,city );
					pStmt.setString(5,bloodgroup );
					pStmt.setString(6,email );
					pStmt.setString(7, gender);
					pStmt.setString(8, age);

			       int a=pStmt.executeUpdate();
			       JOptionPane.showMessageDialog(null,"Successfully Updated");
			       empty();

			}catch(Exception ex)
			{
			       JOptionPane.showMessageDialog(null,"Connection Error");
			}}
			else
			{
			       JOptionPane.showMessageDialog(null,"All Field are neccessary");
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
			cb_gen.setSelectedIndex(0);;
			cb_bg.setSelectedIndex(0);
			txtDonorId.setText("");
		}
		if(e.getSource()==btnClose)
		{
			frame.setVisible(false);
			//new UpdateDonor().setVisible(false);
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
		cb_gen.setSelectedIndex(0);;
		cb_bg.setSelectedIndex(0);
		txtDonorId.setText("");
	}
}
