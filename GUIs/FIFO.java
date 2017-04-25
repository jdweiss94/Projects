import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FIFO {
	/**
	 * USed to implement first in first out algorithm
	 * @param frames number of frames in memory
	 * @param jobs arraylist of jobs
	 * @return output string
	 */
	public String startFIFO(int frames, ArrayList<String> jobs)
	{
		//Local variables
				String job;
				int miss = 0;
				int hit = 0;
				String hitOrMiss;
				String output = "";
				//Queue which holds what jobs are currently in memory
				Queue<String> firstin = new LinkedList<String>();
				//Removes erroneous job at beginning
						
				while(!jobs.isEmpty())
				{
					job = jobs.get(0);
					//Runs if the job is not in memory and memory is full
					if(!firstin.contains(job) && firstin.size() == frames)
					{
						firstin.poll();
						firstin.add(job);
						miss++;
						hitOrMiss = "Miss";
					}
					//Runs if the job is just not in memory
					else if(!firstin.contains(job))
					{
						firstin.add(job);
						miss++;
						hitOrMiss = "Miss";
					}
					//Runs if job is already in memory
					else
					{
						hit++;
						hitOrMiss = "Hit";
					}
					//Output of page tables
					output = output + "\n Page Requested: " + job;
					output = output + "\n ---------";
					//Temp array created to hold memory list for output
					ArrayList<String> temp = new ArrayList<String>();
					//Populating the temp array
					while(!firstin.isEmpty())
					{
						temp.add(firstin.poll());
					}
					//Outputting whats in memory
					
					for(int i = 0; i < temp.size(); i++)
					{
						output = output + "\n Page " + i + ": " + temp.get(i);
					}
					//Restoring the queue to previous state
					while(!temp.isEmpty())
					{
						firstin.add(temp.get(0));
						temp.remove(0);
					}
					output = output + "\n" + hitOrMiss + "\n";
					jobs.remove(0);
				}
				//Continuation of output
				output = output + "\n What is currently in cache: ";
				while(!firstin.isEmpty())
				{
					output = output + "\n" + firstin.poll() + " ";
				}
				output = output + "\n";
				//Formatting output for statistical evidence
				DecimalFormat df = new DecimalFormat("#.##");

				int total = hit + miss;
				double hitPercent = ((double) hit/ (double) total) * 100;
				double missPercent = ((double) miss/ (double) total) * 100;
				//Outputting how successful the algorithm was
				output = output + "\n Hits: " + hit + " " + df.format(hitPercent) + "%";
				output = output + "\n Misses: " + miss + " " + df.format(missPercent) + "%";
				//Closing the scanner
				return output;
	}
}
