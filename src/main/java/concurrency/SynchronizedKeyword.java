package concurrency;

public class SynchronizedKeyword {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        SynchronizedKeyword temp = new SynchronizedKeyword();
        temp.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i<10000 ; i++) {
                    increment();
                }
                System.out.println("t1 finished!");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i<10000 ; i++) {
                    increment();
                }
                System.out.println("t2 finished!");
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join(); // join() - Thread 'main' will wait until t1 ends
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }

}
