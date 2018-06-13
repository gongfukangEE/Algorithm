package Sort.Simple_Sort;

/**
 * @Auther gongfukang
 * @Date 2017/12/4 16:45
 * 冒泡排序
 */
public class BubbleSort {
    private long[] a;
    private int Elems;

    public BubbleSort(int max){
        a=new long[max];
        Elems=0;
    }

    public void bubbleSort(){
        int out,in;

        for(out=Elems-1;out>1;out--){
            for(in=0;in<out;in++){
                if(a[in]>a[in+1]){
                    swap(in,in+1);
                }
            }
        }
    }

    public void swap(int one,int two){
        long temp=a[one];
        a[one]=a[two];
        a[two]=temp;
    }
}
