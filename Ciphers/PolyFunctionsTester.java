
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
	}
}
