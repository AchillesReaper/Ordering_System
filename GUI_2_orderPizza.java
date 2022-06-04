package orderingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GUI_2_orderPizza extends JFrame {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_2_orderPizza frame = new GUI_2_orderPizza();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_2_orderPizza() {
		setBackground(UIManager.getColor("Button.darkShadow"));
		setTitle("Order Pizza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		setContentPane(contentPane);
		contentPane.setLayout(null);
					
		
		JLabel lblBase = new JLabel("Base:");
		lblBase.setFont(new Font("Segoe Print", Font.BOLD, 16));
		lblBase.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBase.setBounds(30, 30, 80, 30);
		contentPane.add(lblBase);
		
		JLabel lblTopping = new JLabel("Topping:");
		lblTopping.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTopping.setFont(new Font("Segoe Print", Font.BOLD, 16));
		lblTopping.setBounds(30, 70, 80, 30);
		contentPane.add(lblTopping);
		
		JLabel lblSauce = new JLabel("Sauce:");
		lblSauce.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSauce.setFont(new Font("Segoe Print", Font.BOLD, 16));
		lblSauce.setBounds(30, 110, 80, 30);
		contentPane.add(lblSauce);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSize.setFont(new Font("Segoe Print", Font.BOLD, 16));
		lblSize.setBounds(30, 150, 80, 30);
		contentPane.add(lblSize);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setFont(new Font("Segoe Print", Font.BOLD, 16));
		lblAmount.setBounds(30, 190, 80, 30);
		contentPane.add(lblAmount);
						
		JComboBox cbBase = new JComboBox();
		cbBase.setModel(new DefaultComboBoxModel(new String[] {"Traditional", "Wholemeal", "GlutenFree"}));
		cbBase.setFont(new Font("Segoe Print", Font.BOLD, 14));
		cbBase.setBounds(150, 30, 160, 30);
		contentPane.add(cbBase);
		
		JComboBox cbTopping = new JComboBox();
		cbTopping.setModel(new DefaultComboBoxModel(new String[] {"Supreme", "SausageSizzle", "Hawaiin", "Chicken", "VeggieLovers"}));
		cbTopping.setFont(new Font("Segoe Print", Font.BOLD, 14));
		cbTopping.setBounds(150, 70, 160, 30);
		contentPane.add(cbTopping);
		
		JComboBox cbSauce = new JComboBox();
		cbSauce.setModel(new DefaultComboBoxModel(new String[] {"Tomato", "BBQ"}));
		cbSauce.setFont(new Font("Segoe Print", Font.BOLD, 14));
		cbSauce.setBounds(150, 110, 160, 30);
		contentPane.add(cbSauce);
		
		
		JComboBox cbSize = new JComboBox();
		cbSize.setModel(new DefaultComboBoxModel(new String[] {"Small", "Medium", "Large"}));
		cbSize.setFont(new Font("Segoe Print", Font.BOLD, 14));
		cbSize.setBounds(150, 150, 160, 30);
		contentPane.add(cbSize);
		

		JComboBox cbAmount = new JComboBox();
		cbAmount.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		cbAmount.setFont(new Font("Segoe Print", Font.BOLD, 14));
		cbAmount.setBounds(150, 190, 160, 30);
		contentPane.add(cbAmount);
		
		
		JButton btnAddToCart = new JButton("Add to Cart");		
		btnAddToCart.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAddToCart.setBounds(70, 250, 120, 30);
		contentPane.add(btnAddToCart);
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("below item is added to cart:");
				JOptionPane.showMessageDialog(null, "Pizza below is added to cart:\n" + 
													"\nBase: " + (String) cbBase.getSelectedItem()+
													"\nTopping: " + (String) cbTopping.getSelectedItem()+
													"\nSauce: " + (String) cbSauce.getSelectedItem()+
													"\nSize: " + (String) cbSize.getSelectedItem()+
													"\nAmount: " + (String) cbAmount.getSelectedItem());												
				dispose();
				GUI_2_setOrder wp = new GUI_2_setOrder();
				wp.setVisible(true);
			}
		});
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancel.setBounds(224, 250, 120, 30);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI_2_setOrder wp = new GUI_2_setOrder();
				wp.setVisible(true);
			}
		});	
				
	}
	
}
