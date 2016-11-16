import java.util.Scanner;
import java.security.SecureRandom;

/**
 * Used to encrypt a 4 digit number
 *
 */
public class ElGamal {
	private static long p;
	private static long a;
	private static long x;
	private static long b;
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String args[])
	{
		elGamal();
	}
	public static void elGamal()
	{		
		System.out.println("(E)ncrypt or (D)ecrypt?");
		String choice = scan.next();
		
		if(choice.equalsIgnoreCase("e"))
		{
			System.out.println("Enter a prime p:");
			p = scan.nextLong();
			
			System.out.println("Enter an alpha:");
			a = scan.nextLong();
			
			System.out.println("Enter your private key (x):");
			x = scan.nextLong();
			
			b = (long) (Math.pow(a, x))%p;
			
			encrypt();
		}
		else if(choice.equalsIgnoreCase("d"))
		{
			System.out.println("Enter a prime p:");
			p = scan.nextLong();
			
			System.out.println("Enter an alpha:");
			a = scan.nextLong();
			
			System.out.println("Enter a beta:");
			b = scan.nextLong();
			
			
			decrypt();
		}
		else
		{
			System.out.println("Invalid choice.");
		}
		
		scan.close();
	}
	public static void choices()
	{
				
	}
	public static void encrypt()
	{
		SecureRandom random = new SecureRandom();
		
		System.out.println("Enter the integer you would like to encrypt:");
		long m = scan.nextLong();
		
		long k = random.nextInt(999);
		
		long r = (long) ((Math.pow(a, k))%p);
		
		long t = (long) (((Math.pow(b, k))*m)%p);
		
		System.out.println("Public key: [" + p + "," +  a + "," + b + "]");
		System.out.println("The ciphertext is: (" + r + "," + t + ")");		
	}
	public static void decrypt()
	{		
		System.out.println("Enter the first integer (r)");
		long r = scan.nextLong();
		
		System.out.println("Enter the second integer (t)");
		long t = scan.nextLong();
		
		x = x*(-1);
		
		long m = (long) (t*(Math.pow(r, x))%p);
		
		System.out.println(m);
	}
}
