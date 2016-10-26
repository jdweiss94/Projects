/**
 * Implements bubble sorting method
 */
public class BubbleSort
{
    public static void main(String[] args)
    {
        int[] data = {9, 1, 9, 5, 8};
        BubbleSort(data);
    }
    /**
     * @param data the array to be sorted
     */
    public static void BubbleSort(int[] data)
    {
        //Prints out the current array
        for(int z = 0; z < data.length; z++)
        {
            System.out.print(data[z] + " ");
        }
        System.out.println("\n");
        //Begins sorting
        for(int i = 0; i < data.length; i++)
        {
            for(int j = 0; j < data.length - 1; j++)
            {
                //Checks if the current int is larger than the next
                if (data[j] > data[j+1])
                {
                    //Swaps the data
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        //Prints out the new sorted array
        for(int z = 0; z < data.length; z++)
        {
            System.out.print(data[z] + " ");
        }
    }
}
