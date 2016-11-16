 import java.util.*;
 /**
  * 
  */
 public class TowerOfHanoi
 {
     //Number of disks to be used
     static int disks;
     static int steps = 0;
     static Stack<Integer> stack1 = new Stack<Integer>();
     static Stack<Integer> stack2 = new Stack<Integer>();
     static Stack<Integer> stack3 = new Stack<Integer>();
     public static void main(String[] args)
     {
         //Calls the start method
         start();
     }
     //Begins by requesting the number of disks
     public static void start()
     {
         //Creates the scanner and inserts the number of disks requested
         Scanner scan = new Scanner(System.in);   
         System.out.println("Please enter the number of disks:");
         disks = scan.nextInt();
         
         //Calls the insert method
         insert(disks);
     }
     //Inserts disks into first stack
     public static void insert(int num)
     {
         //Pushing disks into stack
         for (int i = num; i > 0; i--)
         {
             stack1.push(i);
         }
         //Prints out the starting function
         printOut();
         //Starts swapping
         swap(num, stack1, stack2, stack3);         
     }
     //Method to move over disks
     public static void swap(int moves, Stack<Integer> first, Stack<Integer> second, Stack<Integer> third)
     {
         if(moves == 0)
         {
             
         }
         else if (moves > 0)
         {
             //Recursively calls the method
             swap(moves-1, first, third, second);
             //Stores the top disk in the first stack in int n
             int n = first.pop();
             //Pushes it to third
             third.push(n);
             //Prints out current step
             printOut();              
             //Recursively calls the method again
             swap(moves-1, second, first, third);     
         }         
     }
     //Prints out the stacks
     public static void printOut()
     {
         //Prints out the current step number
         if(steps != 0)
         {
             System.out.println("Current Step: " + steps);
         }
         //Creates the header
         System.out.println("  1  |  2  |  3");
         System.out.println("---------------");
         //For loop for printing out the stacks
         for(int i = disks - 1; i >= 0; i--)
         {
             //The strings that will hold the ints
             String first = " ";
             String second = " ";
             String third = " ";
             //Stores the three stacks into strings
             try
             {
                 first = String.valueOf(stack1.get(i));
             }
             catch (Exception e){
             }    
             try
             {
                 second = String.valueOf(stack2.get(i));
             }
             catch(Exception e){
             }
             try
             {
                 third = String.valueOf(stack3.get(i));
             }
             catch (Exception e){
             }
             //Prints out the strings
             System.out.println("  " + first + "  |  " + second + "  |  " + third);
         }
         //Skips 2 lines
         System.out.println("");
         System.out.println("");
         steps ++;
     }
 }