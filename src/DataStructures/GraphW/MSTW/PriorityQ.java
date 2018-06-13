package DataStructures.GraphW.MSTW;

/**
 * @Auther gongfukang
 * @Date 2017/12/26 10:12
 */
public class PriorityQ {
    private final int SIZE=20;
    private Edge[] queueArray;
    private int size;

    public PriorityQ(){
        queueArray=new Edge[SIZE];
        size=0;
    }

    public void insert(Edge item){
        int j;

        for(j=0;j<size;j++)
            if(item.distance>=queueArray[j].distance)
                break;

        for(int k=size-1;k>=j;k--)
            queueArray[k+1]=queueArray[k];

            queueArray[j]=item;
            size++;
    }

    public Edge removeMin(){
        return queueArray[--size];
    }

    public void removeN(int n){
        for(int j=n;j<size-1;j++)
            queueArray[j]=queueArray[j+1];
        size--;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public Edge peekN(int n){
        return queueArray[n];
    }

    public int find(int findDex){
        for(int j=0;j<size;j++)
            if(queueArray[j].destVert==findDex)
                return j;
        return -1;
    }
}
