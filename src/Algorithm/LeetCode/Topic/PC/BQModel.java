package Algorithm.LeetCode.Topic.PC;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther G.Fukang
 * @date 5/15 10:23
 */
public class BQModel {

    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        // 线程池
        ExecutorService service = Executors.newFixedThreadPool(15);
        // 生产者线程
        for (int i = 0; i < 5; i++) {
            service.submit(new product());
        }
        // 消费者
        for (int i = 0; i < 10; i++) {
            service.submit(new consumer());
        }
    }

    // 生产者
    private static class product implements Runnable {
        @Override
        public void run() {

            try {
                while (true) {
                    // 不定期生产，随机模拟的用户请求
                    Thread.sleep((long) (Math.random() * 500));
                    // 生产
                    Integer num = count.getAndIncrement();
                    // 放入阻塞队列
                    queue.put(num);
                    // 打印
                    System.out.println("Product: " + num);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费者
    private static class consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                    Thread.sleep(500 + (long)(Math.random() * 500));
                    // 消费
                    Integer num = queue.take();
                    // 输出
                    System.out.println("Consumer: " + num);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
