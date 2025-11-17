package WithdrawDeposit;

public class BankSystem {
    double balance;
//    String s;
    public BankSystem(double balance) {
        this.balance = balance;
//        this.s = s;
    }

    public synchronized void withdraw(double withdrawal_balance) {
        if (withdrawal_balance <= balance) {
            System.out.println(Thread.currentThread().getName()+":");
            System.out.println( " Balance is " + balance);
            System.out.println(Thread.currentThread().getName() + " trying to withdraw is " + withdrawal_balance);
            System.out.println("Withdrawal Approved!");
            balance -= withdrawal_balance;
            System.out.println("Updated balance :" + balance);

        }
        else {
            System.out.println(Thread.currentThread().getName()+" has not sufficient balance.");
        }
    }

    public synchronized void deposit(double deposit_balance){
        System.out.println(Thread.currentThread().getName()+":");

        System.out.println(Thread.currentThread().getName() + " Balance is " + balance);
        System.out.println(Thread.currentThread().getName() + " Depositing is " + deposit_balance);
        balance+=deposit_balance;
        System.out.println("Updated balance :" + balance);
    }

    public double getBalance() {
        return balance;
    }
}
