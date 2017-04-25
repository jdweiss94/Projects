import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;

public class Project4 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtJobs;
	private JTextField txtArrival;
	private JTextField txtCPU;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project4 window = new Project4();
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
	public Project4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(23, 11, 162, 98);
		frame.getContentPane().add(panel);
		
		JLabel lblSelectYourAlgorithm = new JLabel("Select Your Algorithm");
		panel.add(lblSelectYourAlgorithm);
		
		JRadioButton rdbtnFcfs = new JRadioButton("FCFS");
		rdbtnFcfs.setSelected(true);
		buttonGroup.add(rdbtnFcfs);
		panel.add(rdbtnFcfs);
		
		JRadioButton rdbtnSrt = new JRadioButton("SRT");
		buttonGroup.add(rdbtnSrt);
		panel.add(rdbtnSrt);
		
		JRadioButton rdbtnSjn = new JRadioButton("SJN");
		buttonGroup.add(rdbtnSjn);
		panel.add(rdbtnSjn);
		
		JRadioButton rdbtnRoundRobin = new JRadioButton("Round Robin");
		buttonGroup.add(rdbtnRoundRobin);
		panel.add(rdbtnRoundRobin);
		JTextArea txtSolution = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(txtSolution);
		scrollPane.setBounds(10, 120, 417, 215);
		frame.getContentPane().add(scrollPane);
		
		txtJobs = new JTextField();
		txtJobs.setBounds(308, 11, 86, 20);
		frame.getContentPane().add(txtJobs);
		txtJobs.setColumns(10);
		
		txtArrival = new JTextField();
		txtArrival.setBounds(308, 42, 86, 20);
		frame.getContentPane().add(txtArrival);
		txtArrival.setColumns(10);
		
		txtCPU = new JTextField();
		txtCPU.setBounds(308, 73, 86, 20);
		frame.getContentPane().add(txtCPU);
		txtCPU.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "";
				ArrayList<Solve> tasks = new ArrayList<Solve>();
				double turnAround = 0;
				double waitTime = 0;
				
				String[] jobs = txtJobs.getText().split(" ");
				String[] arrivalTime = txtArrival.getText().split(" ");
				String[] cpuCycle = txtCPU.getText().split(" ");
				int[] arrivalInts = new int[arrivalTime.length];
				int[] cpuCycleInts = new int[cpuCycle.length];
				for(int i = 0; i< jobs.length; i++)
				{
					arrivalInts[i] = Integer.parseInt(arrivalTime[i]);
					cpuCycleInts[i] = Integer.parseInt(cpuCycle[i]);
					tasks.add(new Solve(jobs[i], arrivalInts[i], cpuCycleInts[i], 0, 0, 0));
				}
				System.out.println("Hey");
				if (rdbtnFcfs.isSelected()) 
				{
					FCFS fcfs = new FCFS();
					fcfs.FCFSrunner(tasks);
				}

				else if (rdbtnSjn.isSelected()) 
				{
					SJN sjn = new SJN();
					sjn.SJNrunner(tasks);
				}

				else if (rdbtnSrt.isSelected()) 
				{
					SRT srt = new SRT();
					srt.SRTrunner(tasks);
				}

				else if (rdbtnRoundRobin.isSelected()) 
				{
					RoundRobin roro = new RoundRobin();
					roro.Robinrunner(tasks);
				}
				output = output + "\n Job \t Arrival \t CPU Cycle \t Wait Time \t Turn Around";
				output = output + "\n----------------------------------------------------------------------------------" ;
				for (Solve temp : tasks) 
				{
					output = output + "\n" + temp;
					turnAround = turnAround + temp.getTurnAround();
					waitTime = waitTime + temp.getWaitTime();
				}
				output = output + "\n Average Turn Around: " + turnAround / jobs.length;
				output = output + "\n Average Wait Time: " + waitTime / jobs.length;
				txtSolution.setText(output);
				}
		});
		btnSubmit.setBounds(170, 346, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblJobs = new JLabel("Jobs");
		lblJobs.setBounds(195, 14, 46, 14);
		frame.getContentPane().add(lblJobs);
		
		JLabel lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setBounds(195, 45, 76, 14);
		frame.getContentPane().add(lblArrivalTime);
		
		JLabel lblCpuCycle = new JLabel("CPU Cycle");
		lblCpuCycle.setBounds(195, 76, 86, 14);
		frame.getContentPane().add(lblCpuCycle);
	}
}
