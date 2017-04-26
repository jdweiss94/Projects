public class Solve implements Comparable<Solve> 
{
	String job;
	int arrival;
	int cpuCycle;
	int waitTime;
	int turnAround;
	int completionTime;

	public Solve(String job, int arrival, int cpuCycle, int waitTime, int turnAround, int completionTime) {
		super();
		this.job = job;
		this.arrival = arrival;
		this.cpuCycle = cpuCycle;
		this.waitTime = waitTime;
		this.turnAround = turnAround;
		this.completionTime = completionTime;
	}

	public String getJob() 
	{
		return job;
	}

	public void setJob(String job) 
	{
		this.job = job;
	}

	public int getArrival() 
	{
		return arrival;
	}

	public void setArrival(int arrival) 
	{
		this.arrival = arrival;
	}

	public int getCPUCycle() 
	{
		return cpuCycle;
	}

	public void setCPUCycle(int cPUCycle) 
	{
		cpuCycle = cPUCycle;
	}

	public int getWaitTime() 
	{
		return waitTime;
	}

	public void setWaitTime(int waitTime) 
	{
		this.waitTime = waitTime;
	}

	public int getTurnAround() 
	{
		return turnAround;
	}

	public void setTurnAround(int turnAround) 
	{
		this.turnAround = turnAround;
	}

	public int getCompletionTime() 
	{
		return completionTime;
	}

	public void setCompletionTime(int completionTime) 
	{
		this.completionTime = completionTime;
	}

	

	@Override
	public int compareTo(Solve second) 
	{
		if (second == null) 
		{
			throw new NullPointerException("Failure");
		} else if (this.cpuCycle < second.cpuCycle) 
		{
			return -1;
		} else if (this.cpuCycle > second.cpuCycle) 
		{
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString() 
	{
		String output = "";
		output = output + job + "\t" + arrival + "\t" + cpuCycle + "\t" + waitTime + "\t" + turnAround;
		return output;
	}
}
