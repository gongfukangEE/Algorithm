package Algorithm.LeetCode.Topic.PC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther G.Fukang
 * @date 5/15 12:29
 */
public class LockCondition {

    private static final Lock BUFFER_LOCK = new ReentrantLock();
    private static final Condition BUFFER_COND = BUFFER_LOCK.newCondition();
    private static final Queue<Integer> queue = new LinkedList<>();
    private static AtomicInteger count = new AtomicInteger(0);
    private static final Integer MAX = 10;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(new product());
        }
        for (int i = 0; i < 10; i++) {
            service.submit(new consume());
        }
    }

    // 消费者
    private static class consume implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                    Thread.sleep(500 + (long) (Math.random() * 500));
                    // 加锁
                    BUFFER_LOCK.lock();
                    while (queue.size() == 0) {
                        BUFFER_COND.await();
                    }
                    // 消费
                    int num = queue.poll();
                    System.out.println("Consuemer:" + num);
                    BUFFER_COND.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    BUFFER_LOCK.unlock();
                }
            }
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
                    BUFFER_LOCK.lock();
                    while (queue.size() == MAX) {
                        BUFFER_COND.await();
                    }
                    int num = count.getAndIncrement();
                    queue.offer(num);
                    System.out.println("Product: " + num);
                    BUFFER_COND.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    BUFFER_LOCK.unlock();
                }
            }
        }
    }
}
