package concurrency;

import java.util.LinkedList;
import java.util.Random;

public class LowLevelSync {
    public static void main(String[] args) throws InterruptedException {
        final ProcessorSync processor = new ProcessorSync();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException ignored) {}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

class ProcessorSync {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {

        int value = 0;

        while(true) {

            synchronized (lock) {

                while(list.size() == LIMIT) {
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {

        Random random = new Random();

        while(true) {

            synchronized (lock) {

                while(list.size() == 0) {
                    wait();
                }

                System.out.println("List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
            }

            Thread.sleep(random.nextInt(1000));
        }
    }

}