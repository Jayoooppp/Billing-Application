package biliapp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class Home extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Home frame = new Home();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	JButton btnNewButton , btnShowBills;
	public Home() {
		ImageIcon img = new ImageIcon("C:\\javaprogram\\home-image.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 417);
		contentPane = new JPanel() {
			@Override
		     protected void paintComponent(Graphics g)
		     {
		        super.paintComponent(g);
		        g.drawImage(img.getImage(), 0, 0, null);
		     }
		  };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Make Bill");
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(96, 239, 139, 44);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		 btnShowBills = new JButton("Show Bills");
		btnShowBills.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnShowBills.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnShowBills.setBounds(96, 329, 139, 38);
		btnShowBills.addActionListener(this);
		contentPane.add(btnShowBills);
		
		JLabel lblNewLabel = new JLabel("BILLING");
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 27));
		lblNewLabel.setBounds(94, 71, 120, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblApp = new JLabel("APP");
		lblApp.setFont(new Font("Segoe UI Historic", Font.BOLD, 27));
		lblApp.setBounds(96, 135, 53, 53);
		contentPane.add(lblApp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton) {
			
		
		Project p = null;
		try {
			p = new Project();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		p.setLocationRelativeTo(null);
		p.setVisible(true);
		dispose();
		}
		else if(e.getSource() == btnShowBills)
		{
			
				DisplayData d = new DisplayData();
				dispose();
			
			
			
		}
		
	}

}
