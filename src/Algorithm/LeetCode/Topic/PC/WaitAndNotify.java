package Algorithm.LeetCode.Topic.PC;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther G.Fukang
 * @date 5/15 10:56
 */
public class WaitAndNotify {

    private static final Object BUFFER_LOCK = new Object();
    private static final Queue<Integer> queue = new LinkedList<Integer>();
    private static final int MAX = 3;
    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(new product());
        }
        for (int i = 0; i < 10; i++) {
            service.submit(new consumer());
        }
    }

    // 生产者
    private static class product implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    // 不定期生产，模拟随机的用户请求
                    Thread.sleep((long) (Math.random() * 1000));
                    // 加锁
                    synchronized (BUFFER_LOCK) {
                        // buffer 满了
                        while (queue.size() == MAX) {
                            BUFFER_LOCK.wait();
                        }
                        // 生产
                        int num = count.getAndIncrement();
                        queue.add(num);
                        System.out.println("Product: " + num);
                        // 唤醒其他线程
                        BUFFER_LOCK.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 消费者
    private static class consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                    Thread.sleep(500 + (long) (Math.random() * 500));
                    // 加锁
                    synchronized (BUFFER_LOCK) {
                        // buffer 为 空
                        while (queue.size() == 0) {
                            BUFFER_LOCK.wait();
                        }
                        // 消费
                        int num = queue.poll();
                        System.out.println("Consumer: " + num);
                        // 唤醒其他线程
                        BUFFER_LOCK.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
