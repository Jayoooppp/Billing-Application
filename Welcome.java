package biliapp;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import biliapp.Login;


import javax.swing.ImageIcon;
import java.awt.Color;

public class Welcome extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Welcome frame = new Welcome();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		ImageIcon img = new ImageIcon("C:\\javaprogram\\welcome-image.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 420);
		contentPane = new JPanel() {
			@Override
		     protected void paintComponent(Graphics g)
		     {
		        super.paintComponent(g);
		        g.drawImage(img.getImage(), 0, 0, null);
		     }
		  };
		
		contentPane.setBackground(new Color(0, 204, 204));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To");
		lblNewLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 35));
		lblNewLabel.setBounds(208, 22, 197, 66);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Billing");
		lblNewLabel_1.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 50));
		lblNewLabel_1.setBounds(245, 110, 122, 60);
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Application");
		lblNewLabel_2.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 50));
		lblNewLabel_2.setBounds(199, 159, 235, 52);
		lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNext.setBounds(260, 290, 89, 23);
		btnNext.setHorizontalAlignment(JButton.CENTER);
		btnNext.addActionListener(this);

		contentPane.add(btnNext);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Login l  = new Login();
		l.setVisible(true);
		l.setLocationRelativeTo(null);
	
		
		
		dispose();
		
		
	}
}
