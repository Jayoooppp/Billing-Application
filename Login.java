package biliapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class Login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField loginid;
	static JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					Login frame = new Login();
					
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		ImageIcon img = new ImageIcon("C:\\javaprogram\\login-image.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 530);
		contentPane = new JPanel() {
			@Override
		     protected void paintComponent(Graphics g)
		     {
		        super.paintComponent(g);
		        g.drawImage(img.getImage(), 0, 0, null);
		     }
		  };
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Owner Login");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(343, 11, 173, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblLoginId = new JLabel("Login ID:");
		lblLoginId.setFont(new Font("Trebuchet MS", Font.PLAIN, 29));
		lblLoginId.setBounds(285, 98, 117, 37);
		contentPane.add(lblLoginId);
		
		loginid = new JTextField();
		loginid.setFont(new Font("Arial", Font.PLAIN, 17));
		loginid.setBounds(412, 98, 167, 35);
		contentPane.add(loginid);
		loginid.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 29));
		lblPassword.setBounds(264, 168, 138, 37);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(412, 168, 167, 37);
		
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		btnNewButton.setBounds(391, 301, 89, 23);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String id = loginid.getText();
		if(!id.equals("PrinceTailor")) {
			JOptionPane.showMessageDialog(this, "Please Enter Valid ID", "Wrong ID", JOptionPane.ERROR_MESSAGE);
		}else if(!passwordField.getText().equals("PrinceTailor@123")) {
			JOptionPane.showMessageDialog(this, "Please Enter Valid Password", "Wrong Password", JOptionPane.ERROR_MESSAGE);
			
		}
		else {
			Home h = new Home();
			h.setLocationRelativeTo(null);
			h.setVisible(true);
			dispose();
		}
		
	}
}
