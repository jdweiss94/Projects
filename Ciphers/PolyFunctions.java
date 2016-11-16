/**
 * Justin Weiss
 * 
 * Utilizes polynomial functions mod 2
 *
 */
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
		if(getHighestBit(a) < getHighestBit(b))
		{
			return a;
		}
		else
		{
			int i = getHighestBitX(a);
			int j = getHighestBitX(b);
			int k = b << (i-j);
			int temp = add(a,k);
			return reduce(temp,b);
		}
	}
	private int getHighestBit(int bit)
	{
		int left = 1;
		int output = 0;
		for(int i = 0; i < 30; i++)
		{
			if((left&bit)>0)
			{
				output = left;
			}
			left = left << 1;
		}
		return output;
	}
	private int getHighestBitX(int bit)
	{
		int left = 1;
		int output = 0;
		for(int i = 0; i < 30; i++)
		{
			if((left&bit)>0)
			{
				output = i;
			}
			left = left << 1;
		}
		return output;
	}
	public String matrices(int[][] a, int[][] b)
	{
		int[][] result = new int[4][4];
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				int temp1 = multiply(a[i][0],b[0][j]);
				int temp2 = multiply(a[i][1],b[1][j]);
				int temp3 = multiply(a[i][2],b[2][j]);
				int temp4 = multiply(a[i][3],b[3][j]);
				
				temp1 = add(temp1,temp2);
				temp3 = add(temp3,temp4);
				temp1 = add(temp1,temp3);
				
				result[i][j] = temp1;
			}
		}
		String tempS = "";
		for(int i = 0; i < 4; i++)
		{
			tempS = tempS + "|";
			for(int j = 0; j < 4; j++)
			{
				tempS = tempS + " " + result[i][j];
			}
			tempS = tempS + "|\n";
		}
		return tempS;
		
	}
}
 