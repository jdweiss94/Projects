import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PageRemoval 
{
	/**
	 * Main method for pageremoval class
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		int frames;
		ArrayList<String> jobs = new ArrayList<String>();
		String input;
		Scanner scan = new Scanner(System.in);
		System.out.println("How many page frames are you using?");
		frames = scan.nextInt();
		System.out.println("Please enter your jobs and type done when you are finished.");
		while(true)
		{
			input = scan.nextLine();
			if(input.equalsIgnoreCase("done"))
			{
				break;
			}
			else
			{
				jobs.add(input);
			}
		}
		ArrayList<String> jobs2 = (ArrayList<String>) jobs.clone();
		
		fifo(frames, jobs);
		System.out.println("-----------------------");
		lru(frames, jobs2);
		
		scan.close();
	}
	/**
	 * Method used to implement fifo algorithm
	 * @param frames number of frames in memory
	 * @param jobs list of jobs coming into memory
	 */
	public static void fifo(int frames, ArrayList<String> jobs)
	{
		//Local variables
		String job;
		int miss = 0;
		int hit = 0;
		String hitOrMiss;
		//Queue which holds what jobs are currently in memory
		Queue<String> firstin = new LinkedList<String>();
		Scanner scan = new Scanner(System.in);
		//Removes erroneous job at beginning
		jobs.remove(0);
		
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
			System.out.println("Page Requested: " + job);
			System.out.println("---------");
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
				System.out.println("Page: " + i + " " + temp.get(i));
			}
			//Restoring the queue to previous state
			while(!temp.isEmpty())
			{
				firstin.add(temp.get(0));
				temp.remove(0);
			}
			System.out.println(hitOrMiss);
			System.out.println("");
			jobs.remove(0);
		}
		//Continuation of output
		System.out.println("FIFO");
		System.out.print("What is currently in cache: ");
		while(!firstin.isEmpty())
		{
			System.out.print(firstin.poll() + " ");
		}
		System.out.println("");
		//Formatting output for statistical evidence
		DecimalFormat df = new DecimalFormat("#.##");

		int total = hit + miss;
		double hitPercent = ((double) hit/ (double) total) * 100;
		double missPercent = ((double) miss/ (double) total) * 100;
		//Outputting how successful the algorithm was
		System.out.println("Hits: " + hit + " " + df.format(hitPercent) + "%");
		System.out.println("Misses: " + miss + " " + df.format(missPercent) + "%");
		//Closing the scanner
		scan.close();
	}
	/**
	 * Method used to implement lru algorithm
	 * @param frames number of frames in memory
	 * @param jobs list of jobs coming into memory
	 */
	public static void lru(int frames, ArrayList<String> jobs)
	{
		//Local variables
		String job;
		int miss = 0;
		int hit = 0;
		String hitOrMiss;
		//Linkedlist which holds jobs in memory
		LinkedList<String> leastrecent = new LinkedList<String>();
		Scanner scan = new Scanner(System.in);
		//Removes erroneous job at beginning
		jobs.remove(0);
		
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
			System.out.println("Page Requested: " + job);
			System.out.println("---------");
			//Runs through linkedlist to outputt memory
			for(int i = 0; i < leastrecent.size(); i++)
			{
				System.out.println("Page: " + i + " " + leastrecent.get(i));
			}

			System.out.println(hitOrMiss);
			System.out.println("");
			jobs.remove(0);
		}
		//Continuation of memory
		System.out.println("LRU");
		System.out.print("What is currently in cache: ");
		while(!leastrecent.isEmpty())
		{
			System.out.print(leastrecent.poll() + " ");
		}
		System.out.println("");
		//Formatting output for statistical evidence
		DecimalFormat df = new DecimalFormat("#.##");
		
		int total = hit + miss;
		double hitPercent = ((double) hit/ (double) total) * 100;
		double missPercent = ((double) miss/ (double) total) * 100;
		
		System.out.println("Hits: " + hit + " " + df.format(hitPercent) + "%");
		System.out.println("Misses: " + miss + " " + df.format(missPercent) + "%");
		//Closing the scanner
		scan.close();
	}
}
