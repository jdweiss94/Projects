import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class PageRemoval {
	public static void main(String[] args)
	{
		int frames;
		Scanner scan = new Scanner(System.in);
		System.out.println("How many page frames are you using?");
		frames = scan.nextInt();
		fifo(frames);
		lru(frames);
		
		scan.close();
	}
	public static void fifo(int frames)
	{
		int miss = 0;
		int hit = 0;
		Queue<String> firstin = new LinkedList<String>();
		Scanner scan = new Scanner(System.in);
		String input;
		System.out.println("Please enter your jobs and type done when you are finished.");
		while(true)
		{
			input = scan.nextLine();
			if(input.equalsIgnoreCase("done"))
			{
				break;
			}
			else if(!firstin.contains(input) && firstin.size() == frames)
			{
				firstin.poll();
				firstin.add(input);
				miss++;
			}
			else if(!firstin.contains(input))
			{
				firstin.add(input);
				miss++;
			}
			else
			{
				hit++;
			}
		}
		System.out.print("What is currently in cache: ");
		while(!firstin.isEmpty())
		{
			System.out.print(firstin.poll() + " ");
		}
		System.out.println("");
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		int total = hit + miss;
		double hitPercent = ((double) hit/ (double) total) * 100;
		double missPercent = ((double) miss/ (double) total) * 100;
		
		System.out.println("Hits: " + hit + " " + df.format(hitPercent) + "%");
		System.out.println("Misses: " + miss + " " + df.format(missPercent) + "%");
		
		scan.close();
	}
	public static void lru(int frames)
	{
		int miss = 0;
		int hit = 0;
		Queue<String> firstin = new LinkedList<String>();
		Scanner scan = new Scanner(System.in);
		String input;
		System.out.println("Please enter your jobs and type done when you are finished.");
		while(true)
		{
			input = scan.nextLine();
			if(input.equalsIgnoreCase("done"))
			{
				break;
			}
			else if(!firstin.contains(input) && firstin.size() == frames)
			{
				firstin.poll();
				firstin.add(input);
				miss++;
			}
			else if(!firstin.contains(input))
			{
				firstin.add(input);
				miss++;
			}
			else
			{
				hit++;
			}
		}
		System.out.print("What is currently in cache: ");
		while(!firstin.isEmpty())
		{
			System.out.print(firstin.poll() + " ");
		}
		System.out.println("");
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		int total = hit + miss;
		double hitPercent = ((double) hit/ (double) total) * 100;
		double missPercent = ((double) miss/ (double) total) * 100;
		
		System.out.println("Hits: " + hit + " " + df.format(hitPercent) + "%");
		System.out.println("Misses: " + miss + " " + df.format(missPercent) + "%");
		
		scan.close();
	}
}
