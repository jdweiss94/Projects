
public class PolyFunctions {
	
	public int add(int a, int b)
	{
		int x = a^b;
		return x;
	}
	public int multiply (int a, int b)
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
	public int reduce(int a, int b)
	{
		int x = 0;
		return x;
	}
}
 