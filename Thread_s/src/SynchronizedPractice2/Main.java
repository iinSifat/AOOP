package SynchronizedPractice2;

public class Main {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        ThreadA t1 = new ThreadA(counter);
        ThreadA t2 = new ThreadA(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count :"+ counter.getCount());
    }

}
