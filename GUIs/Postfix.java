import java.util.Scanner;
import java.util.Stack;

public class Postfix {
	/*
     * Used to evaluate prefix expressions  
     * @param input the expression being evaluated
    */
    public double startPostfix(String input) 
    {
        Stack<Double> stack = new Stack<Double>();
        Scanner scan = new Scanner(input);
        String operator;
        
        double first;
        double second;
        while (scan.hasNext())
        {
            if (scan.hasNextDouble())
            {
                stack.push(scan.nextDouble());
            } 
            else 
            {
                second = stack.pop();
                first = stack.pop();

                operator = scan.next();
                
                double push = solve(first, operator, second);
                stack.push(push);
            }
        }
        double result = stack.pop();
        scan.close();
        return result;
    }
    /*
     * This method takes the operator, and two numbers and evaluates
     * the numbers based on the operator being used.
    */  
    public static double solve(double first, String operator, double second) {
        if (operator.equals("*")) 
        {
            return first * second;
        } else if (operator.equals("/")) 
        {
            return first / second;
        } else if (operator.equals("+")) 
        {
            return first + second;
        } else if (operator.equals("-")) 
        {
            return first - second;
        }
        return 0;
    }
}
