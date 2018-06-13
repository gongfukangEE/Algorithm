package Sort.Advanced_Sort.HeapSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther gongfukang
 * @Date 2017/12/24 19:54
 */
public class HeapApp {
    public static void main(String[] args) throws IOException {
        int size,j;
        System.out.print("enter number of items ");
        size=getInt();
        Heap theHeap=new Heap(size);

        for(j=0;j<size;j++){
            int random= (int)(Math.random()*100);
            Node newNode=new Node(random);
            theHeap.insertAt(j,newNode);
            theHeap.increamentSize();
        }

        System.out.print("Random: ");
        theHeap.displayArray();

        for(j=size/2-1;j>=0;j--)
            theHeap.trickleDown(j);

        System.out.print("Heap:  ");
        theHeap.displayArray();
        theHeap.displayHeap();

        for(j=size-1;j>=0;j--){
            Node biggestNode=theHeap.remove();
            theHeap.insertAt(j,biggestNode);
        }

        System.out.print("Sorted: ");
        theHeap.displayArray();
    }

    public static String getString() throws IOException {
        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String s=bufferedReader.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s=getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s=getString();
        return Integer.parseInt(s);
    }
}
