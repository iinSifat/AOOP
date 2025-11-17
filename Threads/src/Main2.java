class ThreadB implements Runnable
{
    String name;

    ThreadB(String name)
    {
        this.name = name;
    }

    public void run()
    {
        for(int i=1; i<=5; i++)
        {
            System.out.println(this.name + ": " + i);
            try {
                Thread.sleep(2000);
            }
            catch(Exception e){}
        }

        System.out.println(this.name + " is over. BYEBYE!!!");
    }
}

public class Main2 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new ThreadB("Thread 1"));
        Thread t2 = new Thread(new ThreadB("Thread 2"));
        t1.start();
        t2.start();


        try
        {
            Thread.sleep(12000);
        }
        catch(Exception e){}

        System.out.println("Main Thread Over - BYE BYE!!!!");

    }

}