package DataStructures.Sort.Simple_Sort;

/**
 * @Auther gongfukang
 * @Date 2017/12/4 16:53
 * 选择排序
 */
public class SelectSort {
    private long[] a;
    private int Elems;

    public SelectSort(int max){
        a=new long[max];
        Elems=0;
    }

    public void selectSort(){
        int out,in,min;

        for(out=0;out<Elems-1;out++){
            min=out;
            for(in=out+1;in<Elems;in++){
                if(a[in]<a[min])
                    min=in;
                swap(out,in);
            }
        }
    }

    public void swap(int one,int two){
        long temp=a[one];
        a[one]=a[two];
        a[two]=temp;
    }
}
