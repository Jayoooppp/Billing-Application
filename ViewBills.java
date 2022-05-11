package biliapp;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewBills extends JFrame {
    private static String title = "View Bills";
    private static final int width = 800;
    private static final int height = 600;
	private Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Jaypass!123");
    private ArrayList<Bill> bills = new ArrayList<Bill>();
   
    

    public void setBills() throws SQLException {
    	
        Statement st = connection.createStatement();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        String getBillIds = "SELECT id FROM `bill`";
        ResultSet idRs = st.executeQuery(getBillIds);
        while (idRs.next()) {
            ids.add(idRs.getInt("id"));
        }
        for (Integer id : ids) {
            String getDetails = "select b.name, b.price, b.created_at, b.email, b.phone_number,\n" +
                    "       p.price, p.name, p.id,\n" +
                    "       o.quantity from bill b\n" +
                    "inner join `order` o on b.id = o.bill_id\n" +
                    "inner join product p on o.product_id = p.id\n" +
                    "where b.id = "+ id +";";
            System.out.println(getDetails);
            ResultSet billRes = st.executeQuery(getDetails);
            String name = "", email = "", phoneNumber = "", createdAt = "";
            int billId = 0;
            float price = 0;
            ArrayList<Product> products = new ArrayList<>();
            HashMap<Integer, Integer> quantity = new HashMap<>();
            while (billRes.next()) {
                name = billRes.getString("b.name");
                email = billRes.getString("email");
                phoneNumber = billRes.getString("phone_number");
                createdAt = billRes.getString("created_at");
                billId = billRes.getInt("id");
                price = billRes.getFloat("b.price");
                Product product = new Product(billRes.getInt("id"), billRes.getString("p.name"), billRes.getFloat("p.price"));
                products.add(product);
                quantity.put(product.getId(), billRes.getInt("quantity"));
            }
            Bill bill = new Bill(billId, price, name, email, phoneNumber, createdAt, products);
            bill.setQuantity(quantity);
            bills.add(bill);
        }
        st.close();
    }

    public void renderBill(Bill bill, int posX, int posY) {
    	 JSeparator s = new JSeparator();
        
        s.setOrientation(SwingConstants.HORIZONTAL);
        JLabel nameLabel = new JLabel(bill.getName());
        nameLabel.setBounds(posX, posY, 100, 40);
        nameLabel.setVisible(true);
        JLabel priceLabel = new JLabel(Float.toString(bill.getPrice()));
        priceLabel.setBounds(posX + 110, posY, 200, 40);
        priceLabel.setVisible(true);
        JLabel emailLabel = new JLabel(bill.getEmail());
        emailLabel.setBounds(posX + 320, posY, 200, 40);
        emailLabel.setVisible(true);
        JLabel phoneNumberLabel = new JLabel(bill.getPhoneNumber());
        phoneNumberLabel.setBounds(posX + 530, posY, 100, 40);
        phoneNumberLabel.setVisible(true);
        int _posY = posY + 50;
        for (Product product : bill.products) {
            JLabel pNameLabel = new JLabel(product.getName());
            pNameLabel.setBounds(posX + 110, _posY, 100, 40);
            pNameLabel.setVisible(true);
            JLabel pPriceLabel = new JLabel(Float.toString(product.getPrice()));
            pPriceLabel.setBounds(posX + 220, _posY, 100, 40);
            pPriceLabel.setVisible(true);
            JLabel pQuantityLabel = new JLabel(Integer.toString(bill.quantity.get(product.getId())));
            pQuantityLabel.setBounds(posX + 330, _posY, 100, 40);
            pQuantityLabel.setVisible(true);
            _posY += 50;
            add(pNameLabel);
            add(pPriceLabel);
            add(pQuantityLabel);
        }
        add(nameLabel);
        add(priceLabel);
        add(emailLabel);
        add(phoneNumberLabel);
        add(s);
    }

    public void generateBillInfo() {
        try {
            setBills();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int posX = 30, posY = 10;
        for (Bill bill : bills) {
            // TODO: Generate UI to render Bills
            renderBill(bill, posX, posY);
            posY += 250;
        }
    }

    public ViewBills() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        setBounds(0, 0, width, height);
        setTitle(title);
        setLayout(null);
        setVisible(true);
        generateBillInfo();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        try {
        	ViewBills bill = new ViewBills();
        	bill.add(pane);
        	bill.setLocationRelativeTo(null);
        	bill.setVisible(true);
        	JScrollPane scrollBar=new JScrollPane(bill,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        	bill.add(scrollBar);
        	
        	
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

