import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class MemoryAllocationScheme {
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("How many partitions do you want?");
		int n = scan.nextInt();
		
		System.out.println("Please list partition sizes.");
		int[] partitions = new int[n];
		for(int i = 0; i < n; i++)
		{
			partitions[i] = scan.nextInt();
		}
		
		System.out.println("How many jobs will there be?");
		int m = scan.nextInt();
		int[] jobs = new int[m];
		
		System.out.println("Please list job sizes.");
		for(int j = 0; j < m; j++)
		{
			jobs[j] = scan.nextInt();
		}
		
		System.out.println("FirstFit, BestFit, NextFit or WorstFit?");
		String input = scan.next();
		if(input.equalsIgnoreCase("firstfit"))
		{
			firstFit(partitions, jobs);
		}
		else if(input.equalsIgnoreCase("bestfit"))
		{
			bestFit(partitions, jobs);
		}
		else if(input.equalsIgnoreCase("nextfit"))
		{
			nextFit(partitions, jobs);
		}
		else if(input.equalsIgnoreCase("worstfit"))
		{
			worstFit(partitions, jobs);
		}
		scan.close();
		
	}
	public static void firstFit(int[] free, int[] jobs)
	{
		int[] partitions = new int[free.length];
		for(int i = 0; i < free.length; i++)
		{
			partitions[i] = free[i];
		}
		HashMap<Integer, Integer> busy = new HashMap<Integer, Integer>();
		int fragmentation = 0;
		
		for(int i = 0; i < jobs.length; i ++)
		{
			
			for(int z = 0; z < free.length; z++)
			{
				if(free[z] >= jobs[i])
				{
					fragmentation = fragmentation + (free[z] - jobs[i]);
					busy.put(free[z], jobs[i]);
					//System.out.println("Job " + i + " arrives.");
					free[z] = 0;
					break;
				}
			}
		}
		System.out.println("Partition Size \t Memory Address \t Access \t Partition Status");
		System.out.println("-----------------------------------------------------------------------------");
		int memoryAddress = 0;
		for(int i = 0; i < free.length; i++)
		{
			memoryAddress = memoryAddress + partitions[i];
			if(free[i] == 0)
			{
				System.out.println(partitions[i] + "\t\t\t" + memoryAddress + "\t\t Job " + i + "\t\t\t Busy");
			}
			else
			{
				System.out.println(free[i] + "\t\t\t" + memoryAddress + "\t\t\t\t\t Free");
			}
		}
		System.out.println("Total Fragmentation: " + fragmentation);
	}
	
	public static void bestFit(int[] free, int[] jobs)
	{
		int[] partitions = new int[free.length];
		int tempFrag = 0;
		for(int i = 0; i < free.length; i++)
		{
			partitions[i] = free[i];
		}
		boolean matchFound = false;
		HashMap<Integer, Integer> busy = new HashMap<Integer, Integer>();
		int fragmentation = 0;
		int freePosition = 0;
		
		for(int i = 0; i < jobs.length; i ++)
		{
			
			for(int z = 0; z < free.length; z++)
			{
				if(free[z] >= jobs[i])
				{
					if(tempFrag >= (free[z] - jobs[i]))
					{
						freePosition = z;
						matchFound = true;
					}			
				}
			}
			if(matchFound == true)
			{
				fragmentation = fragmentation + (free[freePosition] - jobs[i]);
				busy.put(free[freePosition], jobs[i]);
				//System.out.println("Job " + i + " arrives.");
				free[freePosition] = 0;
			}
			matchFound = false;
		}
		System.out.println("Partition Size \t Memory Address \t Access \t Partition Status");
		System.out.println("-----------------------------------------------------------------------------");
		int memoryAddress = 0;
		for(int i = 0; i < free.length; i++)
		{
			memoryAddress = memoryAddress + partitions[i];
			if(free[i] == 0)
			{
				System.out.println(partitions[i] + "\t\t\t" + memoryAddress + "\t\t Job " + i + "\t\t\t Busy");
			}
			else
			{
				System.out.println(free[i] + "\t\t\t" + memoryAddress + "\t\t\t\t\t Free");
			}
		}
		System.out.println("Total Fragmentation: " + fragmentation);
	}
	
	public static void nextFit(int[] free, int[] jobs)
	{
		int[] partitions = new int[free.length];
		for(int i = 0; i < free.length; i++)
		{
			partitions[i] = free[i];
		}
		HashMap<Integer, Integer> busy = new HashMap<Integer, Integer>();
		int fragmentation = 0;
		int position = 0;
		int zPosition = 0;
		for(int i = 0; i < jobs.length; i ++)
		{
			
			for(int z = position; position < free.length; position++)
			{
				zPosition = z;
				if(free[z] >= jobs[i])
				{
					fragmentation = fragmentation + (free[z] - jobs[i]);
					busy.put(free[z], jobs[i]);
					//System.out.println("Job " + i + " arrives.");
					free[z] = 0;
					break;
				}
			}
			if(position == free.length)
			{
				for(int j = 0; j < zPosition; j++)
				{
					fragmentation = fragmentation + (free[j] - jobs[i]);
					busy.put(free[j], jobs[i]);
					//System.out.println("Job " + i + " arrives.");
					free[j] = 0;
					break;
				}
			}
		}
		System.out.println("Partition Size \t Memory Address \t Access \t Partition Status");
		System.out.println("-----------------------------------------------------------------------------");
		int memoryAddress = 0;
		for(int i = 0; i < free.length; i++)
		{
			memoryAddress = memoryAddress + partitions[i];
			if(free[i] == 0)
			{
				System.out.println(partitions[i] + "\t\t\t" + memoryAddress + "\t\t Job " + i + "\t\t\t Busy");
			}
			else
			{
				System.out.println(free[i] + "\t\t\t" + memoryAddress + "\t\t\t\t\t Free");
			}
		}
		System.out.println("Total Fragmentation: " + fragmentation);
	}
	
	public static void worstFit(int[] free, int[] jobs)
	{
		int[] partitions = new int[free.length];
		int tempFrag = 0;
		for(int i = 0; i < free.length; i++)
		{
			partitions[i] = free[i];
		}
		boolean matchFound = false;
		HashMap<Integer, Integer> busy = new HashMap<Integer, Integer>();
		int fragmentation = 0;
		int freePosition = 0;
		
		for(int i = 0; i < jobs.length; i ++)
		{
			
			for(int z = 0; z < free.length; z++)
			{
				if(free[z] >= jobs[i])
				{
					if(tempFrag <= (free[z] - jobs[i]))
					{
						freePosition = z;
						matchFound = true;
					}			
				}
			}
			if(matchFound == true)
			{
				fragmentation = fragmentation + (free[freePosition] - jobs[i]);
				busy.put(free[freePosition], jobs[i]);
				//System.out.println("Job " + i + " arrives.");
				free[freePosition] = 0;
			}
			matchFound = false;
		}
		System.out.println("Partition Size \t Memory Address \t Access \t Partition Status");
		System.out.println("-----------------------------------------------------------------------------");
		int memoryAddress = 0;
		for(int i = 0; i < free.length; i++)
		{
			memoryAddress = memoryAddress + partitions[i];
			if(free[i] == 0)
			{
				System.out.println(partitions[i] + "\t\t\t" + memoryAddress + "\t\t Job " + i + "\t\t\t Busy");
			}
			else
			{
				System.out.println(free[i] + "\t\t\t" + memoryAddress + "\t\t\t\t\t Free");
			}
		}
		System.out.println("Total Fragmentation: " + fragmentation);
	}
}
