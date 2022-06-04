package orderingSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_2_setOrder extends JFrame {

	private JPanel contentPane;
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_2_setOrder frame = new GUI_2_setOrder();
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
	public GUI_2_setOrder() {
		setTitle("***** Set Order *****");
		setBackground(new Color(238, 232, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 280);
		setSize(420,360);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOrderPizza = new JButton("Order Pizza");
		btnOrderPizza.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnOrderPizza.setBounds(150, 60, 120, 30);
		contentPane.add(btnOrderPizza);
		btnOrderPizza.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI_2_orderPizza wp = new GUI_2_orderPizza();
				wp.setVisible(true);
				
			}
		});
		
		
		JButton btnOrderSide = new JButton("Order Side Options");
		btnOrderSide.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnOrderSide.setBounds(120, 120, 180, 30);
		contentPane.add(btnOrderSide);
		btnOrderSide.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI_2_orderSide ws = new GUI_2_orderSide();
				ws.setVisible(true);
			}
		});
		
		JButton btnCheckCart = new JButton("Check My Cart");
		btnCheckCart.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnCheckCart.setBounds(120, 180, 180, 30);
		contentPane.add(btnCheckCart);
		btnCheckCart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI_3_CheckCart wp = new GUI_3_CheckCart();
				wp.setVisible(true);
				
			}
		});
		
		
		
		JButton btnCnl = new JButton("cancel");
		btnCnl.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnCnl.setBounds(150, 240, 120, 30);
		contentPane.add(btnCnl);
		btnCnl.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI_1_setOrderType wm = new GUI_1_setOrderType();
				wm.setVisible(true);
				 
			}
		});
		
	}
	
}


