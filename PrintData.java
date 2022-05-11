package biliapp;

import java.awt.*;

import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

 

public class PrintData extends JFrame   {

 

    JFrame frame1;
    
   
   

 
    
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

 

    
    
 

    

 

    public  PrintData(int from) {
    	
    	p1 = new JPanel();
    	p1.setLayout(new BorderLayout());
    	p1.setSize(600, 600);

 

        frame1 = new JFrame("Database Search Result");

        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        frame1.setLayout(new FlowLayout());
        
        frame1.setLocationRelativeTo(null);
        
        
        
        frame1.add(p1);
        
        
        print = new JButton("Print");
        print.setBounds(500, 500, 50, 20);
        print.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

		        PrinterJob job =  PrinterJob.getPrinterJob();
		        job.setJobName("Print Bill");
		        
		        job.setPrintable(new Printable() {

					@Override
					public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
						// TODO Auto-generated method stub
						if(pageIndex > 0)
						{
							return Printable.NO_SUCH_PAGE;
						}
						Graphics2D g2 = (Graphics2D)graphics;
						
						g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
						g2.scale(1,1);
						
						p1.paint(g2);
						
						return Printable.PAGE_EXISTS;
						
						
						
					}
		        	
		        });
		        boolean ok = job.printDialog();
		        if(ok)
		        {
		        	try {
		        		job.print();
		        	}
		        	catch(PrinterException e1){
		        	}
		        }
				
			}
        	
        });
        
        frame1.add(print);
        

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
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Jaypass!123");

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

        p1.add(scroll , BorderLayout.NORTH);
        
        p1.add(scroll2 , BorderLayout.CENTER);

        frame1.setVisible(true);	

        frame1.setSize(1000 , 600);
        frame1.setLocationRelativeTo(null);
        
        
        
        

    }

 

    public static void main(String args[]) {

        
        

    }






	
}
