package cas2xb3_finalprototype;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The purpose of this class is to provide the GUI for 
 * the NewSearch which searches for claim number inside of the 
 * luggage TSA dataset that determines locational information for lost luggage.
 * @author Group 11 - Software Engineering 2XB3. 
 *
 */
public class NewSearch extends JFrame {

	private JPanel contentPane;
	private JPanel rateroute;
	private JTextField textField_1;
	private LuggageT resultingLuggage;
	// private final Action action = new SwingAction();
	private String results;
	private String statement;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSearch frame = new NewSearch();
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
	public NewSearch() {
		// newsearch
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewSearch = new JLabel("New Search");
		lblNewSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewSearch.setBounds(146, 31, 121, 25);
		contentPane.add(lblNewSearch);

		JLabel lblNewLabel = new JLabel("Claim Number");
		lblNewLabel.setBounds(39, 75, 102, 20);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 72, 224, 26);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FileReading.luggage();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String ClaimNumber = textField_1.getText();
				Search test = new Search();
				try {
					resultingLuggage = Search.getLuggage(FileReading.luggage(),ClaimNumber);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (resultingLuggage == null) {
						statement = "Luggage not found.";
						textField.setText(statement);
					} else if (resultingLuggage.getKnownAirportName().equals("")){
						textField.setText("Luggage found, but no locational info could be uncovered!");
					}else {
						statement = "Luggage Found at ";
						results = resultingLuggage.getKnownAirportName();
						textField.setText(statement + results);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// btnNewButton.setAction(action);
		btnNewButton.setBounds(232, 123, 148, 67);
		contentPane.add(btnNewButton);

		JButton btnHome = new JButton("Rate My Route");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 RateMyRoute rate = new RateMyRoute();
				 rate.setVisible(true);

			}
		});
		btnHome.setBounds(38, 123, 179, 67);
		contentPane.add(btnHome);

		textField = new JTextField();
		textField.setBounds(39, 221, 341, 87);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblResults = new JLabel("Results:");
		lblResults.setBounds(39, 194, 56, 20);
		contentPane.add(lblResults);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
