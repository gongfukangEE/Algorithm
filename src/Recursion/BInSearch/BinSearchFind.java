package Recursion.BInSearch;

/**
 * @Auther gongfukang
 * @Date 2017/12/7 13:52
 * 二分查找(递归)
 */
public class BinSearchFind {
    private long[] a;
    private int nElems;

    public BinSearchFind(int max){
        a=new long[max];
        nElems=0;
    }

    public int size(){
        return nElems;
    }

    public int find(long searchKey){
        return recFind(searchKey,0,nElems-1);
    }

    public int recFind(long searchKey,int lowerBound,int upperBound){
        int curIn;

        curIn=(lowerBound+upperBound)/2;
        if(a[curIn]==searchKey)
            return curIn;
        else if(lowerBound>upperBound)
            return nElems;
        else
        {
            if(a[curIn]<searchKey)
                return recFind(searchKey,curIn+1,upperBound);
            else
                return recFind(searchKey,lowerBound,curIn-1);
        }
    }
}
