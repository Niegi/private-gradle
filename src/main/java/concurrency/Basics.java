package concurrency;

public class Basics {
    public static void main(String[] args) {
        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();

        Thread t1 = new Thread(new Runner2());
        Thread t2 = new Thread(new Runner2());
        t1.start();
        t2.start();
    }
}

class Runner extends Thread {

    public void run() {
        for (int i=0 ; i<10; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner2 implements Runnable {

    @Override
    public void run() {
        for (int i=0 ; i<10; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}