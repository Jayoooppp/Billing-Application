package biliapp;

import java.awt.Color;


import javax.mail.internet.*;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;  
import com.google.i18n.phonenumbers.NumberParseException;  
import com.google.i18n.phonenumbers.PhoneNumberUtil;  
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.qoppa.pdfWriter.PDFPrinterJob;

import sample.Print;  

public class Index extends JFrame implements ActionListener, KeyListener ,Printable{

	private JPanel contentPane;
	private JTextField name_field;
	private JTextField number_field;
	private JTextField product_field;
	private JTextField price_field;
	private int y1,x1,x2,y2;
	private JTextField total_field;
	private JTextField paid_field;
	private JTextField balance_field;
	private JLabel o1,o2,o3,o4,o5,o6,o7,o8,p1,p2,p3,p4,p5,p6,p7,p8;
	private JButton r1,r2,r3,r4,r5,r6,r7,r8;
	
	private HashMap<JButton,JLabel[]> product_unused = new HashMap<>();
	private HashMap<JButton,JLabel[]> product_used = new HashMap<>();
	private JTextField email_field;
	
	
	
	

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try
    	{
    	 // create a PDF Printer Job
		PDFPrinterJob printer = (PDFPrinterJob)PDFPrinterJob.getPrinterJob ();
    	 // set the printable object 
    	 printer.setPrintable (new Index());
    	 // set number of copies to 1 
    	 printer.setCopies (1);
    	 // print and save the document
    	 printer.print("C:\\javaprogram\\new.pdf");
    	 // output done message 
    	 System.out.println("Done!");
    	}
    	catch (Throwable t)
    	{
    	 t.printStackTrace();
    	}

		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public Index() throws ClassNotFoundException, SQLException  {
		
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prince_tailors", "root", "Jaypass!123");
		Statement st = con.createStatement();
		
		PhoneNumberUtil numberUtil = PhoneNumberUtil.getInstance();  
		Font f1 = new Font("Open Sans", Font.PLAIN, 14);
		r1 = new JButton("-");
		r2 = new JButton("-");
		r3 = new JButton("-");
		r4 = new JButton("-");
		r5 = new JButton("-");
		r6 = new JButton("-");
		r7 = new JButton("-");
		r8 = new JButton("-");
		
		o1 = new JLabel("");
		o1.setFont(f1);
		o2 = new JLabel("");
		o2.setFont(f1);
		o3 = new JLabel("");
		o3.setFont(f1);
		o4 = new JLabel("");
		o4.setFont(f1);
		o5 = new JLabel("");
		o5.setFont(f1);
		o6 = new JLabel("");
		o6.setFont(f1);
		o7 = new JLabel("");
		o7.setFont(f1);
		o8 = new JLabel("");
		o8.setFont(f1);
		
		p1 = new JLabel("");
		p1.setFont(f1);
		p2 = new JLabel("");
		p2.setFont(f1);
		p3 = new JLabel("");
		p3.setFont(f1);
		p4 = new JLabel("");
		p4.setFont(f1);
		p5 = new JLabel("");
		p5.setFont(f1);
		p6 = new JLabel("");
		p6.setFont(f1);
		p7 = new JLabel("");
		p7.setFont(f1);
		p8 = new JLabel("");
		p8.setFont(f1);
		
		

		
		
		
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		r5.addActionListener(this);
		r6.addActionListener(this);
		r7.addActionListener(this);
		r8.addActionListener(this);
		
		
		
		
		product_unused.put(r1, new JLabel[] {o1,p1});
		product_unused.put(r2, new JLabel[] {o2,p2});
		product_unused.put(r3, new JLabel[] {o3,p3});
		product_unused.put(r4, new JLabel[] {o4,p4});
		product_unused.put(r5, new JLabel[] {o5,p5});
		product_unused.put(r6, new JLabel[] {o6,p6});
		product_unused.put(r7, new JLabel[] {o7,p7});
		product_unused.put(r8, new JLabel[] {o8,p8});
		
		
		
		
		
		setLocationRelativeTo(null);
		setBackground(Color.BLACK);
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		setForeground(Color.BLACK);
		setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 21));
		setTitle("Billing Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 772, 761);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
		lblName.setBounds(45, 207, 102, 23);
		contentPane.add(lblName);
		
		name_field = new JTextField();
		name_field.setHorizontalAlignment(SwingConstants.LEFT);

		name_field.setToolTipText("Name");
		
		name_field.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblName.setLabelFor(name_field);
		name_field.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		name_field.setBounds(132, 207, 196, 25);
		contentPane.add(name_field);
		name_field.setColumns(30);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 210, 170);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vivek\\Desktop\\Web Development\\Website\\logo.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Prince Tailor");
		lblNewLabel_1.setBounds(276, 71, 215, 50);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 44));
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(0, 0, 756, 175);
		contentPane.add(panel);
		
		JLabel lblM = new JLabel("Mobile Number:");
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
		lblM.setBounds(151, 254, 156, 23);
		contentPane.add(lblM);
		
		number_field = new JTextField();
		number_field.setToolTipText("Number");
		number_field.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		number_field.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		number_field.setColumns(10);
		number_field.setBounds(308, 254, 196, 25);
		contentPane.add(number_field);
		
		JLabel lblProduct = new JLabel("Product:");
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
		lblProduct.setBounds(71, 297, 91, 23);
		contentPane.add(lblProduct);
		
		product_field = new JTextField();
		product_field.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		product_field.setToolTipText("Product Name");
		product_field.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		product_field.setColumns(10);
		product_field.setBounds(163, 300, 196, 25);
		contentPane.add(product_field);
		
		 x1=163;
		 y1=300;
		
		price_field = new JTextField();
		price_field.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		price_field.setToolTipText("Price");
		price_field.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		price_field.setColumns(10);
		price_field.setBounds(404, 300, 196, 25);
		contentPane.add(price_field);
		x2 = 404 ;
		y2 = 300;
		
		JLabel lblRs = new JLabel("Rs:");
		lblRs.setHorizontalAlignment(SwingConstants.CENTER);
		lblRs.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
		lblRs.setBounds(369, 297, 34, 23);
		contentPane.add(lblRs);
		
		
		
