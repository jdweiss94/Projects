public class Solve implements Comparable<Solve> {

	private String job;
	private int arrival;
	private int cpuCycle;
	private int waitTime;
	private int turnAround;
	private int completionTime;

	public Solve(String job, int arrival, int cPUCycle, int waitTime, int turnAround, int completionTime) {
		super();
		this.job = job;
		this.arrival = arrival;
		cpuCycle = cPUCycle;
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
	public int compareTo(Solve otherTask) 
	{
		if (otherTask == null) {
			throw new NullPointerException("Attempted to compare " + this
					+ " to null");
		} else if (this.cpuCycle < otherTask.cpuCycle) {
			return -1;
		} else if (this.cpuCycle > otherTask.cpuCycle) {
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
