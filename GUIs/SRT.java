import java.util.ArrayList;
import java.util.Collections;

public class SRT {

	public void SRTrunner(ArrayList<Solve> solutions) {

		int size = solutions.size();
		int tempComplete = 0;

		while (size > 0) {
			for (Solve temp : solutions) {

				if (temp.getCPUCycle() > 0) {
					
					tempComplete = tempComplete +1;
					temp.setCompletionTime(tempComplete);
					temp.setCPUCycle(temp.getCPUCycle() - 1);
				
				} else {
					size = size - 1;
				}
				Collections.sort(solutions);
			}

		}

	}

}
