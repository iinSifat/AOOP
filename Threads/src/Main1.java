class ThreadA extends Thread
{
    public ThreadA(String name)
    {
        super(name);
    }

    public void run()
    {
        for(int i=1; i<=5; i++)
        {
            System.out.println(this.getName() + ": " + i);
            try {
                Thread.sleep(2000);
            }
            catch(Exception e){}
        }

        System.out.println(this.getName() + " is over. BYEBYE!!!");
    }
}

public class Main1 {

    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("Thread 1");
        ThreadA t2 = new ThreadA("Thread 2");
        t1.start();
        t2.start();
    }
}