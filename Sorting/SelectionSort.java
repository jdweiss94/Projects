/**
 * Implements selection sorting method
 */
public class SelectionSort
{
    public static void main(String[] args)
    {
        int[] data = {2, 1, 9, 5, 8};
        SelectionSort(data);
    }
    /**
     * @param data the array to be sorted
     */
    public static void SelectionSort(int[] data)
    {
        //Prints out unsorted array
        for(int z = 0; z < data.length; z++)
        {
            System.out.print(data[z] + " ");
        }
        System.out.println("\n");
        //Begins sorting
        for(int i = 0; i < data.length; i++)
        {
            //Sets the index to i
            int index = i;
            for(int j = i + 1; j < data.length; j++)
            {
                //Checks if the current int is larger than the int at index index
                if (data[j] < data[index])
                {
                    //Changes the index to j
                    index = j;
                }
            }
            //Swaps the ints
            int smallest = data[index];
            data[index] = data[i];
            data[i] = smallest;
        }
        //Prints out new sorted array
        for(int z = 0; z < data.length; z++)
        {
            System.out.print(data[z] + " ");
        }
    }
}
