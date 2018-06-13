package DataStructures.Sort.Advanced_Sort;

/**
 * @Auther gongfukang
 * @Date 2017/12/22 11:38
 * 归并排序（递归实现）
 */
public class MergeSort_2 {
    private long[] theArray;
    private int nElems;

    public MergeSort_2(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " ");
        System.out.println(" ");
    }

    private void recMergeSort_2(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound)
            return;
        else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort_2(workSpace, lowerBound, mid);
            recMergeSort_2(workSpace, mid + 1, upperBound);
            merge(workSpace,lowerBound,mid+1,upperBound);
        }
    }

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (theArray[lowPtr] < theArray[highPtr])
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        }
        while (lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];

        while (highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];

        for (j = 0; j < n; j++) {
            theArray[lowerBound + j] = workSpace[j];
        }
    }
}
