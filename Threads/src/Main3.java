public class Main3 {

    public static void main(String[] args) {

        ThreadA t1 = new ThreadA("Thread 1");
        ThreadA t2 = new ThreadA("Thread 2");
        Thread mainThread = Thread.currentThread();  // To get the main thread

        System.out.println(t1.getName() + " : " + t1.getState());  // getState() gives the state of the thread - NEW means created but not running
        System.out.println(t2.getName() + " : " + t2.getState());
        System.out.println(mainThread.getName() + " : " + mainThread.getState());

        t1.start();
        t2.start();

        System.out.println(t1.getName() + " : " + t1.getState()); // RUNNABLE means the thread is active and can be picked by the cpu for running, or is running
        System.out.println(t2.getName() + " : " + t2.getState());
        System.out.println(mainThread.getName() + " : " + mainThread.getState());

        try
        {
            t1.join(); // t1.join() ensures that t1 thread is complete before the code moves to the next line
            t2.join();
        }
        catch(Exception e){}

        System.out.println(t1.getName() + " : " + t1.getState()); // TERMINATED means the thread is over
        System.out.println(t2.getName() + " : " + t2.getState());
        System.out.println(mainThread.getName() + " : " + mainThread.getState());

        System.out.println("Main thread over - byebye!!!");

    }

}