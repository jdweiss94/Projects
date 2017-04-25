import java.util.ArrayList;
import java.util.Collections;
public class SJN {
	
		
		
		public void SJNrunner(ArrayList<Solve> solutions){
			
			int waitTime = 0;
			
			Collections.sort(solutions);
			
			for (Solve temp : solutions) {
				temp.setTurnAround(temp.getCPUCycle() - temp.getArrival());
				waitTime = waitTime + temp.getCPUCycle();
				temp.setWaitTime(waitTime);
				
			}
			
		}

}
