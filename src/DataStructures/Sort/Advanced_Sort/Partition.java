package Sort.Advanced_Sort;


/**
 * @Auther gongfukang
 * @Date 2017/12/15 19:33
 * 划分
 */
public class Partition {
    private long[] theArray;
    private int nElems;

    public Partition(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public int size() {
        return nElems;
    }

    public void display() {
        System.out.print("A=");
        for (int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " ");
        System.out.println("");
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (true) {
            while (leftPtr < right && theArray[++leftPtr] < pivot) ;
            while (rightPtr > left && theArray[--right] > pivot) ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        long temp;
        temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
