package Synchronized;

public class Main {
    public static void main(String[] args) throws Exception{
                Counter counter = new Counter();
                Thread t1 = new CounterThread(counter);
                Thread t2 = new CounterThread(counter);

                t1.start();
                t2.start();
                t1.join();
                t2.join();
                System.out.println("Count :" + counter.getCount());


            }
        }