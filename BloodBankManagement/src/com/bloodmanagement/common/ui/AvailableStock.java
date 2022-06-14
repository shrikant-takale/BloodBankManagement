package com.bloodmanagement.common.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class AvailableStock {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvailableStock window = new AvailableStock();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AvailableStock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(600,500);
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel_1 = new JLabel("A Positive(A +ve)");
		
		JPanel panel = new JPanel();
		panel.setSize(600,400);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Available Blood Group");
		panel.add(lblNewLabel);
		
		frame.getContentPane().add(panel);
		
		JLabel lblAPositivea = new JLabel("A Positive (A+ve)");
		lblAPositivea.setBounds(10, 34, 110, 14);
		panel.add(lblAPositivea);
		
		textField = new JTextField();
		textField.setBounds(153, 31, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setBounds(249, 34, 31, 14);
		panel.add(lblUnits);
		
		JLabel lblBPositiveb = new JLabel("A Negative (A-)");
		lblBPositiveb.setBounds(290, 34, 119, 14);
		panel.add(lblBPositiveb);
		
		textField_1 = new JTextField();
		textField_1.setBounds(432, 31, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(153, 74, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBPositiveb_1 = new JLabel("B Positive (B +ve)");
		lblBPositiveb_1.setBounds(10, 76, 110, 17);
		panel.add(lblBPositiveb_1);
		
		JLabel lblUnits_1 = new JLabel("Units");
		lblUnits_1.setBounds(528, 34, 46, 14);
		panel.add(lblUnits_1);
		
		JLabel lblUnits_2 = new JLabel("Units");
		lblUnits_2.setBounds(249, 77, 31, 14);
		panel.add(lblUnits_2);
		
		JLabel lblBNegativeb = new JLabel("B Negative (B-)");
		lblBNegativeb.setBounds(290, 77, 90, 14);
		panel.add(lblBNegativeb);
		
		textField_3 = new JTextField();
		textField_3.setBounds(432, 74, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUnits_3 = new JLabel("Units");
		lblUnits_3.setBounds(528, 77, 46, 14);
		panel.add(lblUnits_3);
		
		JLabel lblCPositivec = new JLabel("O Positive (O +ve)");
		lblCPositivec.setBounds(10, 116, 110, 14);
		panel.add(lblCPositivec);
		
		textField_4 = new JTextField();
		textField_4.setBounds(153, 113, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblUnits_4 = new JLabel("Units");
		lblUnits_4.setBounds(249, 116, 31, 14);
		panel.add(lblUnits_4);
		
		JLabel lblONegative = new JLabel("O Negative (O -ve)");
		lblONegative.setBounds(289, 116, 101, 14);
		panel.add(lblONegative);
		
		textField_5 = new JTextField();
		textField_5.setBounds(432, 113, 86, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(432, 152, 86, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblUnits_5 = new JLabel("Units");
		lblUnits_5.setBounds(528, 116, 46, 14);
		panel.add(lblUnits_5);
		
		JLabel lblAbPositiveab = new JLabel("AB Positive (AB +ve)");
		lblAbPositiveab.setBounds(10, 155, 119, 14);
		panel.add(lblAbPositiveab);
		
		textField_7 = new JTextField();
		textField_7.setBounds(153, 152, 86, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblUnits_6 = new JLabel("Units");
		lblUnits_6.setBounds(249, 155, 31, 14);
		panel.add(lblUnits_6);
		
		JLabel lblAbNegativeab = new JLabel("AB Negative (AB -ve)");
		lblAbNegativeab.setBounds(290, 154, 132, 17);
		panel.add(lblAbNegativeab);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(117, 221, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(266, 221, 89, 23);
		panel.add(btnReset);
		
		JLabel lblUnits_7 = new JLabel("Units");
		lblUnits_7.setBounds(528, 155, 46, 14);
		panel.add(lblUnits_7);
		
		JLabel lblAvailableBloodGroups = new JLabel("Available Blood Groups");
		lblAvailableBloodGroups.setBackground(new Color(255, 204, 204));
		lblAvailableBloodGroups.setForeground(new Color(153, 51, 0));
		lblAvailableBloodGroups.setBounds(10, 0, 196, 14);
		panel.add(lblAvailableBloodGroups);
		frame.setSize(600,400);    
		frame.setVisible(true);  
		/*JPanel panel_1 = new JPanel();
		panel.setSize(300,200);
		
				panel_1.setLayout(null);

*/

	}
}