//      Add button action listener
		JButton btnAdd = new JButton("ADD");
		btnAdd.setToolTipText("Add product");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pro = product_field.getText();
				String pri = price_field.getText();
				 if(product_used.size() >= 8) {
					JOptionPane.showMessageDialog(contentPane, "8 Products are added no more products can be added", "Alert", JOptionPane.INFORMATION_MESSAGE);
					product_field.setText("");
					price_field.setText("");
					
				}
				else if(pro.length() <= 0 && pri.length() <= 0)
				{
					JOptionPane.showMessageDialog(contentPane, "Please Enter all the details", "Alert", JOptionPane.INFORMATION_MESSAGE);
				}else if(pro.length() <= 0) {
					JOptionPane.showMessageDialog(contentPane, "Please Enter Porduct name", "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(pri.length() <= 0) {
					JOptionPane.showMessageDialog(contentPane, "Please Enter Product Price", "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else {
				Entry<JButton,JLabel[]> entry = product_unused.entrySet().iterator().next();
				JButton rem = entry.getKey();
				JLabel item = entry.getValue()[0];
				JLabel price = entry.getValue()[1];
				product_unused.remove(rem);
				item.setText(" " +pro);
				price.setText( " ₹ " +pri);
				product_used.put(rem, new JLabel[] {item,price});
				product_field.setText("");
				price_field.setText("");
				int p = Integer.parseInt(total_field.getText()) +Integer.parseInt(pri);
				total_field.setText(String.valueOf(p));
				p = p - Integer.parseInt(paid_field.getText());
				balance_field.setText(String.valueOf(p));
				refactor();
				}
				

				
				
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(631, 301, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
		lblTotal.setBounds(243, 543, 64, 23);
		contentPane.add(lblTotal);
		
		total_field = new JTextField();
		total_field.setToolTipText("Total");
		total_field.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		total_field.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		total_field.setColumns(10);
		total_field.setBounds(308, 541, 110, 25);
		total_field.setText("0");
		total_field.setEditable(false);
		contentPane.add(total_field);
		
		JLabel lblPaid = new JLabel("Paid:");
		lblPaid.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaid.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
		lblPaid.setBounds(243, 577, 64, 23);
		contentPane.add(lblPaid);
		
		paid_field = new JTextField();
		paid_field.setToolTipText("Paid");
		paid_field.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		paid_field.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		paid_field.setColumns(10);
		paid_field.setText("0");
		paid_field.setBounds(308, 577, 110, 25);
		paid_field.addKeyListener(this);
		contentPane.add(paid_field);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalance.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
		lblBalance.setBounds(212, 613, 91, 23);
		contentPane.add(lblBalance);
		
		balance_field = new JTextField();
		balance_field.setToolTipText("Balance");
		balance_field.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		balance_field.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		balance_field.setColumns(10);
		balance_field.setText("0");
		balance_field.setBounds(308, 613, 110, 25);
		balance_field.setEditable(false);
		contentPane.add(balance_field);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setFont(new Font("Candara", Font.BOLD, 18));
		btnNewButton.setBounds(226, 658, 81, 26);
		contentPane.add(btnNewButton);
//		Saving data in the database
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				
				PhoneNumber phoneNumber = null;
				try {
					phoneNumber = numberUtil.parse(number_field.getText(), "IN");
				} catch (NumberParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
				if(name_field.getText().length() <= 0 || number_field.getText().length() <= 0 || email_field.getText().length() <= 0)
				{
					JOptionPane.showMessageDialog(contentPane, "Please Enter all the details", "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(numberUtil.isValidNumber(phoneNumber) != true)
				{
					JOptionPane.showMessageDialog(contentPane, "Please Enter the valid mobile number", "Alert", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else if(validateEmail(email_field.getText()) != true)
				{
					JOptionPane.showMessageDialog(contentPane, "Please Enter the valid email id", "Alert", JOptionPane.INFORMATION_MESSAGE);

				}
				else {
					String name,email = null;
				
				try {
					
					 name = name_field.getText();
					 email = email_field.getText();
					long number = Long.parseLong(number_field.getText());
					int total = Integer.parseInt(total_field.getText());
					int paid = Integer.parseInt(paid_field.getText());
					int balance = Integer.parseInt(balance_field.getText());
					
					String query = "INSERT INTO orders(customer_name ,customer_number,email_id,total,paid,balance) "
							+ "VALUES('"+name +"'," +number +",'" +email +"'," +total +"," +paid +"," +balance +")";					
					st.executeUpdate(query);
					int i=1;
					
					for (Entry<JButton, JLabel[]> e2 : product_used.entrySet()) {
						query = "UPDATE orders SET product" +i +" = '" +e2.getValue()[0].getText() +"' , price" +i +"='" +Integer.parseInt(e2.getValue()[1].getText().replaceAll("[^0-9]", "")) +"' where orders.customer_name='" +name +"'";
						i+=1;
						st.executeUpdate(query);
					}
					JOptionPane.showMessageDialog(contentPane, "Data has been saved in the database", "Saved", JOptionPane.INFORMATION_MESSAGE);

 					
					
				}
				catch(SQLIntegrityConstraintViolationException e1)
				{
					JOptionPane.showMessageDialog(contentPane, "Name already exists in the database Please enter different name", "Alert", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
			}
			
		});
		
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.setFont(new Font("Candara", Font.BOLD, 18));
		btnNewButton_1.setBounds(404, 657, 89, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
		lblEmail.setBounds(362, 207, 102, 23);
		contentPane.add(lblEmail);
		
		email_field = new JTextField();
		email_field.setToolTipText("Email");
		email_field.setHorizontalAlignment(SwingConstants.LEFT);
		email_field.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		email_field.setColumns(30);
		email_field.setBounds(448, 207, 221, 25);
		email_field.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		contentPane.add(email_field);
		
	}
	
	public void refactor()
	{
		int bx=442,by=332;
		int lx=280,ly=332;
		 for (Entry<JButton, JLabel[]> e : product_used.entrySet()) {
			 e.getKey().setBounds(bx,by,39,21);
			 e.getValue()[0].setBounds(lx, ly, 80, 23);
			
			 e.getValue()[1].setBounds(lx+100, ly, 60, 23);
		
			 e.getValue()[1].setVisible(true);
			 e.getKey().setVisible(true);
			 e.getValue()[0].setVisible(true);
			 contentPane.add(e.getKey());
			 contentPane.add(e.getValue()[0]);
			 contentPane.add(e.getValue()[1]);
			 by += 25;
			 ly += 25;
			 
		 }
		 revalidate();
         repaint();
		
	}

	
	
//	Remove Button actionlistener
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JLabel product = product_used.get(e.getSource())[0];
		JButton rem = (JButton) e.getSource();
		JLabel price = product_used.get(e.getSource())[1];
		
		int pri = Integer.parseInt(total_field.getText()) - Integer.parseInt(price.getText().replaceAll("[^0-9]", ""));
		total_field.setText(String.valueOf(pri));
		pri = pri - Integer.parseInt(paid_field.getText());
		balance_field.setText(String.valueOf(pri));
		product.setVisible(false);
		rem.setVisible(false);
		price.setVisible(false);
		product_used.remove(e.getSource());
		product_unused.put(rem, new JLabel[] {product,price});
		refactor();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	 try
        {
		int price = Integer.parseInt(total_field.getText()) - Integer.parseInt(paid_field.getText());
		balance_field.setText(String.valueOf(price));
		}
	 catch(NumberFormatException e1)
     {
         System.out.print("NullPointerException Caught");
     }
		
	}
	public boolean validateEmail(String email) {
		 
		  boolean isValid = false;
		 
		  try {
		 
		//Create InternetAddress object and validated the email address.
		 
		InternetAddress internetAddress = new InternetAddress(email);
		 
		internetAddress.validate();
		 
		isValid = true;
		 
		  } catch (AddressException e) {
		 
		e.printStackTrace();
		 
		  }
		 
		  return isValid;
		   }

public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
	// TODO Auto-generated method stub
	if (pageIndex == 0)
	{
		g.translate(100, 100);
     
	 contentPane.print(g);
	 return Printable.PAGE_EXISTS;
	}
	else
	{
	 return Printable.NO_SUCH_PAGE;
	}
}
}
