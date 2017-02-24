import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Stack;

/**
 * Justin Weiss
 * Chris Heeneke
 */
public class SearchDriver {
 private static  State stae;
	/**
	 * Prints (to System.out) the path from the start to the goal implied by the backpointers.
	 * @param goal The end of the path that must be printed.
	 */
	public static void printSolutionPath(SearchNode goal) {
		
		/*
		 * 
		 * Implement this method to print the path from the start to 
		 * the goal (in that order).
		 * 
		 * HINTS: The State class has a toString method which you can use to
		 * get a String representing the State object.
		 * Each SearchNode should contain the relevant State objects.
		 * 
		 * You'll need to follow the backpointers from goal to the start
		 * to get the relevant State objects (but you'll get them 
		 * in the opposite order from what you want).
		 * You'll then want to print the State objects from start to goal.
		 * 
		 * SearchNode has a getBackpointer() method which returns the 
		 * previous SearchNode and a getState() method which returns the 
		 * State that is contained in that SearchNode.
		 * 
		 * You can identify the start state in that it will be contained
		 * in a SearchNode with a null backpointer.
		 * 
		 */
		Stack<String> path = new Stack<String>();
		SearchNode checker = goal;
		while(checker != null)
		{
			State tempState = checker.getState();
			String tempString = tempState.toString();
			path.push(tempString);
			checker = checker.getBackpointer();
		}
		String output = "";
		while(!path.isEmpty())
		{
			output = output + " " + path.pop();
		}
		System.out.println("Solution Path: " + output);
	}
	
	
	
	
	public static void main(String[] args) {
		
		// Example of how to construct a graph search problem.
		// First parameter is number of nodes.
		// Second parameter is the edge density (must be between 0.0 and 1.0).  Note: it ignores
		// the edge density if especially low (will always have at least the number of edges to
		// have a connected graph).
		// Third parameter should be set to true if you want all transition costs equal to 1, and false
		// otherwise.
		SimpleGraphSearchProblem problem = new SimpleGraphSearchProblem(100, 0.1, false);
		
		
		// If you want to time your code, you need this object.
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		
		// Call this method before running any search algorithm to reset the
		// code that is tracking the number of State expansions.
		State.resetStats();
		SimpleGraphSearchProblem[] problemArray = new SimpleGraphSearchProblem[10];
		for(int i = 0; i < 10; i++)
		{
			System.out.println("BFS");
			problemArray[i] = new SimpleGraphSearchProblem(100,0.1,false);
			// example of how to time a method call (for cpu time)
			long start = bean.getCurrentThreadCpuTime();
			SearchNode solution = problemArray[i].bfs();
			long totalTime = bean.getCurrentThreadCpuTime() - start;
			System.out.println("Time: " + (totalTime/1000000000.0));
			// time is in nanoseconds, so divide by 1000000000.0 to get seconds
			
			// example of accessing the number of expanded states
			System.out.println("Expanded: " + State.getNumExpandedStates());
			
			// example of getting the path, its cost, etc.
			if (solution != null) {
				System.out.println("Path length: " + solution.getPathLengthToNode());
				System.out.println("Path cost: " + solution.getG());
				printSolutionPath(solution);
			} else {
				System.out.println("No solution found");
			}
			System.out.println("---------------------");
		}
		
		
		
		State.resetStats();
		
		for(int i = 0; i < 10; i++)
		{
			problemArray[i] = new SimpleGraphSearchProblem(100,0.1,false);
			System.out.println();
			System.out.println("Uniform Cost Search");
			long start = bean.getCurrentThreadCpuTime();
			SearchNode solution = problemArray[i].uniformCostSearch();
			long totalTime = bean.getCurrentThreadCpuTime() - start;
			System.out.println("Time: " + (totalTime/1000000000.0));
			System.out.println("Expanded: " + State.getNumExpandedStates());
			
			if (solution != null) {
				System.out.println("Path length: " + solution.getPathLengthToNode());
				System.out.println("Path cost: " + solution.getG());
				printSolutionPath(solution);
			} else {
				System.out.println("No solution found");
			}
			System.out.println("---------------------");
		}
				
		//SimpleGraphSearchProblem[] nextProblem = new SimpleGraphSearchProblem[10];
	
				
				// Call this method before running any search algorithm to reset the
				// code that is tracking the number of State expansions.
				//State.resetStats();
				
				//for(int i = 0; i < nextProblem.length; i++)
				//{
				//	nextProblem[i] = problem;
				//	System.out.println("DFS");
					
					// example of how to time a method call (for cpu time)
				//	start = bean.getCurrentThreadCpuTime();
				//	solution = nextProblem[i].dfs();
				//	totalTime = bean.getCurrentThreadCpuTime() - start;
				//	System.out.println("Time: " + (totalTime/1000000000.0));
					// time is in nanoseconds, so divide by 1000000000.0 to get seconds
					
					// example of accessing the number of expanded states
				//	System.out.println("Expanded: " + State.getNumExpandedStates());
					
					// example of getting the path, its cost, etc.
				//	if (solution != null) {
				//		System.out.println("Path length: " + solution.getPathLengthToNode());
				//		System.out.println("Path cost: " + solution.getG());
				//		printSolutionPath(solution);
				//	} else {
				//		System.out.println("No solution found");
				//	}
				//}
				
				
		
		
	}

}