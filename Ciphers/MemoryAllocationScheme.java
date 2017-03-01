import java.util.Scanner;
public class MemoryAllocationScheme {
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("How many partitions do you want?");
		int n = scan.nextInt();
		System.out.println("Please list partition sizes.");
		int[] fixed = new int[n];
		for(int i = 0; i < n; i++)
		{
			fixed[i] = scan.nextInt();
		}
		scan.close();
		
	}
	public void firstFit(int[] memory)
	{
		
	}
}
