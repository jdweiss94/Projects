import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;

public class Project4 {

	private JFrame frmProject;
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
	public Project4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProject = new JFrame();
		frmProject.setTitle("Project 4");
		frmProject.setBounds(100, 100, 453, 408);
		frmProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProject.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(23, 11, 162, 98);
		frmProject.getContentPane().add(panel);
		
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
		frmProject.getContentPane().add(scrollPane);
		
		txtJobs = new JTextField();
		txtJobs.setBounds(308, 11, 86, 20);
		frmProject.getContentPane().add(txtJobs);
		txtJobs.setColumns(10);
		
		txtArrival = new JTextField();
		txtArrival.setBounds(308, 42, 86, 20);
		frmProject.getContentPane().add(txtArrival);
		txtArrival.setColumns(10);
		
		txtCPU = new JTextField();
		txtCPU.setBounds(308, 73, 86, 20);
		frmProject.getContentPane().add(txtCPU);
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
				if (rdbtnFcfs.isSelected()) 
				{
					output = output + "First Come First Serve:";
					FCFS fcfs = new FCFS();
					fcfs.fcfs(tasks);
				}

				else if (rdbtnSjn.isSelected()) 
				{
					output = output + "Shortest Job Remaining:";
					SJN sjn = new SJN();
					sjn.SJNrunner(tasks);
				}

				else if (rdbtnSrt.isSelected()) 
				{
					output = output + "Shortest Remaining Time:";
					SRT srt = new SRT();
					srt.SRTrunner(tasks);
				}

				else if (rdbtnRoundRobin.isSelected()) 
				{
					output = output + "Round Robin:";
					RoundRobin roro = new RoundRobin();
					roro.Robinrunner(tasks);
				}
				output = output + "\n Job \t Arrival \t CPU Cycle \t Wait Time \t Turn Around";
				output = output + "\n------------------------------------------------------------------------------------------------------------" ;
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
		frmProject.getContentPane().add(btnSubmit);
		
		JLabel lblJobs = new JLabel("Jobs");
		lblJobs.setBounds(195, 14, 46, 14);
		frmProject.getContentPane().add(lblJobs);
		
		JLabel lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setBounds(195, 45, 76, 14);
		frmProject.getContentPane().add(lblArrivalTime);
		
		JLabel lblCpuCycle = new JLabel("CPU Cycle");
		lblCpuCycle.setBounds(195, 76, 86, 14);
		frmProject.getContentPane().add(lblCpuCycle);
	}
}
