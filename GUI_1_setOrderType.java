package orderingSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_1_setOrderType extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_1_setOrderType frame = new GUI_1_setOrderType();
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
	public GUI_1_setOrderType() {
		setTitle("***** Order Type *****");
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
		
		
		JButton btnEatIn = new JButton("Eat-in");
		btnEatIn.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnEatIn.setBounds(150, 60, 120, 30);
		contentPane.add(btnEatIn);
		btnEatIn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"The order type is EAT-IN");
				dispose();
				GUI_2_setOrder wp = new GUI_2_setOrder();
				wp.setVisible(true);
				
			}
		});
		
		JButton btnTakeaway = new JButton("Take-Away");
		btnTakeaway.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnTakeaway.setBounds(150, 120, 120, 30);
		contentPane.add(btnTakeaway);
		btnTakeaway.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String inputputime = JOptionPane.showInputDialog(null, "How long (hour) are you expected to pick up? ");
				JOptionPane.showMessageDialog(null,"The order type is TAKE-AWAY. \nYou are expected to pick up you meal in " + inputputime + " hours.");
				dispose();
				GUI_2_setOrder wp = new GUI_2_setOrder();
				wp.setVisible(true);
			}
		});
		
		JButton btnDelivery = new JButton("Delivery");
		btnDelivery.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnDelivery.setBounds(150, 180, 120, 30);
		contentPane.add(btnDelivery);
		btnDelivery.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String inputputime = JOptionPane.showInputDialog(null, "How long (hour) are you expected to pick up? ");
				String pulocation = JOptionPane.showInputDialog(null, "Please enter your location: ");
				JOptionPane.showMessageDialog(null,"The order type is DELIVERY.\nYour location is "+ pulocation+" \nYour meal is expected to be delivered in " + inputputime + " hours."
						+ "\n(the distance is assumed less than 10KM)");
				//the distance is assumed less than 10KM
				dispose();
				GUI_2_setOrder wp = new GUI_2_setOrder();
				wp.setVisible(true);
			}
		});
		
	}
	
}


