/**
 * Implements insertion sorting method
 */
public class InsertionSort
{
    public static void main(String[] args)
    {
        int[] data = {1 , 5, 2, 10, 8, 9};
        InsertionSort(data);
    }
    /**
     * @param data the array to be sorted
     */
    public static void InsertionSort(int[] data)
    {
        //Prints out the unsorted array
        for(int z = 0; z < data.length; z++)
        {
            System.out.print(data[z] + " ");
        }
        System.out.println("\n");
        //Begins sorting
        for(int i = 1; i < data.length; i++)
        {
            //Sets j equal to i
            int j = i;
            while(data[j] < data[j-1])
            {
                //Swaps the ints
                int temp = data[j];
                data[j] = data[j-1];
                data[j-1] = temp;
                j = j-1;
            }
        }
        //Prints out sorted array
        for(int z = 0; z < data.length; z++)
        {
            System.out.print(data[z] + " ");
        }
    }
}
