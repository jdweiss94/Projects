import java.util.HashMap;

public class Dynamic {
	public String firstFit(int[] free, int[] jobs)
	{
		String output = "";
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
					output = output + "\n Job " + i + " arrives.\n";
					free[z] = 0;
					output = output + "\n Partition Size \t Memory Address \t Access \t Partition Status";
					output = output + "\n --------------------------------------------------------------------------------------------------------";
					int memoryAddress = 0;
					for(int x = 0; x < free.length; x++)
					{
						memoryAddress = memoryAddress + partitions[x];
						if(free[x] == 0)
						{
							output = output + "\n" + partitions[x] + "\t" + memoryAddress + "\t\t Job " + i + "\t Busy";
						}
						else
						{
							output = output + "\n" + free[x] + "\t" + memoryAddress + "\t\t\t Free";
						}
					}
					output = output + "\n Total Fragmentation: " + fragmentation + "\n";
					break;
				}
			}
		}
		return output;
	}
	
	public String bestFit(int[] free, int[] jobs)
	{
		String output = "";
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
				output = output + "\n Job " + i + " arrives.\n";
				free[freePosition] = 0;
			}
			matchFound = false;
		}
		output = output + "\n Partition Size \t Memory Address \t Access \t Partition Status";
		output = output + "\n --------------------------------------------------------------------------------------------------------";
		int memoryAddress = 0;
		for(int i = 0; i < free.length; i++)
		{
			memoryAddress = memoryAddress + partitions[i];
			if(free[i] == 0)
			{
				output = output + "\n" + partitions[i] + "\t" + memoryAddress + "\t\t Job " + i + "\t Busy";
			}
			else
			{
				output = output + "\n" + free[i] + "\t" + memoryAddress + "\t\t\t Free";
			}
		}
		output = output + "\n Total Fragmentation: " + fragmentation + "\n";
		return output;
	}
	
	public String nextFit(int[] free, int[] jobs)
	{
		String output = "";
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
					output = output + "\n Job " + i + " arrives.\n";
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
					output = output + "\n Job " + i + " arrives.\n";
					free[j] = 0;
					break;
				}
			}
		}
		output = output + "\n Partition Size \t Memory Address \t Access \t Partition Status";
		output = output + "\n --------------------------------------------------------------------------------------------------------";
		int memoryAddress = 0;
		for(int i = 0; i < free.length; i++)
		{
			memoryAddress = memoryAddress + partitions[i];
			if(free[i] == 0)
			{
				output = output + "\n" + partitions[i] + "\t" + memoryAddress + "\t\t Job " + i + "\t Busy";
			}
			else
			{
				output = output + "\n" + free[i] + "\t" + memoryAddress + "\t\t\t Free";
			}
		}
		output = output + "\n Total Fragmentation: " + fragmentation + "\n";
		return output;
	}
	
	public String worstFit(int[] free, int[] jobs)
	{
		String output = "";
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
				output = output + "\nJob " + i + " arrives.\n";
				free[freePosition] = 0;
			}
			matchFound = false;
		}
		output = output + "\n Partition Size \t Memory Address \t Access \t Partition Status";
		output = output + "\n --------------------------------------------------------------------------------------------------------";
		int memoryAddress = 0;
		for(int i = 0; i < free.length; i++)
		{
			memoryAddress = memoryAddress + partitions[i];
			if(free[i] == 0)
			{
				output = output + "\n" + partitions[i] + "\t" + memoryAddress + "\t\t Job " + i + "\t Busy";
			}
			else
			{
				output = output + "\n" + free[i] + "\t" + memoryAddress + "\t\t\t Free";
			}
		}
		output = output + "\nTotal Fragmentation: " + fragmentation + "\n";
		return output;
	}
}
