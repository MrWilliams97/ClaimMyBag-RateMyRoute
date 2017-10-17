package cas2xb3_finalprototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class connects the two GUIs of RateMyRoute and NewSearch
 * by providing two buttons that will take the user to either one of the user interfaces.
 * The two user interfaces contain the requirements of the project.
 * @author Group 11 - Software Engineering 2XB3 
 *
 */
public class ClaimMyBag {

	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClaimMyBag window = new ClaimMyBag();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClaimMyBag() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 420, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblClaimMyBag = new JLabel("CLAIM MY BAG LOGO GOES HERE");
		lblClaimMyBag.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClaimMyBag.setBounds(19, 84, 370, 44);
		frame.getContentPane().add(lblClaimMyBag);
		
		JButton btnNewButton = new JButton("New Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				NewSearch newsearch = new NewSearch();
				newsearch.setVisible(true);
			}
		});
		btnNewButton.setBounds(80, 202, 230, 75);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rate My Route");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RateMyRoute ratemyroute = new RateMyRoute();
				ratemyroute.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(80, 288, 230, 75);
		frame.getContentPane().add(btnNewButton_1);
	}
}
