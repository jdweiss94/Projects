import java.util.ArrayList;
public class FCFS {
	
		
		
		public void FCFSrunner(ArrayList<Solve> solutions){
			
			int waitTime = 0;
			
			
			for (Solve temp : solutions) {
				temp.setTurnAround(temp.getCPUCycle() - temp.getArrival());
				waitTime = waitTime + temp.getCPUCycle();
				temp.setWaitTime(waitTime);
				
			}
			
		}

}
