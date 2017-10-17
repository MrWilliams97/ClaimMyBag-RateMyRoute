package cas2xb3_finalprototype;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

/**
 * The purpose of this is to provide the GUI for the 
 * RateMyRoute portion of the project that is connected by ClaimMyBag.java
 * to provide multiple choices of GUI for use by the user.
 * @author Group 11 - Software Engineering 2XB3
 *
 */
public class RateMyRoute extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RateMyRoute frame = new RateMyRoute();
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
	public RateMyRoute() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRateMyRoute = new JLabel("Rate My Route");
		lblRateMyRoute.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRateMyRoute.setBounds(120, 11, 158, 27);
		contentPane.add(lblRateMyRoute);

		JLabel lblStart = new JLabel("Departure");
		lblStart.setBounds(22, 83, 83, 14);
		contentPane.add(lblStart);

		JLabel lblArrival = new JLabel("Arrival");
		lblArrival.setBounds(40, 135, 65, 14);
		contentPane.add(lblArrival);

		textField = new JTextField();
		textField.setBounds(120, 80, 211, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 132, 211, 20);
		contentPane.add(textField_1);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(40, 179, 69, 20);
		contentPane.add(lblMonth);

		textField_2 = new JTextField();
		textField_2.setBounds(120, 176, 211, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(40, 318, 367, 269);
		contentPane.add(textArea);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Start = textField.getText();
				String End = textField_1.getText();
				int Month = Integer.parseInt(textField_2.getText());

				if (Month <= 0 || Month > 12) {
					textArea.setText("Invalid Month, try again");
				}
				else if (Start.length() < 3 || End.length() < 3){
					textArea.setText("The airport code is not long enough...try again!");
				} else {

					try {
						ArrayList<String> Finalresult = RateMyRouteFinal.totalOutput(Start, End, Month);
						String output = "";
						if(Finalresult == null){
							textArea.setText("One of the airport codes is invalid. \nMake sure you insert a proper one!");
						}
						else{
							for (String out : Finalresult) {
								output = output + "\n" + out;
							}
							textArea.setText(output);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnEnter.setBounds(208, 234, 146, 53);
		contentPane.add(btnEnter);

		JButton button = new JButton("Home");
		button.setBounds(60, 234, 146, 53);
		contentPane.add(button);

	}
}
