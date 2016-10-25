import java.util.Scanner;
import java.util.Random;
/**
 * Converts decimal numbers to binary
 */
public class decimalToBinary {
    private static Scanner scan;
	private static Scanner scanE;
	private static Scanner scanM;
	private static Scanner scanH;
	/**
     * Main method
     * @param args not used
     */
    public static void main(String[] args) {
       decimalToBinary();
    }
    /**
     * Constructor that takes in users choice of difficulty
     */
    public static void decimalToBinary()
    {
      scan = new Scanner(System.in);
      System.out.println("(E)asy, (M)edium, or (H)ard");
      String difficulty = scan.nextLine();
      if(difficulty.equalsIgnoreCase("E"))
      {
          easy();
      }
      else if(difficulty.equalsIgnoreCase("M"))
      {
          medium();
      }
      else if(difficulty.equalsIgnoreCase("H"))
      {
          hard();
      }
      else
      {
          System.out.println("Invalid Choice");
      }
    }
    /**
     * Creates a binary problem to solve that is "easy mode" for numbers from 1-7
     */
    public static void easy()
    {
        //Creates number randomizer
        Random rand = new Random();
        scanE = new Scanner(System.in);
        int num = rand.nextInt(7) + 1;
        //Takes user answer
        System.out.println("What is " + num + " equal to in binary?");
        String stringAnswer = scanE.nextLine();
        //Parses the answer into an int
        int answer = Integer.parseInt(stringAnswer, 2);
        //Checks if answer is correct
        if(answer == num)
        {
            System.out.println("Correct!");
        }
        else
        {
            System.out.println("Incorrect!");
        }
        //Sees if user wants to go again
        System.out.println("Go again? (Y)es or (N)o.");
        String choice = scanE.nextLine();
        if(choice.equalsIgnoreCase("Y"))
        {
            decimalToBinary();
        }
        else if(choice.equalsIgnoreCase("N"))
        {
            System.out.println("Good work today!");
        }
        else
        {
            System.out.println("Invalid Choice");
        }
    }
    /**
     * Creates a binary problem to solve that is "medium mode" for numbers from 7-31
     */
    public static void medium()
    {
        //Creates number randomizer
        Random rand = new Random();
        scanM = new Scanner(System.in);
        int num = rand.nextInt(31) + 7;
        //Takes user answer
        System.out.println("What is " + num + " equal to in binary?");
        String stringAnswer = scanM.nextLine();
        //Parses the answer into an int
        int answer = Integer.parseInt(stringAnswer, 2);
        //Checks if answer is correct
        if(answer == num)
        {
            System.out.println("Correct!");
        }
        else
        {
            System.out.println("Incorrect!");
        }
        //Sees if user wants to go again
        System.out.println("Go again? (Y)es or (N)o.");
        String choice = scanM.nextLine();
        if(choice.equalsIgnoreCase("Y"))
        {
            decimalToBinary();
        }
        else if(choice.equalsIgnoreCase("N"))
        {
            System.out.println("Good work today!");
        }
        else
        {
            System.out.println("Invalid Choice");
        }
    }
    /**
     * Creates a binary problem to solve that is "hard mode" for numbers from 31-1023
     */
    public static void hard()
    {
        //Creates number randomizer
        Random rand = new Random();
        scanH = new Scanner(System.in);
        int num = rand.nextInt(1023) + 31;
        System.out.println("What is " + num + " equal to in binary?");
        String stringAnswer = scanH.nextLine();
        //Parses answer into an int
        int answer = Integer.parseInt(stringAnswer, 2);
        //Checks if answer is correct
        if(answer == num)
        {
            System.out.println("Correct!");
        }
        else
        {
            System.out.println("Incorrect!");
        }
        //Sees if user wants to go again
        System.out.println("Go again? (Y)es or (N)o.");
        String choice = scanH.nextLine();
        if(choice.equalsIgnoreCase("Y"))
        {
            decimalToBinary();
        }
        else if(choice.equalsIgnoreCase("N"))
        {
            System.out.println("Good work today!");
        }
        else
        {
            System.out.println("Invalid Choice");
        }
    }
}