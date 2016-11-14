
public class PolyFunctions {
	public static void main(String args[])
	{
		System.out.println(add(5,2));
		System.out.println(multiply(13,6));
	}
	public static int add(int a, int b)
	{
		int x = a^b;
		return x;
	}
	public static int multiply (int a, int b)
	{
		int x = 0;
		while(b!=0)
		{
			if((b&1) != 0)
			{
				x += a;
			}
			a = a<<1;
			b = b>>1;
		}
		return x;
	}
	public static int reduce(int a, int b)
	{
		int x = 0;
		return x;
	}
}
 