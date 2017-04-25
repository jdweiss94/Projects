import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class Project3 {
	public JFrame frmProject;
	public JTextField jobstxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project3 window = new Project3();
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
	public Project3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		FIFO fifo = new FIFO();
		LRU lru = new LRU();
		
		frmProject = new JFrame();
		frmProject.setTitle("Project 3");
		frmProject.setBounds(100, 100, 578, 406);
		frmProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProject.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start Test");
		
		JTextArea fifoTextArea = new JTextArea();
		fifoTextArea.setLineWrap(true);
		fifoTextArea.setWrapStyleWord(true);
		fifoTextArea.setBounds(104, 67, 53, 41);
		frmProject.getContentPane().add(fifoTextArea);
		
		JScrollPane pane = new JScrollPane(fifoTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setBounds(27, 126, 182, 199);
		frmProject.getContentPane().add(pane);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setMaximum(10);
		slider.setMinimum(1);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setBounds(41, 40, 200, 45);
		frmProject.getContentPane().add(slider);
		
		jobstxt = new JTextField();
		jobstxt.setBounds(369, 40, 152, 23);
		frmProject.getContentPane().add(jobstxt);
		jobstxt.setColumns(10);
		
		JLabel lblframes = new JLabel("How Many Frames Do You Want?");
		lblframes.setBounds(41, 11, 200, 14);
		frmProject.getContentPane().add(lblframes);
		
		JLabel lblProcesess = new JLabel("Please List The Processes");
		lblProcesess.setBounds(369, 15, 152, 14);
		frmProject.getContentPane().add(lblProcesess);
		
		JLabel lblFifo = new JLabel("FIFO");
		lblFifo.setBounds(83, 101, 80, 14);
		frmProject.getContentPane().add(lblFifo);
		
		JScrollPane scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(334, 126, 182, 199);
		frmProject.getContentPane().add(scrollPane);
		
		JTextArea lruTextArea = new JTextArea();
		lruTextArea.setWrapStyleWord(true);
		lruTextArea.setLineWrap(true);
		scrollPane.setViewportView(lruTextArea);
		
		JLabel lblLru = new JLabel("LRU");
		lblLru.setBounds(386, 101, 80, 14);
		frmProject.getContentPane().add(lblLru);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int frames = slider.getValue();
				String tempJobs = jobstxt.getText();
				ArrayList<String> jobs = new ArrayList<String>();
				for(int i = 0; i < tempJobs.length(); i++)
				{
					jobs.add(String.valueOf(tempJobs.charAt(i)));
				}
				@SuppressWarnings("unchecked")
				ArrayList<String> jobs2 = (ArrayList<String>) jobs.clone();
				fifoTextArea.setText(fifo.startFIFO(frames, jobs));
				lruTextArea.setText(lru.startLRU(frames, jobs2));
			}
		});
		btnNewButton.setBounds(223, 336, 117, 23);
		frmProject.getContentPane().add(btnNewButton);
		
		
		
		
		
		
	}
}
