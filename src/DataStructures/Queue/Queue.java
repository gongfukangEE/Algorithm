package DataStructures.Queue;

/**
 * @Auther gongfukang
 * @Date 2017/12/4 22:41
 */
public class Queue {
    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;
    private int Items;

    public Queue(int s){
        maxSize=s;
        queueArray=new long[maxSize];
        front=0;
        rear=-1;
        Items=0;
    }

    public void insert(long j){
        if(rear==maxSize){
            rear=-1;
        }
        queueArray[++rear]=j;
        Items++;
    }

    public long remove(){
        long temp=queueArray[front++];
        if(front==maxSize)
            front=0;
        Items--;
        return temp;
    }

    public long peekFront(){
        return queueArray[front];
    }

    public boolean isEmpty(){
        return (Items==0);
    }

    public boolean isFull(){
        return (Items==maxSize);
    }

    public int size(){
        return Items;
    }
}
