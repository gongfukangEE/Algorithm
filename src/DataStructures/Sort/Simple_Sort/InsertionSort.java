package DataStructures.Sort.Simple_Sort;

/**
 * @Auther gongfukang
 * @Date 2017/12/4 17:10
 * 插入排序
 */
public class InsertionSort {
    private long[] a;
    private int Elems;

    public InsertionSort(int max){
        a=new long[max];
        Elems=0;
    }

    public void insertionSort(){
        int in,out;

        for(out=1;out<Elems;out++){
            long temp=a[out];
            in=out;
            while (in>0&&a[in-1]>=temp){
                a[in]=a[in-1];
                --in;
            }
            a[in]=temp;
        }
    }
}
