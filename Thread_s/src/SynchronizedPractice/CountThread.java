package SynchronizedPractice;

public class CountThread extends Thread{
    private Counter counter;

    public CountThread(Counter counter) {
        this.counter = counter;
    }

    public void run(){
        for(int i = 0; i<1000; i++){
           counter.increment();
        }
    }


}
