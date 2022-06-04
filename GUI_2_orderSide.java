package orderingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GUI_2_orderSide extends JFrame {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_2_orderSide frame = new GUI_2_orderSide();
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
	public GUI_2_orderSide() {
		setBackground(UIManager.getColor("Button.darkShadow"));
		setTitle("***** Order Side Option *****");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		setContentPane(contentPane);
		contentPane.setLayout(null);
					
		JLabel lblCT = new JLabel("Please select customer type:");
		lblCT.setFont(new Font("Segoe Print", Font.BOLD, 16));
		lblCT.setHorizontalAlignment(SwingConstants.CENTER);
		lblCT.setBounds(90, 60, 240, 30);
		contentPane.add(lblCT);
		
		
						
		JComboBox cbSO = new JComboBox();
		cbSO.setModel(new DefaultComboBoxModel(new String[] {"Pasta","Chicken Wings","Garlic Bread","Drinks"}));
		cbSO.setFont(new Font("Segoe Print", Font.BOLD, 14));
		cbSO.setBounds(130, 120, 160, 30);
		contentPane.add(cbSO);
		

		JComboBox cbAmount = new JComboBox();
		cbAmount.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		cbAmount.setFont(new Font("Segoe Print", Font.BOLD, 14));
		cbAmount.setBounds(130, 190, 160, 30);
		contentPane.add(cbAmount);


		
		
		JButton btnAddToCart = new JButton("Add to Cart");		
		btnAddToCart.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAddToCart.setBounds(70, 250, 120, 30);
		contentPane.add(btnAddToCart);
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("below item is added to cart:");
				JOptionPane.showMessageDialog(null, "Side Option below is added to cart:"
													+ "\n" + (String) cbSO.getSelectedItem() +													
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
