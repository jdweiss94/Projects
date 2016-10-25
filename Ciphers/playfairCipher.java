import java.io.*;
import java.util.Scanner;
/**
 * Justin Weiss
 * Chris Heeneke
 */
public class playfairCipher
{
    //Sets global variables
    static StringBuilder sb = new StringBuilder();
    static char playfair[][] = new char[5][5];
    static char storage[] = new char[27];
    static int storageSize = 0;
    static int column = 0;
    static int row = 0;
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static String input;
    static String text;
    static String key;
    static String path;
    static String output = "";
	private static Scanner scan;
    
    /**
     * Main method used for reading text and input
     * @param args not used
     */
    public static void main(String[] args)
    {
        scan = new Scanner(System.in);
        System.out.println("(E)ncrypt or (D)ecrypt?");
        input = scan.nextLine();
        System.out.println("Please enter your key");
        key = scan.nextLine();
        //Sets filepath and reads the text
        try {
            if(input.equalsIgnoreCase("E"))
            {
                path = "plaintext.txt";
            }
            else if(input.equalsIgnoreCase("D"))
            {
                path = "ciphertext.txt";
            }
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();
        }
        catch(IOException e)
        {
        }
        text = sb.toString();
        //Removes all spaces from text
        text = text.replaceAll("\\s","");
        text = text.toUpperCase();
        //Removes all spaces from
        key = key.replaceAll("\\s","");
        key = key.toUpperCase();
        //Puts the key in the matrix
        for(int i = 0; i<key.length(); i++)
        {
            char temp = key.charAt(i);
            if(check(temp) == true)
            {
                playfair[row][column] = temp;
                System.out.print(playfair[row][column] + " ");
                if(column >= 4)
                {
                    column = 0;
                    row++;
                    System.out.println();
                }
                else
                {
                    column++;
                }
            }
        }
        //Calls fill method
        fill();
    }
    /**
     * Method used to check if letter is in matrix already
     * @param checking the letter that is being checked
     * @return true the letter is not used yet
     * @return false the letter has already been put in the matrix
     */
    public static boolean check(char checking)
    {
        //Checks the matrix
        for(int j = 0; j < storage.length; j++)
        {
            if(storage[j] == checking)
            {
                return false;
            }
            if(checking == 'J' && storage[j] == 'I')
            {
                return false;
            }
            else if(checking == 'I' && storage[j] == 'J')
            {
                return false;
            }
        }
        //Adjusts the array size
        storage[storageSize] = checking;
        storageSize++;
        return true;
    }
    /**
     * Method used to fill matrix with rest of the alphabet
     */
    public static void fill()
    {
        //Runs through the alphabet
        for(int filler = 0; filler < alphabet.length; filler++)
        {
            char insert = Character.toUpperCase(alphabet[filler]);
            if(check(insert) == true)
            {
                playfair[row][column] = insert;
                System.out.print(playfair[row][column] + " ");
                if(column >= 4)
                {
                    column = 0;
                    row++;
                    System.out.println();
                }
                else
                {
                    column++;
                }
            }
        }
        //Checks whether to encrypt or decrypt
        if(input.equalsIgnoreCase("E"))
        {
            encryption();
        }
        else if(input.equalsIgnoreCase("D"))
        {
            decryption();
        }
        else
        {
            System.out.println("Invalid Choice");
        }
    }
    /**
     * Method used for encryption
     */
    public static void encryption()
    {
        //Runs through the text and divides them into twos
        for(int i = 0; i < text.length(); i= i+2)
        {
            char first = text.charAt(i);
            char second;
            //Checks if an X has to be added to the end
            if(i+1 == text.length())
            {
                second = 'X';
            }
            
            else
            {
                second = text.charAt(i+1);
            }
            //Checks if the pair matches eachother and needs a filler X
            if(first == second && first != 'X')
            {
                second = 'X';
                i--;
            }
            else if(first == second && first == 'X')
            {
                second = 'Z';
                i--;
            }
            //Changes J's to I's
            if(first == 'J')
            {
                first = 'I';
            }
            if(second == 'J')
            {
                second = 'I';
            }
            //Sets the x and y positions of letters
            int j = 0;
            int z = 0;

            int firstX = 0;
            int firstY = 0;

            int secondX = 0;
            int secondY = 0;
            //Finds the x and y positions of letters
            for(j = 0; j < 5; j++)
            {
                for(z = 0; z < 5; z++)
                {
                    if(playfair[j][z] == first)
                    {
                        firstX = j;
                        firstY = z;
                    }
                    else if(playfair[j][z] == second)
                    {
                        secondX = j;
                        secondY = z;
                    }
                }
            }
            //Moves if letters are in same row
            if(firstX == secondX)
            {
                if(firstY+1 == 5)
                {
                    firstY = 0;
                }
                else
                {
                    firstY++;
                }
                if(secondY+1 == 5)
                {
                    secondY = 0;
                }
                else
                {
                    secondY++;
                }
            }
            //Moves is letters are in same column
            else if(firstY == secondY)
            {
                if(firstX+1 == 5)
                {
                    firstY = 0;
                }
                else
                {
                    firstX++;
                }
                if(secondX+1 == 5)
                {
                    secondX = 0;
                }
                else
                {
                    secondX++;
                }
            }
            else
            //Encrypts the letters
            {
                int temp;
                temp = firstY;
                firstY = secondY;
                secondY = temp; 
            }
            //Creates outdoor string
            output = output + playfair[firstX][firstY] + "" + playfair[secondX][secondY];
        }
        //Writes ciphertext to file
        try
        {
            PrintWriter writer = new PrintWriter("out1.txt", "UTF-8");
            writer.println(output);
            writer.close();
        }
        catch(IOException e)
        {
        }
        System.out.println("Success!");
    }
    /**
     * Method used for decryption
     */
    public static void decryption()
    {
        //Runs through the text and divides them into twos
        for(int i = 0; i < text.length(); i= i+2)
        {
            char first = text.charAt(i);
            char second;
            //Checks if an X has to be added to the end
            if(i+1 == text.length())
            {
                second = 'X';
            }
            
            else
            {
                second = text.charAt(i+1);
            }
            //Checks if pair matches each other and a filler X needs to be added in
            if(first == second && first != 'X')
            {
                second = 'X';
                i--;
            }
            else if(first == second && first == 'X')
            {
                second = 'Z';
                i--;
            }
            //Changes J's to I's
            if(first == 'J')
            {
                first = 'I';
            }
            if(second == 'J')
            {
                second = 'I';
            }
            //Sets x and y positions of letters
            int j = 0;
            int z = 0;

            int firstX = 0;
            int firstY = 0;

            int secondX = 0;
            int secondY = 0;
            //Finds the x and y positions of letters
            for(j = 0; j < 5; j++)
            {
                for(z = 0; z < 5; z++)
                {
                    if(playfair[j][z] == first)
                    {
                        firstX = j;
                        firstY = z;
                    }
                    else if(playfair[j][z] == second)
                    {
                        secondX = j;
                        secondY = z;
                    }
                }
            }
            //Moves if letters are in same row
            if(firstX == secondX)
            {
                if(firstY-1 == -1)
                {
                    firstY = 4;
                }
                else
                {
                    firstY--;
                }
                if(secondY-1 == -1)
                {
                    secondY = 4;
                }
                else
                {
                    secondY--;
                }
            }
            //Moves if letters are in same column
            else if(firstY == secondY)
            {
                if(firstX-1 == -1)
                {
                    firstY = 4;
                }
                else
                {
                    firstX--;
                }
                if(secondX-1 == -1)
                {
                    secondX = 4;
                }
                else
                {
                    secondX--;
                }
            }
            //Moves letters
            else
            {
                int temp;
                temp = firstY;
                firstY = secondY;
                secondY = temp;
            }
            //Creates output string
            output = output + playfair[firstX][firstY] + "" + playfair[secondX][secondY];
        }
        //Writes plaintext to file
        try
        {
            PrintWriter writer = new PrintWriter("out2.txt", "UTF-8");
            writer.println(output);
            writer.close();
        }
        catch(IOException e)
        {
        }
        System.out.println("Success!");
    }
}
