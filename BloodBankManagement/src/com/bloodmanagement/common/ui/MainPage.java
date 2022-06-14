package com.bloodmanagement.common.ui;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.*;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import com.bloodmanagement.common.ui.Login;
import com.bloodmanagement.common.ui.bloodbank.BloodBankList;
import com.bloodmanagement.common.ui.bloodbank.BloodBankRegister;
import com.bloodmanagement.common.ui.donor.NewDonor;


public class MainPage extends JDialog implements ActionListener  {

	private JFrame frame;
	JMenu mnDonor,mnSearchBloodDonor;
	JMenuItem mntmAddNew,mntmUpdateDetails,mntmAllDonorDetails,mntmDecrease,mntmDetails,mntmDonor,mntmManageUsers;
	JMenuItem mntmExit,mntmExitApplication,mntByName,mntmLocation,mntmBloodGroup,mntmIncrease,mntmAddUsers;
	JMenuItem mntmBloodBankRegistration;
	private JMenuItem mntmBloodBankList;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MainPage dialog = new MainPage();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
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
		frame.getContentPane().setLayout(null);    
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 1354, 60);
		frame.getContentPane().add(menuBar);
		
		mnDonor = new JMenu("Donor");
		mnDonor.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnDonor.setIcon(new ImageIcon(MainPage.class.getResource("/res/Donor.png")));
		mnDonor.setMnemonic(KeyEvent.VK_A);   //Alt+F shortcut
		menuBar.setBackground(Color.WHITE);
		
		JMenu mnBloodBank = new JMenu("Blood Bank");
		mnBloodBank.setForeground(Color.BLACK);
		mnBloodBank.setIcon(new ImageIcon(MainPage.class.getResource("/res/Blood group.png")));
		mnBloodBank.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnBloodBank);
		
		mntmBloodBankRegistration = new JMenuItem("Blood Bank Registration");
		mntmBloodBankRegistration.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmBloodBankRegistration.setIcon(new ImageIcon(MainPage.class.getResource("/res/Add new.png")));
		mntmBloodBankRegistration.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
		mnBloodBank.add(mntmBloodBankRegistration);
		
		mntmBloodBankList = new JMenuItem("Blood Bank List");
		mntmBloodBankList.setIcon(new ImageIcon(MainPage.class.getResource("/res/Details.png")));
		mntmBloodBankList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
		mntmBloodBankList.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnBloodBank.add(mntmBloodBankList);
		mntmBloodBankRegistration.addActionListener(this);
		mntmBloodBankList.addActionListener(this);
		mnDonor.setForeground(Color.BLACK);

		menuBar.add(mnDonor);
		
		mntmAddNew = new JMenuItem("Blood Donor Registration");
		mntmAddNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAddNew.setIcon(new ImageIcon(MainPage.class.getResource("/res/Add new.png")));
		mnDonor.add(mntmAddNew);
		mntmAddNew.addActionListener(this);
		
		JSeparator separator = new JSeparator();
		mnDonor.add(separator);
		
		mntmUpdateDetails = new JMenuItem("Update Details");
		mntmUpdateDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mntmUpdateDetails.setIcon(new ImageIcon(MainPage.class.getResource("/res/Update details.png")));
		mnDonor.add(mntmUpdateDetails);
		mntmUpdateDetails.addActionListener(this);
				
				JSeparator separator_1 = new JSeparator();
				mnDonor.add(separator_1);
		
				
				mntmAllDonorDetails = new JMenuItem("All Donor Details");
				mntmAllDonorDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
				mntmAllDonorDetails.setIcon(new ImageIcon(MainPage.class.getResource("/res/Details.png")));
				mnDonor.add(mntmAllDonorDetails);
				
				mnSearchBloodDonor = new JMenu("Search Donor");
				mnSearchBloodDonor.setFont(new Font("Segoe UI", Font.BOLD, 14));
				mnSearchBloodDonor.setIcon(new ImageIcon(MainPage.class.getResource("/res/search user.png")));
				mnSearchBloodDonor.setForeground(Color.BLACK);
				menuBar.add(mnSearchBloodDonor);
				
				mntByName = new JMenuItem("By Name");
				mntByName.setIcon(new ImageIcon(MainPage.class.getResource("/res/login.png")));
				mntByName.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
				mnSearchBloodDonor.add(mntByName);
				
				mntmLocation = new JMenuItem("By Location");
				mntmLocation.setIcon(new ImageIcon(MainPage.class.getResource("/res/Location.png")));
				mntmLocation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
				mnSearchBloodDonor.add(mntmLocation);
				
				mntmBloodGroup = new JMenuItem("By Blood Group");
				mntmBloodGroup.setIcon(new ImageIcon(MainPage.class.getResource("/res/Blood group.png")));
				mntmBloodGroup.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
				mnSearchBloodDonor.add(mntmBloodGroup);
				
				
				JMenu mnStock = new JMenu("Stock");
				mnStock.setFont(new Font("Segoe UI", Font.BOLD, 14));
				mnStock.setIcon(new ImageIcon(MainPage.class.getResource("/res/stock.png")));
				mnStock.setForeground(Color.BLACK);
				menuBar.add(mnStock);
				
				mntmIncrease = new JMenuItem("Increase");
				mntmIncrease.setIcon(new ImageIcon(MainPage.class.getResource("/res/Inc.png")));
				mntmIncrease.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.SHIFT_MASK));
				mnStock.add(mntmIncrease);
				
				mntmDecrease = new JMenuItem("Decrese");
				mntmDecrease.setIcon(new ImageIcon(MainPage.class.getResource("/res/Dec.png")));
				mntmDecrease.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.SHIFT_MASK));
				mnStock.add(mntmDecrease);
				
				mntmDetails = new JMenuItem("Details");
				mntmDetails.setIcon(new ImageIcon(MainPage.class.getResource("/res/Details.png")));
				mntmDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.SHIFT_MASK));
				mnStock.add(mntmDetails);
				
				JMenu mnDelete = new JMenu("Delete");
				mnDelete.setFont(new Font("Segoe UI", Font.BOLD, 14));
				mnDelete.setIcon(new ImageIcon(MainPage.class.getResource("/res/delete donor.png")));
				mnDelete.setForeground(Color.BLACK);
				menuBar.add(mnDelete);
				
				mntmDonor = new JMenuItem("Delete Donor");
				mntmDonor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.SHIFT_MASK));
				mntmDonor.setIcon(new ImageIcon(MainPage.class.getResource("/res/delete.png")));
				mnDelete.add(mntmDonor);
				
				JMenu mnAdministration = new JMenu("Admin");
				mnAdministration.setIcon(new ImageIcon(MainPage.class.getResource("/res/blogger (1).png")));
				mnAdministration.setBackground(new Color(240, 240, 240));
				mnAdministration.setForeground(Color.BLACK);
				mnAdministration.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuBar.add(mnAdministration);
				
				mntmAddUsers = new JMenuItem("Add Users");
				mntmAddUsers.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
				mntmAddUsers.setIcon(new ImageIcon(MainPage.class.getResource("/res/Add new.png")));
				mnAdministration.add(mntmAddUsers);
				
				mntmManageUsers = new JMenuItem("Delete Users");
				mntmManageUsers.setIcon(new ImageIcon(MainPage.class.getResource("/res/delete.png")));
				mntmManageUsers.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
				mnAdministration.add(mntmManageUsers);
				
				JMenu mnExit = new JMenu("Exit");
				mnExit.setFont(new Font("Segoe UI", Font.BOLD, 14));
				mnExit.setIcon(new ImageIcon(MainPage.class.getResource("/res/exit.png")));
				mnExit.setForeground(Color.BLACK);
				menuBar.add(mnExit);
				
				mntmExit = new JMenuItem("Logout");
				mntmExit.setIcon(new ImageIcon(MainPage.class.getResource("/res/Logout.png")));
				mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
				mnExit.add(mntmExit);
				
				mntmExitApplication = new JMenuItem("Exit Application");
				mntmExitApplication.setIcon(new ImageIcon(MainPage.class.getResource("/res/Exit application.png")));
				mntmExitApplication.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.SHIFT_MASK));
				mnExit.add(mntmExitApplication);
				
				label = new JLabel("");
				label.setIcon(new ImageIcon(MainPage.class.getResource("/res/home.png")));
				label.setBounds(0, 0, 1364, 739);
				frame.getContentPane().add(label);
				
				//add listener 
				mntmExitApplication.addActionListener(this);
				mntmExit.addActionListener(this);
				mntmAllDonorDetails.addActionListener(this);
				mntByName.addActionListener(this);
				mntmLocation.addActionListener(this);
				mntmBloodGroup.addActionListener(this);
				mntmIncrease.addActionListener(this);
				mntmDecrease.addActionListener(this);
				mntmDetails.addActionListener(this);
				mntmDonor.addActionListener(this);
				mntmAddUsers.addActionListener(this);
				mntmManageUsers.addActionListener(this);
				

		frame.setSize(1366,768);    
		frame.setVisible(true);  
        frame.setResizable(false);

		//frame.add(menuBar);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== mntmAddNew)
		{
			NewDonor frm=new NewDonor();
			frm.setSize(600, 500);
			frm.setResizable(false);
	        //frm.setVisible(true);	
		}
		if(e.getSource()== mntmUpdateDetails)
		{
			 UpdateDonor updateDonor=new UpdateDonor();
	    //     frm.setVisible(true);	
		}
		if(e.getSource()==mntmAllDonorDetails)
		{
			AllDonor frm=new AllDonor();
			frm.setSize(600, 500);
			frm.setBounds(100, 100, 600, 500);
			frm.setVisible(true);
			frm.setResizable(false);


		}
		if(e.getSource()==mntByName)
		{
			SearchByName frm=new SearchByName();
			frm.setSize(600, 500);
			frm.setResizable(false);
			frm.setVisible(true);
			frm.setBounds(100, 100, 600, 500);
		}
		
		if(e.getSource()==mntmBloodGroup)
		{
			SearchBloodGroup frm=new SearchBloodGroup();
			frm.setResizable(false);
			frm.setVisible(true);
			frm.setBounds(100, 100, 600, 500);


		}
		if(e.getSource()==mntmLocation)
		{
			SearchDonorByLocation obj=new SearchDonorByLocation();
			obj.setBounds(100, 100, 600, 500);
			obj.setSize(600, 500);
			obj.setResizable(false);
			obj.setVisible(true);


		}
		if(e.getSource()==mntmIncrease)
		{
			StockInc obj=new StockInc();
			//obj.setSize(690, 500);
			obj.setBounds(100, 100, 690, 500);

			obj.setResizable(false);
			obj.setVisible(true);	

		}
		if(e.getSource()==mntmDecrease)
		{
			StockDec obj=new StockDec();
			//obj.setSize(650, 420);
			obj.setBounds(100, 100, 650, 420);

			obj.setResizable(false);
			obj.setVisible(true);	

		}
		if(e.getSource()==mntmDetails)
		{
		StockDetails obj=new StockDetails();
		//obj.setSize(500, 400);
		obj.setBounds(100, 100, 500, 400);
		obj.setResizable(false);
		obj.setVisible(true);	
		}
		if(e.getSource()==mntmDonor)
		{
			DeleteDonor obj=new DeleteDonor();
			/*obj.setBounds(100, 100, 500, 400);
			obj.setResizable(false);
			obj.setVisible(true);*/
			//obj.setVisible(true);	

		}
		if(e.getSource()== mntmAddUsers)
		{
			AddUser obj=new AddUser();
			obj.setVisible(true);
		}
		if(e.getSource()==mntmManageUsers)
		{
			DeleteUser obj=new DeleteUser();
			obj.setVisible(true);
		}
		if(e.getSource()== mntmExit)
		{
			 int a = JOptionPane.showConfirmDialog(null,"Do you Really Want to Logout","Select", JOptionPane.YES_NO_OPTION);
	         if(a==0)
	         {
	        	 this.setVisible(false);
	        	 new Login().setVisible(true);
	         }
		}
		if(e.getSource()==mntmExitApplication)
		{
			 int a = JOptionPane.showConfirmDialog(null,"Do you Really Want to Close this application","Select", JOptionPane.YES_NO_OPTION);
	         if(a==0)
	         {
	        	 System.exit(0);
	         }
	  }
		if(e.getSource()==mntmBloodBankRegistration)
		{
			BloodBankRegister obj=new BloodBankRegister();
			obj.setVisible(true);
		}
		if(e.getSource()==mntmBloodBankList)
		{
			BloodBankList obj=new BloodBankList();
			obj.setVisible(true);
		}
	}
}
