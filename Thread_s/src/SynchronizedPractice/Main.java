package SynchronizedPractice;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new CountThread(counter);
        Thread t2 = new CountThread(counter);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count :" + counter.getCount());


    }
}
