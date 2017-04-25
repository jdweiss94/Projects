import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;

public class LRU {
	public String startLRU(int frames, ArrayList<String> jobs)
	{
		//Local variables
				String job;
				int miss = 0;
				int hit = 0;
				String hitOrMiss;
				String output = "";
				//Linkedlist which holds jobs in memory
				LinkedList<String> leastrecent = new LinkedList<String>();
				//Removes erroneous job at beginning
				
				while(!jobs.isEmpty())
				{
					job = jobs.get(0);
					//Runs if the job is not in memory and memory is full
					if(!leastrecent.contains(job) && leastrecent.size() == frames)
					{
						leastrecent.pollLast();
						leastrecent.addFirst(job);
						miss++;
						hitOrMiss = "Miss";
					}
					//Runs if the job is just not in memory
					else if(!leastrecent.contains(job))
					{
						leastrecent.addFirst(job);
						miss++;
						hitOrMiss = "Miss";
					}
					//Runs if the job is in memory and sets it to the front
					else if(leastrecent.contains(job))
					{
						leastrecent.remove(job);
						leastrecent.addFirst(job);
						hit++;
						hitOrMiss = "Hit";
					}
					else
					{
						hit++;
						hitOrMiss = "Hit";
					}
					//Output of page tables
					output = output + "\n Page Requested: " + job;
					output = output + "\n ---------";
					//Runs through linkedlist to outputt memory
					for(int i = 0; i < leastrecent.size(); i++)
					{
						output = output + "\n Page: " + i + " " + leastrecent.get(i);
					}

					output = output + "\n" + hitOrMiss + "\n";
					jobs.remove(0);
				}
				//Continuation of memory
				output = output + "\n What is currently in cache: ";
				while(!leastrecent.isEmpty())
				{
					output = output + "\n" + leastrecent.poll() + " ";
				}
				output = output + "\n";
				//Formatting output for statistical evidence
				DecimalFormat df = new DecimalFormat("#.##");
				
				int total = hit + miss;
				double hitPercent = ((double) hit/ (double) total) * 100;
				double missPercent = ((double) miss/ (double) total) * 100;
				
				output = output + "\n Hits: " + hit + " " + df.format(hitPercent) + "%";
				output = output + "\n Misses: " + miss + " " + df.format(missPercent) + "%";
				return output;
		}
}
