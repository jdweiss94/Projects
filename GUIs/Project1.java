import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Project1 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtExpression;
	private JTextField txtAnswer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project1 window = new Project1();
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
	public Project1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 398, 179);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 171, 78);
		frame.getContentPane().add(panel);
		
		JLabel lblSelectAnExpression = new JLabel("Select An Expression Type");
		panel.add(lblSelectAnExpression);
		
		JRadioButton rdbtnPrefix = new JRadioButton("Prefix");
		rdbtnPrefix.setSelected(true);
		buttonGroup.add(rdbtnPrefix);
		panel.add(rdbtnPrefix);
		
		JRadioButton rdbtnInfix = new JRadioButton("Infix");
		buttonGroup.add(rdbtnInfix);
		panel.add(rdbtnInfix);
		
		JRadioButton rdbtnPostifx = new JRadioButton("Postifx");
		buttonGroup.add(rdbtnPostifx);
		panel.add(rdbtnPostifx);
		
		txtExpression = new JTextField();
		txtExpression.setBounds(191, 36, 181, 20);
		frame.getContentPane().add(txtExpression);
		txtExpression.setColumns(10);
		
		JLabel lblPleaseEnterThe = new JLabel("Enter the Expression to Evaluate");
		lblPleaseEnterThe.setBounds(191, 11, 199, 14);
		frame.getContentPane().add(lblPleaseEnterThe);
		
		txtAnswer = new JTextField();
		txtAnswer.setEditable(false);
		txtAnswer.setBounds(191, 103, 181, 20);
		frame.getContentPane().add(txtAnswer);
		txtAnswer.setColumns(10);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(191, 78, 46, 14);
		frame.getContentPane().add(lblAnswer);
		
		Prefix prefix = new Prefix();
		Infix infix = new Infix();
		Postfix postfix = new Postfix();
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPrefix.isSelected())
				{
					String[] input = new String[txtExpression.getText().length()];
					input = txtExpression.getText().split(" ");
					txtAnswer.setText(String.valueOf(prefix.startPrefix(input)));
				}
				else if(rdbtnInfix.isSelected())
				{
					txtAnswer.setText(infix.startInfix(txtExpression.getText()));
				}
				else if(rdbtnPostifx.isSelected())
				{
					txtAnswer.setText(String.valueOf(postfix.startPostfix(txtExpression.getText())));
				}
			}
		});
		btnSubmit.setBounds(33, 100, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}

}
