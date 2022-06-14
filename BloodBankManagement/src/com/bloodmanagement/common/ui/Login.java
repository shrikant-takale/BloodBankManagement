package com.bloodmanagement.common.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

import com.bloodmanagement.common.logic.DbConnection;

import java.sql.*;
import java.awt.Font;
import java.awt.Toolkit;


public class Login extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField username;
	private JLabel lblUsername,lblPassword;
	private JPasswordField passwordField;
	
	
	JPanel panel;
	JLabel user_label, password_label, message;
	JTextField txtUser;
	JPasswordField txtPassword;
	JButton submit, cancel;


	//private Image img_username=new ImageIcon(Login.class.getResource("res/person-icon.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

	DbConnection dbconn=new DbConnection();
	private JButton btnClose;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(false);

		frame.setBounds(0, 0, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 // User Label
        user_label = new JLabel();
        user_label.setFont(new Font("Calibri", Font.BOLD, 14));
        user_label.setText("Username ");
        //user_label.setIcon(new ImageIcon("/BloodBankManagement/res/bloodHeader.png"));
       
        txtUser = new JTextField();
        txtUser.setBackground(new Color(255, 204, 204));

        // Password

        password_label = new JLabel();
        password_label.setFont(new Font("Calibri", Font.BOLD, 14));
        password_label.setText("Password ");
        txtPassword = new JPasswordField();
        txtPassword.setBackground(new Color(255, 204, 204));

        // Submit
        submit = new JButton("Login");
        submit.setFont(new Font("Tahoma", Font.BOLD, 14));

        try
        {
    	Image img_login=new ImageIcon(this.getClass().getResource("/res/login.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        submit.setIcon(new ImageIcon(img_login));
        }catch(Exception ex)
        {
            System.out.println("image path not found");
        }
        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setForeground(new Color(139, 0, 139));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));


        user_label.setBounds(696, 295, 100, 20);
        password_label.setBounds(696,355,  100,  20);
		txtUser.setBounds(806, 295, 250, 20);
		txtPassword.setBounds(806, 355, 250, 20);
		submit.setBounds(806, 420, 109, 36);
        
		//user_label.setIcon(new ImageIcon(img_username));

        panel.add(user_label);

        panel.add(txtUser);
        panel.add(password_label);
        panel.add(txtPassword);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
     
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adding the listeners to components..
        submit.addActionListener(this);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        btnClose = new JButton("Close");
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClose.setBounds(956, 420, 109, 36);
        btnClose.addActionListener(this);

        try
        {
    	Image img_login=new ImageIcon(this.getClass().getResource("/res/Close.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    	btnClose.setIcon(new ImageIcon(img_login));
        }catch(Exception ex)
        {
            System.out.println("image path not found");
        }
        panel.add(btnClose);
        
        lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        lblError.setBackground(Color.WHITE);
        lblError.setBounds(900, 395, 190, 14);
        panel.add(lblError);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(Login.class.getResource("/res/login background final.PNG")));
        label.setBounds(0, 0, 1388, 739);
        panel.add(label);
        frame.setTitle("Login Here !");
		frame.setSize(1366,768);    
        frame.setVisible(true);
        frame.setResizable(false);


		}

	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		if(arg.getSource()==submit)
		{
			String userName = txtUser.getText().toString();
	        String password = txtPassword.getText().toString();
	        if(userName.length()==0)
	        {
	        	lblError.setText("Please enter username");
	        }
	        else if(password.length()==0)
	        {
	        	lblError.setText("Please enter Password");
	        }
	        else
	        {
	        try
	        {
	        	lblError.setText("");
	        	Connection con = DbConnection.getConnection();
	        	String sql="Select * from users where username='"+userName+"' and Password='"+password+"'";
				Statement stmt=con.createStatement();
	        	ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					//lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null, "Login Successfully.....");
					//Login.this.dispose();
					frame.setVisible(false);
					MainPage frm =new MainPage();
				//	frm.setVisible(true);
				}
	        	lblError.setText("Incorrect Username/password");
					
	        }catch(Exception e)
	        {
				JOptionPane.showMessageDialog(null, "Connection Error.....");
	        	e.printStackTrace();
	        }}
	        }
	     if(arg.getSource()==btnClose)
	     {
	         int a = JOptionPane.showConfirmDialog(null,"Do you Really Want to Close this application","Select", JOptionPane.YES_NO_OPTION);
	         if(a==0)
	         {
	        	 System.exit(0);
	         }
	     }

	}	
}
