package Recursion.BInSearch;

/**
 * @Auther gongfukang
 * @Date 2017/12/4 16:36
 * 二分查找(循环)
 */
public class OrderArray {
    private long[] a;
    private int Elems;

    public OrderArray(int Max){
        a=new long[Max];
        Elems=0;
    }

    public int binSearch(long searchKey){
        int lowerBound =0;
        int upperBound=Elems-1;
        int curIn;
        while (true){
            curIn=(lowerBound+upperBound)/2;
            if(a[curIn]==searchKey){
                return curIn;
            }else if(lowerBound>upperBound){
                return Elems;
            }else{
                if(a[curIn]<searchKey)
                    lowerBound=curIn+1;
                else
                    upperBound=curIn-1;
            }
        }
    }
}
