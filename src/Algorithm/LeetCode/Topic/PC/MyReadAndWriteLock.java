package Algorithm.LeetCode.Topic.PC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther G.Fukang
 * @date 6/6 15:55
 */
public class MyReadAndWriteLock {

    private AtomicInteger readCount = new AtomicInteger(0);
    private AtomicInteger writeCount = new AtomicInteger(0);

    public static void main(String[] args) {
        MyReadAndWriteLock myReadAndWriteLock = new MyReadAndWriteLock();
        for (int i = 0; i < 2; i++) {
            WriteThread writeThread = new WriteThread(new AtomicInteger(i), myReadAndWriteLock);
            writeThread.start();
        }
        for (int j = 0; j < 3; j++) {
            ReadThread readThread = new ReadThread(new AtomicInteger(j), myReadAndWriteLock);
            readThread.start();
        }
    }

    private static class ReadThread extends Thread {
        public AtomicInteger i = new AtomicInteger(0);
        public MyReadAndWriteLock myReadAndWriteLock;

        public ReadThread(AtomicInteger i, MyReadAndWriteLock myReadAndWriteLock) {
            this.i = i;
            this.myReadAndWriteLock = myReadAndWriteLock;
        }

        @Override
        public void run() {
            try {
                // 读加锁
                myReadAndWriteLock.lockRead();
                Thread.sleep(1000);
                System.out.println("*************** 模拟执行读取任务，编号为: " + i.get() + " ************");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                myReadAndWriteLock.unLockRead();
            }
        }
    }

    private static class WriteThread extends Thread {
        public AtomicInteger i = new AtomicInteger(0);
        public MyReadAndWriteLock myReadAndWriteLock;

        public WriteThread(AtomicInteger i, MyReadAndWriteLock myReadAndWriteLock) {
            this.i = i;
            this.myReadAndWriteLock = myReadAndWriteLock;
        }

        @Override
        public void run() {
            try {
                // 写加锁
                myReadAndWriteLock.lockWrite();
                Thread.sleep(1000);
                System.out.println("*************** 模拟执行写入任务，编号为: " + i.get() + " ************");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                myReadAndWriteLock.unLockWrite();
            }
        }
    }

    public void lockRead() throws InterruptedException {
        while (writeCount.get() > 0) {
            synchronized (this) {
                wait();
            }
        }
        // 执行读取操作
        readCount.getAndIncrement();
        System.out.println("执行读取操作");
    }

    public void unLockRead() {
        readCount.getAndDecrement();
        synchronized (this) {
            notifyAll();
        }
    }

    public void lockWrite() throws InterruptedException {
        while (writeCount.get() > 0) {
            synchronized (this) {
                wait();
            }
        }
        writeCount.getAndIncrement();
        while (readCount.get() > 0) {
            synchronized (this) {
                wait();
            }
        }
        // 执行写操作
        System.out.println("执行写操作");
    }

    public void unLockWrite() {
        writeCount.getAndDecrement();
        synchronized (this) {
            notifyAll();
        }
    }
}
