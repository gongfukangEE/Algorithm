package Graph.BFS;

/**
 * @Auther gongfukang
 * @Date 2017/12/25 18:00
 */
public class Queue {
    private final int SIZE=20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue(){
        queArray=new int[SIZE];
        front =0;
        rear=-1;
    }

    public void insert(int j){
        if(rear==SIZE-1)
            rear=-1;
        queArray[++rear]=j;
    }

    public int remove(){
        int temp=queArray[front++];
        if(front==SIZE)
            front=0;
        return temp;
    }

    public boolean isEmpty(){
        return (rear+1==front);
    }
}
