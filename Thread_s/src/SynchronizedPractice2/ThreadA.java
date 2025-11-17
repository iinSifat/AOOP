package SynchronizedPractice2;

import SynchronizedPractice.Counter;

public class ThreadA extends  Thread{

    private Counter counter;

    public ThreadA(Counter counter) {
        this.counter = counter;
    }

    public ThreadA(SynchronizedPractice2.Counter counter) {
    }

    @Override
    public void run() {
        for(int i = 0; i<1000; i++){
            counter.increment();
        }
    }
}
