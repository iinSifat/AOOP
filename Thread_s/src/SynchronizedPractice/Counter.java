package SynchronizedPractice;

public class Counter {
    int count;
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
