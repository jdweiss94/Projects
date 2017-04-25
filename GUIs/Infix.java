import java.util.Scanner;
import java.util.Stack;

public class Infix {
	/*
     * Used to evaluate infix expressions  
     * @param input the expression being evaluated
    */
    public String startInfix(String input)
    {
        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        
        String popped;
        String push;
        
        double answer;
        double first;
        double second;
        
        Scanner scan = new Scanner(input); 
        while(scan.hasNext() ==  true)
        {
            stack1.push(scan.next());
        }
        while(stack1.empty() == false)
        {
            stack2.push(stack1.pop());
        }
        while(stack2.empty() == false)
        {
            popped = stack2.pop();
            if(popped.equals("*") == false)
            {
                stack1.push(popped);
            }
            else
            {
                first = Double.parseDouble(stack1.pop());
                second = Double.parseDouble(stack2.pop());
                answer =  first * second;
                
                push = Double.toString(answer);
                stack1.push(push);
            }
        }       
        while(stack1.empty() == false)
        {
            stack2.push(stack1.pop());
        }       
        while(stack2.empty() == false)
        {
            popped = stack2.pop();
            if(popped.equals("/") == false)
            {
                stack1.push(popped);
            }
            else
            {
                first = Double.parseDouble(stack1.pop());
                second = Double.parseDouble(stack2.pop());
                answer = first / second;
                
                push = Double.toString(answer);
                stack1.push(push);
            }
        }
        while(stack1.empty() == false)
        {
            stack2.push(stack1.pop());
        }
        while(stack2.empty() == false)
        {
            popped = stack2.pop();
            if(popped.equals("+") == false)
            {
                stack1.push(popped);
            }
            else
            {
                first = Double.parseDouble(stack1.pop());
                second = Double.parseDouble(stack2.pop());
                answer = first + second;
                
                push = Double.toString(answer);
                stack1.push(push);
            }
        }
        while(stack1.empty() == false)
        {
            stack2.push(stack1.pop());
        }           
        while(stack2.empty() == false)
        {
            popped = stack2.pop();
            if(popped.equals("-") == false)
            {
                stack1.push(popped);
            }
            else
            {
                first = Double.parseDouble(stack1.pop());
                second = Double.parseDouble(stack2.pop());
                answer = first - second;
                
                push = Double.toString(answer);
                stack1.push(push);
            }
        }   
        String solution = stack1.pop();
        scan.close();
        return solution;        
    }
    /*
     * This method takes the operator, and two numbers and evaluates
     * the numbers based on the operator being used.
    */  
    public double solve(String op, double first, double second)
    {
        if (op.equals("*")) 
        {
            double answer = first * second;
            return answer;
        } 
        else if (op.equals("/")) 
        {
            double answer = first / second;
            return answer;
        } 
        else if (op.equals("+")) 
        {
            double answer = first + second;
            return answer;
        }
        else if (op.equals("-"))
        {
            double answer = first - second;
            return answer;
        }           
        else
        {
            return 0;
        }   
    }
}
