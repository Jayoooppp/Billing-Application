package biliapp;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.*;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
public class Check {
	public static void main(String arg[]) {
		new Check();
	}
	
	JFrame j;
	int x1,y1,y2,x2;
//	ArrayList<Object> arr
//    = new ArrayList<Object>(8);
	HashMap<JButton,JLabel[]> map = new HashMap<>();
//	Multimap<JButton, JLabel> map = ArrayListMultimap.create();


	
	public Check()
	{
		
		j = new JFrame("Sample");
		
		j.setVisible(true);
//		((Window) arr.get(0)).setVisible(false);
		
		
		
		
		j.setSize(800,800);
		j.getContentPane().setLayout(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblProduct = new JLabel("Product:");
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
		lblProduct.setBounds(71, 297, 91, 23);
		j.getContentPane().add(lblProduct);
		
				
		
		JTextField textField_2 = new JTextField();
		textField_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_2.setToolTipText("Product Name");
		textField_2.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(163, 300, 196, 25);
		j.getContentPane().add(textField_2);
		
		

		
		 x1=163;
		 y1=300;
		
		 JTextField textField_3 = new JTextField();
		textField_3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_3.setToolTipText("Price");
		textField_3.setFont(new Font("Myanmar Text", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBounds(404, 300, 196, 25);
		j.getContentPane().add(textField_3);
		x2 = 404 ;
		y2 = 300;
		
		JLabel lblRs = new JLabel("Rs:");
		lblRs.setHorizontalAlignment(SwingConstants.CENTER);
		lblRs.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
		lblRs.setBounds(369, 297, 34, 23);
		j.getContentPane().add(lblRs);
		
		JTextField t4 = new JTextField();
		JButton btnAdd = new JButton("ADD");
		btnAdd.setToolTipText("Add product");
		int count = 0;		
		


		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				String product = textField_2.getText();
				String price   = textField_3.getText();
				JLabel l1 = new JLabel();
				JLabel l2 = new JLabel();
				l1.setText(product);
				l2.setText(price);
				y1 += 31;
				y2 += 32;
				l1.setBounds(x1, y1, 50,50 );
				l2.setBounds(x2, y2, 50,50);
				j.getContentPane().add(l1);
				j.getContentPane().add(l2);
				textField_2.setText("");
				textField_3.setText("");
				
				j.revalidate();
	            j.repaint();

				
				
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(631, 301, 89, 23);
		j.getContentPane().add(btnAdd); 
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setFont(new Font("Candara", Font.BOLD, 18));
		btnNewButton.setBounds(226, 658, 81, 26);
		
		JLabel arr[] = new JLabel[2];
//		arr[0] = lblRs;
//		arr[1] = lblProduct;
//		
		map.put(btnNewButton, new JLabel[] {lblRs,lblProduct});
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
//				Map.Entry<JLabel,JTextField> entry = map.entrySet().iterator().next();
//				JLabel o1 = entry.getKey();
//				JTextField o2 = entry.getValue();
//				o1.setText("hkglhsgh");
				
				
				String ans = t4.getText();
				System.out.println(ans);
				
			}
			
		});
		j.getContentPane().add(btnNewButton);
		DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
	      JFormattedTextField today = new JFormattedTextField(dateFormat);
	      today.setName("Today");
	      today.setColumns(10);
	      today.setEditable(false);
	      today.setValue(new Date());
	      today.setBounds(226, 500, 81, 26);
	      today.setEditable(true);
	      j.add(today);	
	      
//	      map.put(btnNewButton, lblRs);
//	      map.put(btnNewButton, lblProduct);
//	      HashSet<JLabel> ans = new HashSet<JLabel>();
//	       ans = (HashSet<JLabel>) map.get(btnNewButton);
	      
	
	      
	      
	      
	      
		
		
	}
}
