import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Project2 {

	private JFrame frmProject;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtJobs;
	private JTextField txtPartitions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project2 window = new Project2();
					window.frmProject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Project2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProject = new JFrame();
		frmProject.setTitle("Project 2");
		frmProject.setBounds(100, 100, 621, 478);
		frmProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProject.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 11, 144, 58);
		frmProject.getContentPane().add(panel);
		
		JLabel lblChooseTypeOf = new JLabel("Choose Type of Memory");
		panel.add(lblChooseTypeOf);
		
		JRadioButton rdbtnDynamic = new JRadioButton("Dynamic");
		rdbtnDynamic.setSelected(true);
		buttonGroup.add(rdbtnDynamic);
		panel.add(rdbtnDynamic);
		
		JRadioButton rdbtnFixed = new JRadioButton("Fixed");
		buttonGroup.add(rdbtnFixed);
		panel.add(rdbtnFixed);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(393, 11, 151, 80);
		frmProject.getContentPane().add(panel_1);
		
		JLabel lblChooseAlgorithm = new JLabel("Choose Algorithm");
		panel_1.add(lblChooseAlgorithm);
		
		JRadioButton rdbtnFirstfit = new JRadioButton("FirstFit");
		rdbtnFirstfit.setSelected(true);
		buttonGroup_1.add(rdbtnFirstfit);
		panel_1.add(rdbtnFirstfit);
		
		JRadioButton rdbtnBestfit = new JRadioButton("BestFit");
		buttonGroup_1.add(rdbtnBestfit);
		panel_1.add(rdbtnBestfit);
		
		JRadioButton rdbtnNextfit = new JRadioButton("NextFit");
		buttonGroup_1.add(rdbtnNextfit);
		panel_1.add(rdbtnNextfit);
		
		JRadioButton rdbtnWorstfit = new JRadioButton("WorstFit");
		buttonGroup_1.add(rdbtnWorstfit);
		panel_1.add(rdbtnWorstfit);
		
		JSpinner spinnerJobs = new JSpinner();
		spinnerJobs.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerJobs.setBounds(515, 97, 29, 20);
		frmProject.getContentPane().add(spinnerJobs);
		
		JSpinner spinnerPartitions = new JSpinner();
		spinnerPartitions.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerPartitions.setBounds(173, 97, 29, 20);
		frmProject.getContentPane().add(spinnerPartitions);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(28, 181, 516, 214);
		frmProject.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		txtPartitions = new JTextField();
		txtPartitions.setColumns(10);
		txtPartitions.setBounds(28, 150, 174, 20);
		frmProject.getContentPane().add(txtPartitions);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fixed fixed = new Fixed();
				
				String[] tempJobs = new String[(int) spinnerJobs.getValue()];
				tempJobs = txtJobs.getText().split(" ");
				int[] jobs = new int[tempJobs.length];
				for(int i = 0; i < tempJobs.length; i++)
				{
					jobs[i] = Integer.parseInt(tempJobs[i]);
				}
				
				String[] tempPartitions = new String[(int) spinnerPartitions.getValue()];
				tempPartitions = txtPartitions.getText().split(" ");
				int[] partitions = new int[tempPartitions.length];
				for(int i = 0; i < tempPartitions.length; i++)
				{
					partitions[i] = Integer.parseInt(tempPartitions[i]);
				}
				
				if(rdbtnDynamic.isSelected())
				{
					if(rdbtnFirstfit.isSelected())
					{
						textArea.setText(fixed.firstFit(partitions, jobs));
					}
					else if(rdbtnBestfit.isSelected())
					{
						textArea.setText(fixed.bestFit(partitions, jobs));
					}
					else if(rdbtnNextfit.isSelected())
					{
						textArea.setText(fixed.nextFit(partitions, jobs));
					}
					else if(rdbtnWorstfit.isSelected())
					{
						textArea.setText(fixed.worstFit(partitions, jobs));
					}
				}
				else
				{
					if(rdbtnFirstfit.isSelected())
					{
						textArea.setText(fixed.firstFit(partitions, jobs));
					}
					else if(rdbtnBestfit.isSelected())
					{
						textArea.setText(fixed.bestFit(partitions, jobs));
					}
					else if(rdbtnNextfit.isSelected())
					{
						textArea.setText(fixed.nextFit(partitions, jobs));
					}
					else if(rdbtnWorstfit.isSelected())
					{
						textArea.setText(fixed.worstFit(partitions, jobs));
					}
				}
			}
		});
		btnStart.setBounds(251, 406, 89, 23);
		frmProject.getContentPane().add(btnStart);
		
		
		
		JLabel lblNumberOfPartitions = new JLabel("Number of Partitions");
		lblNumberOfPartitions.setBounds(28, 100, 134, 14);
		frmProject.getContentPane().add(lblNumberOfPartitions);
		
		JLabel lblListJobSizes = new JLabel("List Job Sizes Seperated by Space");
		lblListJobSizes.setBounds(370, 125, 272, 14);
		frmProject.getContentPane().add(lblListJobSizes);
		
		txtJobs = new JTextField();
		txtJobs.setBounds(370, 150, 174, 20);
		frmProject.getContentPane().add(txtJobs);
		txtJobs.setColumns(10);
		
		
		
		JLabel lblNumberOfJobs = new JLabel("Number of Jobs");
		lblNumberOfJobs.setBounds(370, 100, 134, 14);
		frmProject.getContentPane().add(lblNumberOfJobs);
		
		JLabel label = new JLabel("List Partition Sizes Seperated by Space");
		label.setBounds(28, 125, 257, 14);
		frmProject.getContentPane().add(label);
		
		
		
		
	}
}
