/**
 * Implements merge sorting method
 */
public class MergeSort
{
    //Global variable to hold the array
    int[] globalArray;
    public static void main(String[] args)
    {
        MergeSort merging = new MergeSort();
        int[] input =  {3, 2, 15, 12, 26, 7};
        merging.start(input);
    }
    /**
     * @param input for the input array
     */
    public void start(int[] input)
    {
        this.globalArray = input;
        split(0, input.length-1);
        display();
    }
    /**
     * @param front is the front index
     * @param back is the back index
     */
    public void split(int front, int back)
    {
        //Checks to make sure the array can be split
        if(front < back)
        {
            //Creates the middle point
            int middle = front + (back-front)/2;
            //Recursively calls the method with the first half of the split
            split(front,middle);
            //Recursively calls the method with the second half of the split
            split(middle+1,back);
            //Calls the merge method
            merge(front, middle, back);
        }
    }
    /**
     * @param front is the front index
     * @param middle is the middle index
     * @param back is the back index
     */
    public void merge(int front, int middle, int back)
    {
        //Variables for rebuilding the array
        int x = front;
        int y = middle + 1;
        int z = front;
        //Create and build a temp array
        int[] temp = new int[globalArray.length];
        for (int i = front; i <= back; i++) 
        {
            temp[i] = globalArray[i];
        }
        //Rebuilds the array in correct order
        while (x <= middle && y <= back) 
        {
            if (temp[x] <= temp[y]) 
            {
                globalArray[z] = temp[x];
                x++;
            } else 
            {
                globalArray[z] = temp[y];
                y++;
            }
            z++;
        }
        while (x <= middle) 
        {
            globalArray[z] = temp[x];
            z++;
            x++;
        } 
    }
    public void display()
    {
        //Displays the text
        for(int z = 0; z < globalArray.length; z++)
        {
            System.out.print(globalArray[z] + " ");
        }
    }
}
