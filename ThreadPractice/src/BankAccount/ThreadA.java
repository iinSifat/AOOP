package BankAccount;

public class ThreadA extends Thread{
    private BankAccount bankAccount;
    double amnt;

    public ThreadA(BankAccount bankAccount, double amnt) {
        this.bankAccount = bankAccount;
        this.amnt =amnt;
    }


    @Override
    public void run() {
        bankAccount.withdraw(amnt);
    }

}
