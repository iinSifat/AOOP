package Tutorial1;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new ThreadA(10);
        Thread t2 = new ThreadA(5);
        t1.setName("Process-1");
        t2.setName("Process-2");


        System.out.println(t1.getState());
        t1.start();
        t2.start();
        Thread.sleep(20000);
        //t1.join();//complete the full thread
        System.out.println(t1.getState());
        System.out.println();
    }
}
