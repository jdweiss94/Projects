/**
*Justin Weiss
*Chris Heeneke
*/
import java.util.Comparator;


public class SearchNodeComparator implements Comparator<SearchNode> 
{	

	public int compare(SearchNode node1, SearchNode node2) 
	{
		if(node1.getG() < node2.getG())
		{
			return 1;
		}
		else if(node1.getG() > node2.getG())
		{
			return -1;
		}
		
		else
		{
			return 0;
		}
	
	}

}
	
