package Queue;

/**
 * @Auther gongfukang
 * @Date 2017/12/5 9:07
 */
public class PriorityQ {
    private int maxSize;
    private long[] queArray;
    private int Items;

    public PriorityQ(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        Items = 0;
    }

    public void insert(long item) {
        int j;

        if (Items == 0) {
            queArray[Items++] = item;
        } else {
            for (j = Items - 1; j >= 0; j--) {
                if (item > queArray[j])
                    queArray[j + 1] = queArray[j];
                else
                    break;
            }
            queArray[j+1]=item;
            Items++;
        }
    }

    public long remove(){
        return queArray[--Items];
    }

    public long peekMin(){
        return queArray[Items-1];
    }

    public boolean isEmpty(){
        return (Items==0);
    }

    public boolean isFull(){
        return (Items==maxSize);
    }
}
