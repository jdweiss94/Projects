import java.util.ArrayList;
import java.util.Collections;

public class Algorithms {
	public void sjn(ArrayList<Solve> solutions)
	{
		
		int time = 0;
		
		Collections.sort(solutions);
		
		for (Solve jobs : solutions) {
			time = time + jobs.getCPUCycle();
			jobs.setTurnAround(jobs.getCPUCycle() - jobs.getArrival());
			jobs.setWaitTime(time);
			
		}
		
	}
	public void srt(ArrayList<Solve> solutions){
		Collections.sort(solutions);
		int time = 0;		
		
		for (Solve job : solutions) {
			time = time + job.getCPUCycle();
			job.setTurnAround(job.getCPUCycle() - job.getArrival());
			job.setWaitTime(time);
			
		}
		
	}
	public void roundrobin(ArrayList<Solve> solutions) 
	{
		int size = solutions.size();
		int placeHolder = 0;

		while (size > 0) 
		{
			for (Solve job : solutions) 
			{
				if (job.getCPUCycle() > 0) 
				{

					int value = job.getCPUCycle() - 4;
					if (value <= 0) 
					{
						placeHolder = placeHolder + job.getCPUCycle();
						job.setTurnAround(job.getCompletionTime());
						job.setCompletionTime(placeHolder - job.getArrival());
						job.setCPUCycle(0);
					} else 
					{
						placeHolder += 4;
						job.setCompletionTime(placeHolder);
						job.setCPUCycle(value);
						
					}
				} else 
				{
					size--;
				}
			}
		}
		
		for (Solve job : solutions) {
			job.setCPUCycle(job.getCompletionTime() + 1);
		}

	}
	/**
	 * Used to create a first come first serve solution
	 * @param solutions the arraylist of jobs
	 */
	public void fcfs(ArrayList<Solve> solutions)
		{
			//Variable used for keeping track of times
			int time = 0;
			//Iterate through each solution in the collection
			for (Solve job : solutions) 
			{
				job.setTurnAround(job.getCPUCycle() - job.getArrival());
				time = time + job.getCPUCycle();
				job.setWaitTime(time);
			}
		}
}
