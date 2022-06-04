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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_3_CheckCart extends JFrame {

	private JPanel contentPane;
	

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_3_CheckCart frame = new GUI_3_CheckCart();
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
	public GUI_3_CheckCart() {
		setTitle("***** My Cart *****");
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
		
				
		JTextArea txtrTheDetailsOf = new JTextArea();
		txtrTheDetailsOf.setLineWrap(true);
		txtrTheDetailsOf.setText("the details of the order \nshould have been shown here.\nDatabase connection \nis needed.");
		txtrTheDetailsOf.setFont(new Font("Segoe Print", Font.BOLD, 16));
		txtrTheDetailsOf.setEditable(false);
		txtrTheDetailsOf.setBackground(Color.YELLOW);
		txtrTheDetailsOf.setBounds(100, 30, 240, 120);
		contentPane.add(txtrTheDetailsOf);
		
		JButton btnSetCT = new JButton("Yes, set customer type.");
		btnSetCT.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnSetCT.setBounds(120, 180, 200, 30);
		contentPane.add(btnSetCT);
		btnSetCT.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI_3_setCustomerType wp = new GUI_3_setCustomerType();
				wp.setVisible(true);				
			}
		});
		
		
		JButton btnYes = new JButton("Yes, make payment.");
		btnYes.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnYes.setBounds(120, 230, 200, 30);
		contentPane.add(btnYes);
		btnYes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Payment window will pop up.");				
			}
		});
		
		
		JButton btnNo = new JButton("No, edit order.");
		btnNo.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnNo.setBounds(120, 280, 200, 30);
		contentPane.add(btnNo);
		btnNo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"This action requires connection to database");
			}
		});
		
		
			
	}
	
}


