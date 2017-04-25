import java.util.ArrayList;
public class FCFS 
{
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
