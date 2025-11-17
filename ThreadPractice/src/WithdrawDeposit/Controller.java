package WithdrawDeposit;

public class Controller {
    public static void main(String[] args) throws InterruptedException{
        BankSystem system = new BankSystem(10000.0);
        Thread t1= new MyThread(system,4000.0,"Deposit");
        t1.setName("Person-1");
        Thread t2 = new MyThread(system,15000.0,"Withdraw");
        t2.setName("Person-2");
        Thread t3 = new MyThread(system,3000,"Withdraw");
        t3.setName("Person-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final balance = "+ system.getBalance());


    }
}
