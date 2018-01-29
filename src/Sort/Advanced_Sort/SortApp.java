package Sort.Advanced_Sort;

/**
 * @Auther gongfukang
 * @Date 2018/1/29 13:48
 */
public class SortApp {
    public static void main(String[] args) {
        int maxSize = 10;
        ShellSort shellSort = new ShellSort(maxSize);

        for(int j=0;j<maxSize;j++){
            long n=(int)(Math.random()*99);
            shellSort.insert(n);
        }

        shellSort.display();
        shellSort.shellSort();
        shellSort.display();
    }
}
