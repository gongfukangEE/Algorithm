package Sort.Advanced_Sort;


/**
 * @Auther gongfukang
 * @Date 2017/12/7 22:26
 * 归并排序（非递归）
 */
public class MergeSort_1 {
    private long[] theArray;
    private int nElems;

    public MergeSort_1(int max) {
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
        System.out.println("");
    }

    private void recMergeSort_1(long[] workSpace) {
        int size=workSpace.length;
        int k=1;

        while (k< size){
            mergePass(workSpace,k,size);
            k*=2;
        }
    }

    private void mergePass(long[] workSpace,int k,int n){
        int i=0;

        while (i<n-2*k+1){
            merge(workSpace,i,i+k-1,i+2*k-1);
            i+=2*k;
        }

        if(i<n-k){
            merge(workSpace,i,i+k-1,n-1);
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

        for (j = 0; j < n; j++)
            theArray[lowerBound + j] = workSpace[j];
    }
}
