import java.util.LinkedList;

public class Prefix {
	/*
     * Used to evaluate prefix expressions  
     * @param input the expression being evaluated
    */    
	public static double startPrefix(String[] expression) {
		LinkedList<Double> list = new LinkedList<Double>();
        for(int i=expression.length-1;i >- 1;i--){
            String element = expression[i];
            if(element.equals("*") || element.equals("/") || element.equals("+") || element.equals("-"))
            {
            	list.push(solve(list.poll(), element, list.poll()));
            }
            else
            {
            	list.push(Double.parseDouble(element));
            }
        }
        return list.poll();
    }

    // pre : operator is one of +, -, *, / or %
    // post: returns the result of applying the given operator to
    //       the given operands
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
