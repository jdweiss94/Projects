/**
 * Justin Weiss
 * 
 * Tester class for PolyFunctions class. Expected results are noted above the called method
 */
public class PolyFunctionsTester {
	public static void main(String args[])
	{
		PolyFunctions poly = new PolyFunctions();
		/**
		 * 5 = 101
		 * 2 = 10
		 * 101 XOR 10 = 111
		 * 111 = 7
		 * Return should be 7
		 */
		System.out.println(poly.add(5,2));
		/**
		 * 13 = 1101
		 * 6 = 110
		 * 			 1101
		 * 			x0110
		 * 			-----
		 * 			 0000
		 * 			11010
		 * 		   110100
		 * 		 +0000000
		 * 		 --------
		 * 		  1001110
		 * 1001110 = 78
		 * Return should be 78
		 */
		System.out.println(poly.multiply(13,6));
		/**
		 * 7 = 111 = x^2+x+1
		 * 5  = 101 = x^2+1
		 * 			  ______1
		 * 		x^2+1|x^2+x+1
		 * 			  x^2+  1
		 * 			   	  x
		 * 
		 * x = 10 = 2
		 * Return should be 2
		 */
		System.out.println(poly.reduce(7,5));
		/**
		 * a =  |1 0 1 1|
		 * 		|1 0 1 0|
		 * 		|1 0 1 0|
		 * 		|1 0 1 1|
		 * 
		 * b =  |1 1 0 1|
		 * 		|1 0 1 1|
		 * 		|1 1 1 0|
		 * 		|1 0 0 1|
		 * 
		 * The returned result should be |1 0 1 0|
		 * 								 |0 0 1 1|
		 * 								 |0 0 1 1|
		 * 								 |1 0 1 0|
		 * 
		 */
		int[][] a = new int[][]{
			{1,0,1,1},
			{1,0,1,0},
			{1,0,1,0},
			{1,0,1,1}
		};
		int[][] b = new int[][]{
			{1,1,0,1},
			{1,0,1,1},
			{1,1,1,0},
			{1,0,0,1}
		};
		
		System.out.println(poly.matrices(a, b));
	}
}
