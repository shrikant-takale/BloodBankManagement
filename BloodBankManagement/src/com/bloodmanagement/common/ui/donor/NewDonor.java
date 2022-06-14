package com.bloodmanagement.common.ui.donor;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bloodmanagement.common.logic.DbConnection;
import com.bloodmanagement.common.ui.AllDonor;

import javax.swing.ImageIcon;
import javax.swing.JSeparator;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewDonor extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField txtid;
	private JTextField txt_fullname;
	private JTextField txtmobile;
	private JButton btnSave,btnReset,btnClose;
	private JTextField txtAge;
	JComboBox cb_bg,cb_gender ;
	JTextArea txtAddress;
	
	DbConnection dbconn=new DbConnection();
	Connection conn=dbconn.getConnection();
	 // array of string containing cities
    String bg[] = new String[] {"Select","A+", "A-", "B+", "B-","AB+","AB-","O+","O-" };
    String gen[]=new String[] {"Select","Male","Female"};
    private JTextField txtEmail;
    private JTextField txtCity;

  //Regular expression to accept valid email id
    String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    //Creating a pattern object
    Pattern pattern = Pattern.compile(regex);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new NewDonor().setVisible(true);
	            }
	        });		
			}
	/**
	 * Create the application.
	 */
	public NewDonor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(700, 500);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		//frame.getContentPane().add(panel, BorderLayout.NORTH);
		JLabel lblDonorId = new JLabel("New Donor ID");
		panel.add(lblDonorId);
       
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewDonorId = new JLabel("New Donor ID");
		lblNewDonorId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewDonorId.setBounds(0, 57, 94, 14);
		panel.add(lblNewDonorId);
		
		txtid = new JTextField();
		txtid.setForeground(Color.RED);
		txtid.setBounds(104, 55, 36, 20);
		try {
			txtid.setText(String.valueOf(getNewDonorPk(conn)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error getting high value "+e);
			e.printStackTrace();
		}
		txtid.setEditable(false);
		panel.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblFullName = new JLabel("Full Name ");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFullName.setBounds(0, 105, 94, 14);
		panel.add(lblFullName);
		
		txt_fullname = new JTextField();
		txt_fullname.setBounds(104, 103, 210, 20);
		panel.add(txt_fullname);
		txt_fullname.setColumns(10);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBloodGroup.setBounds(378, 55, 94, 18);
		panel.add(lblBloodGroup);
		
		JLabel lblCity = new JLabel("Address");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(0, 239, 68, 14);
		panel.add(lblCity);
		
		JLabel lblDateOfBirth = new JLabel("Age");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateOfBirth.setBounds(378, 101, 76, 23);
		panel.add(lblDateOfBirth);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMobile.setBounds(0, 141, 46, 14);
		panel.add(lblMobile);
		
		txtmobile = new JTextField();
		txtmobile.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent arg) {
				char c=arg.getKeyChar();
				if(!(Character.isDigit(c)))
				{
					arg.consume();
					//System.out.print("key");
				}
			}
		});
		txtmobile.setBounds(104, 139, 210, 20);
		panel.add(txtmobile);
		txtmobile.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(378, 161, 46, 14);
		panel.add(lblGender);
		
		btnSave= new JButton("Save");
		btnSave.setIcon(new ImageIcon(NewDonor.class.getResource("/res/save.png")));
		btnSave.setBackground(Color.LIGHT_GRAY);
		 
		btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(NewDonor.class.getResource("/res/Update details.png")));
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(328, 385, 111, 42);
		panel.add(btnReset);
			
		btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon(NewDonor.class.getResource("/res/Exit application.png")));
		btnClose.setBackground(Color.LIGHT_GRAY);
		btnClose.setBounds(549, 385, 111, 42);
		panel.add(btnClose);
		

		 btnSave.setBounds(104, 385, 111, 42);
		 panel.add(btnSave);
		 btnSave.addActionListener(this);
		 btnReset.addActionListener(this);
		 btnClose.addActionListener(this);
		
		JLabel lblAddNewDonor = new JLabel("Add New Donor");
		lblAddNewDonor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddNewDonor.setBounds(302, 0, 122, 14);
		
		panel.add(lblAddNewDonor);

		frame.getContentPane().add(panel);
		
		txtAge = new JTextField();
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
		txtAge.setBounds(494, 103, 167, 20);
		panel.add(txtAge);
		txtAge.setColumns(10);
		
		//cb_gender = new JComboBox();
		cb_gender = new JComboBox(gen);
		cb_gender.setBounds(494, 159, 122, 20);
		panel.add(cb_gender);
		
		txtAddress = new JTextArea();
		txtAddress.setBounds(104, 235, 210, 70);
		panel.add(txtAddress);
		
		//cb_bg = new JComboBox();

		cb_bg = new JComboBox(bg);
		cb_bg.setBounds(494, 55, 122, 20);
		panel.add(cb_bg);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEmail.setBounds(0, 182, 46, 14);
        panel.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(104, 180, 210, 20);
        panel.add(txtEmail);
        txtEmail.setColumns(10);
        
        JLabel lblCity_1 = new JLabel("City");
        lblCity_1.setBackground(Color.WHITE);
        lblCity_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCity_1.setBounds(0, 338, 46, 14);
        panel.add(lblCity_1);
        
        txtCity = new JTextField();
        txtCity.setBounds(105, 336, 209, 20);
        panel.add(txtCity);
        txtCity.setColumns(10);
        
        frame.getContentPane().add(panel);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 373, 684, 2);
        panel.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 38, 684, 8);
        panel.add(separator_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(NewDonor.class.getResource("/res/all page background image.png")));
        lblNewLabel.setBounds(0, 0, 694, 471);
        panel.add(lblNewLabel);
       
        frame.setVisible(true);
        frame.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btnSave)
		{
		String id,name,mobile,bloodgroup = null,gender = null,address,age,city,email;
		name=txt_fullname.getText().toString();
		mobile=txtmobile.getText().toString();
		address=txtAddress.getText().toString();
		age=txtAge.getText().toString();
		city=txtCity.getText().toString();
		email=txtEmail.getText().toString();
	    Matcher matcher = pattern.matcher(email);

		gender = (String) cb_gender.getSelectedItem();
		bloodgroup=(String) cb_bg.getSelectedItem();
		     
            int newUserPk = 0;
			boolean ranOk = false;
			if(name.length()!=0 && mobile.length()==10 && address.length()!=0 && age.length()!=0 && email.length()!=0&&
					city.length()!=0 && cb_gender.getSelectedIndex()!=0 && cb_bg.getSelectedIndex()!=0 && matcher.matches())
			{
			try {
				conn=DbConnection.getConnection();
				if(conn!=null)
				{
					
					newUserPk = getNewDonorPk(conn);
					System.out.println(newUserPk);
					String sqlStmt="insert into donor(donor_id,name,mobile,address,city,blood_group,email,gender,age) values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement pStmt = conn.prepareStatement(sqlStmt);
					pStmt.setInt(1,newUserPk);
					pStmt.setString(2,name);
					pStmt.setString(3,mobile );
					pStmt.setString(4,address );
					pStmt.setString(5,city );
					pStmt.setString(6,bloodgroup );
					pStmt.setString(7,email );
					pStmt.setString(8, gender);
					pStmt.setString(9, age);
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
		
		
		if(e.getSource()== btnReset)
		{
			txt_fullname.setText("");
			txtmobile.setText("");
			txtAddress.setText("");
			txtAge.setText("");
			txtCity.setText("");
			txtEmail.setText("");
			cb_gender.setSelectedIndex(0);;
			cb_bg.setSelectedIndex(0);
		
		}
		
		if(e.getSource() == btnClose)
		{
    		frame.setVisible(false);
		}
			/*if(name.length()!=0 && mobile.length()!=0 && address.length()!=0 && age.length()!=0)
			{
			
		/*finally {
	            try {
	                if (ranOk)
	                    conn.commit();
	                else
	                    conn.rollback();
	            }
	            catch (Exception e1) {
	            }
	            try {
	                conn.setAutoCommit(true);
	            }
	            catch (Exception e1) {
	            	e1.printStackTrace();
	            }
	        }
			}*/
		}

 public void empty()
 {
	 txt_fullname.setText("");
		txtmobile.setText("");
		txtAddress.setText("");
		txtAge.setText("");
		txtCity.setText("");
		txtEmail.setText("");
		cb_gender.setSelectedIndex(0);;
		cb_bg.setSelectedIndex(0); 
 }
	
	private static int getNewDonorPk(Connection conn) throws Exception {
        String sqlStmt = "SELECT MAX(donor_id) FROM donor";
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

