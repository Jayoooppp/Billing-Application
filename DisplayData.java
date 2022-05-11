package biliapp;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

 

public class DisplayData extends JFrame implements ActionListener  {

 

    JFrame frame1;
    
    JFrame frame2;


    JLabel l0, l1, l2;

    JComboBox cb;

    JButton b1;
    
    JButton b2;
    
    JPanel p1;
    
    
    JButton print;

    Connection con;

    ResultSet rs, rs1;

    Statement st, st1;

    PreparedStatement pst , pst1;

    int ids;

    static JTable table1;
    
    static JTable table2;

    String[] T1columns = {"Product Name", "Quantity", "Price"};
    
    String[] T2columns = {"Bill Id" , "Name" , "Email" , "Price" , "Date" , "PhoneNumber"};

    int from;

 

    
    public DisplayData() {

    	frame2 = new JFrame();
 

        l0 = new JLabel("Fatching Bill Information");

        l0.setForeground(Color.black);

        l0.setFont(new Font("Serif", Font.BOLD, 20));

        l1 = new JLabel("Select Bill Id");

        b1 = new JButton("submit");

 

        l0.setBounds(100, 50, 350, 40);

        l1.setBounds(75, 110, 75, 20);

        b1.setBounds(150, 180, 150, 20);

        b1.addActionListener(this);
        
        
        b2 = new JButton("Back");
        
        b2.setBounds(150, 220, 150, 20);
        
        b2.addActionListener(this);

 

        frame2.setTitle("Fetching Bill Info From DataBase");

        frame2.setLayout(null);

        frame2.setVisible(true);

        frame2.setSize(500, 500);

        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame2.setLocationRelativeTo(null);

 

        frame2.add(l0);

        frame2.add(l1);

        frame2.add(b1);

        try {

        	Class.forName("com.mysql.cj.jdbc.Driver");
     		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Jaypass!123");

            st = con.createStatement();

            rs = st.executeQuery("select id from bill");

            Vector v = new Vector();

            while (rs.next()) {

                ids = rs.getInt(1);
                

                v.add(ids);

            }
            cb=new JComboBox(v);  
            cb.setBounds(150, 110, 150, 20);  
            frame2.add(cb);
            frame2.add(b2);
            


    }catch (Exception e) {

    }
    }

 

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            showTableData();

        }else {
        	if(ae.getSource() == b2)
        	{
        		Home h = new Home();
        		h.setVisible(true);
        		h.setLocationRelativeTo(null);
        		frame2.dispose();
        	}
        }

 

    }

 

    public void showTableData() {

 

        frame1 = new JFrame("Database Search Result");

        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        frame1.setLayout(new FlowLayout());
        
        frame1.setLocationRelativeTo(null);
        
        
    
        

//TableModel tm = new TableModel();

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(T2columns);
        
        
        DefaultTableModel model2 = new DefaultTableModel();

        model2.setColumnIdentifiers(T1columns);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

//table = new JTable(model);

        table1 = new JTable();
        
        
        

        table1.setModel(model);

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        
        
        table2 = new JTable();

      
      

      table2.setModel(model2);

      table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);



        JScrollPane scroll = new JScrollPane(table1);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        
        
        JScrollPane scroll2 = new JScrollPane(table2);

        scroll2.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll2.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        scroll.setBounds(0, 0, 100, 100);
        
        scroll2.setBounds(0, 100, 100, 100);


        from = (int) cb.getSelectedItem();

//String textvalue = textbox.getText();

        int id = 0;

        String name = "";

        String email = "";

        int price = 0;
        
        long number = 0;
        
        Date d;
        
        int p_id;
        int quantity;
        String p_name = "";
        
        
        

 

        try {

            pst = con.prepareStatement("select * from bill where id=" + from );
            
            
            pst1 = con.prepareStatement("select * from sample.order where order.bill_id=" + from );
            
            
            

            ResultSet rs = pst.executeQuery();
            
            
            ResultSet rs1 = pst1.executeQuery();

            int i = 0;

            if (rs.next()) {

                id = rs.getInt("id");
                
                name = rs.getString("name");

                email = rs.getString("email");

                price = rs.getInt("price");

                d = rs.getDate("created_at");
                
                number = rs.getLong("phone_number");
                

                model.addRow(new Object[]{id,name,email,price,d,number});

                i++;
            }
            
            while (rs1.next()) {

                p_id = rs1.getInt("product_id");
                
                pst = con.prepareStatement("select * from product where id='" + p_id + "'");
                
                ResultSet rs3 = pst.executeQuery();
                rs3.next();
                
                	p_name = rs3.getString("name");
                	price = rs3.getInt("price");
                	
                
                quantity = rs1.getInt("quantity");
                

                
                
                
                

                model2.addRow(new Object[]{p_name,quantity,price});

                i++;
            }
            
            
            

            if (i < 1) {

                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

            }

            if (i == 1) {

                System.out.println(i + " Record Found");

            } else {

                System.out.println(i + " Records Found");

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        frame1.add(scroll);
        
        frame1.add(scroll2);

        frame1.setVisible(true);	

        frame1.setSize(1000 , 600);
        frame1.setLocationRelativeTo(null);
        
        
        
        

    }

 

    public static void main(String args[]) {

        new DisplayData();
        
        

    }



	
}
