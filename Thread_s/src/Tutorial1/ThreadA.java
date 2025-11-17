package Tutorial1;

public class ThreadA extends Thread {
    int n;

    public ThreadA(int n) {
        this.n = n;
    }

    public void run(){
        try {
            for(int   i =0 ; i<n; i++){
                System.out.println(i);
                ThreadA.sleep(1000);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getName()+" is over!");

    }

}
