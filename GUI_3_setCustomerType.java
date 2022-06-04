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

public class GUI_3_setCustomerType extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_3_setCustomerType frame = new GUI_3_setCustomerType();
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
	public GUI_3_setCustomerType() {
		setTitle("Set Customer Type");
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
				
		
		JLabel lblCT = new JLabel("Please select customer type:");
		lblCT.setFont(new Font("Segoe Print", Font.BOLD, 16));
		lblCT.setHorizontalAlignment(SwingConstants.CENTER);
		lblCT.setBounds(90, 60, 240, 30);
		contentPane.add(lblCT);
		
		
						
		JComboBox cbCT = new JComboBox();
		cbCT.setModel(new DefaultComboBoxModel(new String[] {"Student","member","staff","groupBooking","NA"}));
		cbCT.setFont(new Font("Segoe Print", Font.BOLD, 14));
		cbCT.setBounds(130, 120, 160, 30);
		contentPane.add(cbCT);
			
				
		JButton btncnf = new JButton("Confirm");		
		btncnf.setFont(new Font("SansSerif", Font.BOLD, 14));
		btncnf.setBounds(150, 180, 120, 30);
		contentPane.add(btncnf);
		btncnf.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String csmtype = (String) cbCT.getSelectedItem();
				if (!csmtype.equals("NA")) {
					String verified = JOptionPane.showInputDialog(null, "customer showed student card?"
																+ "\ncustomer showed Loyalty card?"
																+ "\ncustomer phone number matched?"
																+ "\ncustomer show employee discount card? "
																+ "\nY/N");
					if (!(verified.equals("y")||verified.equals("Y"))) {
						csmtype = "NA";
						JOptionPane.showMessageDialog(null,"Customer type is not verified!");
					}
				}
				JOptionPane.showMessageDialog(null,"The customer type is set to be " + csmtype.toUpperCase());
				
			}
		});
		
		
		JButton btnCheckCart = new JButton("Check My Cart");
		btnCheckCart.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnCheckCart.setBounds(120, 240, 180, 30);
		contentPane.add(btnCheckCart);
		btnCheckCart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI_3_CheckCart wp = new GUI_3_CheckCart();
				wp.setVisible(true);
				
			}
		});
		
	}
	
}
