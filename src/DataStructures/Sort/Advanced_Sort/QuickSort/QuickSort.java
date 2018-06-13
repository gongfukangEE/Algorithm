package DataStructures.Sort.Advanced_Sort.QuickSort;


/**
 * @Auther gongfukang
 * @Date 2018/1/29 15:19
 * 快速排序
 */
public class QuickSort {
    private long[] theArray;
    private int nElems;

    public QuickSort(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        System.out.print("A=");
        for (int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " ");
        System.out.println("");
    }

    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    public void recQuickSort(int left, int right) {
        if (right - left <= 0)
            return;
        else {
            long pivot = theArray[right];

            int partition = partitonIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    public int partitonIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (theArray[++leftPtr] < pivot) ;
            while (theArray[--rightPtr] > pivot && rightPtr > 0) ;

            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, rightPtr);
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
