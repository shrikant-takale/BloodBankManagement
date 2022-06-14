package com.bloodmanagement.common.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

import com.bloodmanagement.common.logic.DbConnection;

public class DeleteUser extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtmobile;
	private JTextField txtemail;
	JButton btnDelete,btnClose,btnSearch,btnUpdate;
	private JTextField txtuser;
	private JTextField txtSearch;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser frame = new DeleteUser();
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
	public DeleteUser() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage User");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(158, 11, 139, 20);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 93, 480, 2);
		contentPane.add(separator);
		
		JLabel lblName = new JLabel("Full Name ");
		lblName.setBounds(10, 106, 63, 14);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(132, 103, 207, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setBounds(10, 185, 63, 14);
		contentPane.add(lblMobileNo);
		
		txtmobile = new JTextField();
		txtmobile.setBounds(132, 182, 207, 20);
		contentPane.add(txtmobile);
		txtmobile.setColumns(10);
		
		JLabel lblUserRole = new JLabel("User Role");
		lblUserRole.setBounds(10, 262, 63, 14);
		contentPane.add(lblUserRole);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
		comboBox.setBounds(132, 256, 63, 20);
		contentPane.add(comboBox);
		
		btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(DeleteUser.class.getResource("/res/delete donor.png")));
		btnDelete.setBounds(44, 345, 130, 45);
		contentPane.add(btnDelete);
		
		btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon(DeleteUser.class.getResource("/res/Exit application.png")));
		btnClose.setBounds(334, 345, 103, 45);
		contentPane.add(btnClose);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 226, 63, 14);
		contentPane.add(lblEmail);
		
		txtemail = new JTextField();
		txtemail.setBounds(132, 220, 207, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-12, 324, 512, 10);
		contentPane.add(separator_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 146, 63, 14);
		contentPane.add(lblUsername);
		
		txtuser = new JTextField();
		txtuser.setBounds(132, 143, 207, 20);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblIdusername = new JLabel("Username");
		lblIdusername.setBounds(44, 59, 79, 14);
		contentPane.add(lblIdusername);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(132, 56, 118, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(DeleteUser.class.getResource("/res/search1.png")));
		btnSearch.setBounds(275, 46, 118, 35);
		contentPane.add(btnSearch);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(DeleteUser.class.getResource("/res/save.png")));
		btnUpdate.setBounds(195, 345, 102, 45);
		contentPane.add(btnUpdate);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DeleteUser.class.getResource("/res/all page background image.png")));
		label.setBounds(-2, 0, 510, 400);
		contentPane.add(label);
		
		//add listener
		btnDelete.addActionListener(this);
		btnClose.addActionListener(this);
		btnSearch.addActionListener(this);
		btnUpdate.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		String id,name,mobile,username,password,email,role;
		name=txtSearch.getText().toString();
		
		if(arg.getSource()==btnDelete)
		{
			try {
				Connection conn = DbConnection.getConnection();
				if(conn!=null)
				{
					int newUserPk = getNewUserPk(conn);
					System.out.println(newUserPk);
					//String sql="delete from donor where donor_id='"+id+"'";
					String sqlStmt="delete from users where username like '%"+name+"%'";
					PreparedStatement pStmt = conn.prepareStatement(sqlStmt);
					
					 int a = JOptionPane.showConfirmDialog(null,"Do you Really Want to Delete user","Select", JOptionPane.YES_NO_OPTION);
			         if(a==0)
			         {
						 	pStmt.executeUpdate();
						    JOptionPane.showMessageDialog(null,"Deleted successfully");
						    empty();
			         }
	
				}else
				{
		       JOptionPane.showMessageDialog(null,"connection error");
				}
				}catch(Exception ex){
				ex.printStackTrace();
				}
		}

		if(arg.getSource()==btnClose)
		{
			setVisible(false);
		}
		if(arg.getSource()==btnSearch)
		{
			try {
				Connection conn = DbConnection.getConnection();
				if(conn!=null)
				{
					String sqlStmt="select * from users where username like '%"+name+"%'";
					PreparedStatement pStmt = conn.prepareStatement(sqlStmt);
				 	ResultSet rs=pStmt.executeQuery();
				 	while(rs.next())
				 	{
				 		txtname.setText(rs.getString("fullname"));
				 		txtuser.setText(rs.getString("username"));
				 		txtmobile.setText(rs.getString("mobile"));
				 		txtemail.setText(rs.getString("email"));
				 		
				 		}
		}else
				{
		       JOptionPane.showMessageDialog(null,"connection error");
				}
				}catch(Exception ex){
				ex.printStackTrace();
				}
		}

		if(arg.getSource()==btnUpdate)
		{

		//String fullname,username1,mobile1,role,email1;
			name=txtname.getText().toString();
			mobile=txtmobile.getText().toString();
			username=txtuser.getText().toString();
			role=comboBox.getSelectedItem().toString();
			email=txtemail.getText().toString();
		try
		{
			Connection con = DbConnection.getConnection();
			//st.executeUpdate("update users set username='"+username+"','++where bloodGroup ='"+bloodGroup+"'");
			String sql="update users set username=? ,user_role= ?,fullname=?,email=?, mobile=? where username=?";
	         	PreparedStatement pStmt=con.prepareStatement(sql);
	         	pStmt.setString(1,username);
				pStmt.setString(2,role );
				pStmt.setString(3,name );
				pStmt.setString(4,email );
				pStmt.setString(5,mobile );
				pStmt.setString(6,username );

				pStmt.executeUpdate();
				JOptionPane.showMessageDialog(null,"SuccessFully Updated");
			empty();
			
		}
	catch(Exception ex)
	{
		ex.printStackTrace();
		JOptionPane.showMessageDialog(null,"Connection error");

	}
		
	}
	}
	public void empty()
	 {
			txtname.setText("");
			txtmobile.setText("");
			txtuser.setText("");
			txtemail.setText("");
			comboBox.setSelectedIndex(0);;
	 }
	private static int getNewUserPk(Connection conn) {
		// TODO Auto-generated method stub
		 String sqlStmt = "SELECT MAX(user_pk) FROM users";
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
			return returnVal;
		}
	}

