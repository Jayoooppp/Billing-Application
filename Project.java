package biliapp;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.qoppa.pdfWriter.PDFPrinterJob;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

public class Project extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField name_field;
    private JTextField number_field;
    
    private JTextField total_field;

    
    private JButton btnNewButton_1;
    
    
    private int billId;
    
    JButton btnNewButton_1_1;
    
    private HashMap<Integer, Integer> quantity = new HashMap<Integer, Integer>();

    
    private JTextField email_field;
    
    String sender , host;
    Properties properties;
    Session session;
    ArrayList<Product> products = new ArrayList<Product>();

    private void createProductLabels() {
        int n_width = 120, n_height = 45, p_width = 120, p_height = 45;
        int n_x = 270, n_y = 310, p_x = 340, p_y = 310;
        for (Product product : products) {
            JLabel jPriceLabel = new JLabel();
            Font font = new Font("Microsoft YaHei", Font.PLAIN, 17);
            float price = product.getPrice();
            jPriceLabel.setText(Float.toString(price));
            jPriceLabel.setBounds(p_x, p_y, p_width, p_height);
            p_y += 30;
            
            jPriceLabel.setVisible(true);
            JLabel jNameLabel = new JLabel();
            jNameLabel.setText(product.getName());
            jNameLabel.setBounds(n_x, n_y, n_width, n_height);
            n_y += 30;
            jNameLabel.setVisible(true);
            quantity.put(product.getId(), 0);
            JTextField jPriceTextField = new JTextField();
            jPriceTextField.setBounds(p_x + 70, p_y-17, 30, 20);
            jPriceTextField.setVisible(true);
            jPriceTextField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent documentEvent) {
                    changedUpdate(documentEvent);
                }

                @Override
                public void removeUpdate(DocumentEvent documentEvent) {
                    changedUpdate(documentEvent);
                }

                @Override
                public void changedUpdate(DocumentEvent documentEvent) {
                    int currQuan;
                    if (jPriceTextField.getText().equals("")) currQuan = 0;
                    else currQuan = Integer.parseInt(jPriceTextField.getText());
                    quantity.put(product.getId(), currQuan);
                    int total = 0;
                    for (Product product_ : products) {
                        total += (quantity.get(product_.getId()) * product_.getPrice());
                    }
                    total_field.setText(Integer.toString(total));
                }
            });
            jNameLabel.setFont(font);
            jPriceLabel.setFont(font);
            jPriceTextField.setFont(font);
            getContentPane().add(jNameLabel);
            getContentPane().add(jPriceLabel);
            getContentPane().add(jPriceTextField);
            System.out.println(product.getName());
        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {



        Project frame = new Project();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
//        
    }

    /**
     * Create the frame.
     * @throws SQLException
     */

    public Project() throws ClassNotFoundException, SQLException  {

       
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Jaypass!123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, name, price FROM `product`");
        while(rs.next()) {
            products.add(new Product(Integer.parseInt(rs.getString("id")), rs.getString("name"), Float.parseFloat(rs.getString("price"))));
        }

        PhoneNumberUtil numberUtil = PhoneNumberUtil.getInstance();
        Font f1 = new Font("Open Sans", Font.PLAIN, 14);
        

        
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
//        setAlwaysOnTop(true);
        setType(Type.POPUP);
        setForeground(Color.BLACK);
        setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 21));
        setTitle("Billing Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 800;
        int height = 600;
        setBounds(200, 100, 772, 761);
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
        lblNewLabel_1.setBounds(276, 71, width, height /8);
        contentPane.add(lblNewLabel_1);
        lblNewLabel_1.setBackground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 44));
        lblNewLabel_1.setForeground(new Color(128, 128, 128));

        JPanel panel = new JPanel();
        panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
        panel.setBackground(new Color(175, 238, 238));
        panel.setBounds(0, 0, width, height /4);
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
        
        
        

        JButton submitButton = new JButton("Order");
        submitButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        submitButton.setBounds(320, 604, 86, 25);
        submitButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent actionEvent) {
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
                int count = 0;
                Statement insertStatement = null;
                try {
                    insertStatement = con.createStatement();
                    String query1 = "INSERT INTO bill (name, email, phone_number) VALUES ('" + name_field.getText() + "', '" + email_field.getText() + "'," + number_field.getText()+")";
                    insertStatement.executeUpdate(query1);
                    
                   ResultSet idRs = insertStatement.executeQuery(" SELECT MAX(id) as id FROM `bill`");
                     billId = -1;
                    
                    if(idRs.next())
                    {
                    billId = idRs.getInt("id");
                    }
                    if (billId != -1) {
                        // Things are right
                        for (Product product : products) {
                            int productId = product.getId();
                            int quantity_ = quantity.get(productId);
                            if(quantity_ > 0)
                            {
                            	count++;
                            String query = "INSERT INTO `order` (bill_id, product_id, quantity) VALUE (" + billId + ", " + productId + ", " + quantity_ + ")";
                            insertStatement.executeUpdate(query);
                            }
                        }
                    }
                } catch (SQLException e) {
                    // TODO: Handle error
                    e.printStackTrace();
                }
                if(count == 0)
                {
                	JOptionPane.showMessageDialog(contentPane, "Please select at least one product", "Select Product", JOptionPane.ERROR_MESSAGE);
                	
                }
                else {
                JOptionPane.showMessageDialog(contentPane, "Bill has saved in the database", "Saved", JOptionPane.INFORMATION_MESSAGE, null);
                
                
                }
            }
        });
        contentPane.add(submitButton);

        

        


         btnNewButton_1 = new JButton("Print");
        btnNewButton_1.setFont(new Font("Candara", Font.BOLD, 18));
        btnNewButton_1.setBounds(404, 657, 89, 29);
        btnNewButton_1.addActionListener(this);
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
        
         btnNewButton_1_1 = new JButton("Back");
        btnNewButton_1_1.setFont(new Font("Candara", Font.BOLD, 18));
        btnNewButton_1_1.setBounds(254, 658, 89, 29);
        contentPane.add(btnNewButton_1_1);
        btnNewButton_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Home h = new Home();
				h.setVisible(true);
				h.setLocationRelativeTo(null);
				dispose();
				
				
			}
        	
        });
        createProductLabels();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton_1)
		{
			number_field.setText("");
            name_field.setText("");
            email_field.setText("");
            total_field.setText("");
			PrintData d = new PrintData(billId);
		}
		
	}

	

    
	
}
