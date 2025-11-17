package BankAccount;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount account = new BankAccount(1000.0);


        ThreadA t1 = new ThreadA(account,400.0);
        ThreadA t2 = new ThreadA(account,700.0);
        t1.setName("Thread-1");
        t2.setName("Thread-2");

//        account.withdraw(400);
//        account.withdraw(700.0);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final account balance :"+ account.getAmount());








    }
}
