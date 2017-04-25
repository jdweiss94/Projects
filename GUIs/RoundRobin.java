import java.util.ArrayList;

public class RoundRobin {

	public void Robinrunner(ArrayList<Solve> solutions) {


		int size = solutions.size();
		int tempComplete = 0;

		while (size > 0) {
			for (Solve temp : solutions) {

				if (temp.getCPUCycle() > 0) {

					int value = temp.getCPUCycle() - 4;
					if (value <= 0) {
						tempComplete = tempComplete + temp.getCPUCycle();
						temp.setCompletionTime(tempComplete - temp.getArrival());
						temp.setTurnAround(temp.getCompletionTime());
						temp.setCPUCycle(0);
					} else {
						tempComplete = tempComplete + 4;
						temp.setCompletionTime(tempComplete);
						temp.setCPUCycle(value);
						
					}
				} else {
					size = size - 1;
				}
			}

		}
		
		for (Solve temp : solutions) {
			temp.setCPUCycle(temp.getCompletionTime() +1);
		}

	}

}
