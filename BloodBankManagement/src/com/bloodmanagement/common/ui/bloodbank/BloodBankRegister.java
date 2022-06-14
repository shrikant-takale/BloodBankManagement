package com.bloodmanagement.common.ui.bloodbank;

import java.awt.EventQueue;

import javax.swing.*;

import com.bloodmanagement.common.logic.DbConnection;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BloodBankRegister extends JFrame implements ActionListener{
	private JTextField txtname;
	private JTextField txtcity;
	private JTextField txtPhone;
	private JTextField txtEmail;
	JButton btnAdd,btnCancel;
	JTextArea taAddress;
	DbConnection dbconn=new DbConnection();
	Connection conn=dbconn.getConnection();
	JComboBox cb_category;
	//Regular expression to accept valid email id
    String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    //Creating a pattern object
    Pattern pattern = Pattern.compile(regex);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodBankRegister frame = new BloodBankRegister();
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
	public BloodBankRegister() {
		setBounds(100, 100, 571, 511);
		getContentPane().setLayout(null);
		
		JLabel lblRegistrationOfBlood = new JLabel("Registration of Blood Bank");
		lblRegistrationOfBlood.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistrationOfBlood.setBounds(169, 11, 231, 20);
		getContentPane().add(lblRegistrationOfBlood);
		
		JLabel lblName = new JLabel("Blood Bank Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(10, 69, 120, 14);
		getContentPane().add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(154, 67, 240, 20);
		getContentPane().add(txtname);
		txtname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(10, 113, 81, 14);
		getContentPane().add(lblAddress);
		
		taAddress = new JTextArea();
		taAddress.setBounds(154, 109, 240, 94);
		getContentPane().add(taAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(10, 241, 46, 14);
		getContentPane().add(lblCity);
		
		txtcity = new JTextField();
		txtcity.setBounds(154, 238, 240, 20);
		getContentPane().add(txtcity);
		txtcity.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhoneNumber.setBounds(10, 294, 97, 14);
		getContentPane().add(lblPhoneNumber);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(154, 291, 240, 20);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		txtPhone.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent arg) {
				char c=arg.getKeyChar();
				if(!(Character.isDigit(c)))
				{
					arg.consume();
					//System.out.print("key");
				}
			}
		});
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategory.setBounds(10, 373, 68, 14);
		getContentPane().add(lblCategory);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setIcon(new ImageIcon(BloodBankRegister.class.getResource("/res/Add new.png")));
		btnAdd.setBounds(109, 427, 97, 23);
		getContentPane().add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(BloodBankRegister.class.getResource("/res/Exit application.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(357, 427, 105, 23);
		getContentPane().add(btnCancel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 414, 555, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 43, 555, 2);
		getContentPane().add(separator_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 334, 68, 14);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(154, 332, 240, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		cb_category = new JComboBox();
		cb_category.setModel(new DefaultComboBoxModel(new String[] {"Select", "Govt.", "Private"}));
		cb_category.setBounds(152, 371, 81, 20);
		getContentPane().add(cb_category);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BloodBankRegister.class.getResource("/res/all page background image.png")));
		label.setBounds(0, 0, 555, 472);
		getContentPane().add(label);
		
		//add listener
		btnAdd.addActionListener(this);
		btnCancel.addActionListener(this);
		

	}

	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		if(arg.getSource()==btnAdd)
		{
			String id,name,mobile,address,category,city,email;
			name=txtname.getText().toString();
			mobile=txtPhone.getText().toString();
			address=taAddress.getText().toString();
			city=txtcity.getText().toString();
			email=txtEmail.getText().toString();
			category = (String)cb_category.getSelectedItem();
		    Matcher matcher = pattern.matcher(email);
	            int newUserPk = 0;
				boolean ranOk = false;
				if(name.length()!=0 && mobile.length()==10 && address.length()!=0 && email.length()!=0 && 
						cb_category.getSelectedIndex()!=0 && matcher.matches())
				{
				try {
					conn=DbConnection.getConnection();
					if(conn!=null)
					{
						newUserPk=getNewPk(conn);
						String sqlStmt="insert into bloodbank(id,bloodBankName,address,city,phone,email,category) values(?,?,?,?,?,?,?)";
						PreparedStatement pStmt = conn.prepareStatement(sqlStmt);
						pStmt.setInt(1,newUserPk);
						pStmt.setString(2,name);
						pStmt.setString(3,address );
						pStmt.setString(4,city );
						pStmt.setString(5,mobile );
						pStmt.setString(6,email );
						pStmt.setString(7, category);
					 	pStmt.executeUpdate();
					     JOptionPane.showMessageDialog(null,"Successfully Saved");
					       empty();
			}else
					{
			       JOptionPane.showMessageDialog(null,"Connection error");
					}
					}catch(Exception ex){
					ex.printStackTrace();
					}
				}
				else{
				       JOptionPane.showMessageDialog(null,"All field are necessary");
				}
		}
		if(arg.getSource()==btnCancel)
		{
			setVisible(false);
		}
	}
	 public void empty()
	 {
		 txtname.setText("");
		 txtPhone.setText("");
		 taAddress.setText("");
		txtcity.setText("");
		txtEmail.setText("");
			
	 }

		private static int getNewPk(Connection conn) throws Exception {
	        String sqlStmt = "SELECT MAX(id) FROM bloodbank";
	        int returnVal = 1; // default to 1 if not found

	        try {
	        	PreparedStatement pStmt = conn.prepareStatement(sqlStmt);
	            ResultSet rs = pStmt.executeQuery();
	            if (rs.next()) {
	            returnVal = rs.getInt(1) + 1;
	        }}
	        catch (Exception e) {
	           // throw e;
	            System.out.println(e);
	        }
	        System.out.print(""
	        		+ ""+returnVal);

			return returnVal;
		}
}
