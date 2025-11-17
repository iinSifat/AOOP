class BankAccount {
    private int balance;

    // Constructor to initialize the balance
    public BankAccount(int balance) {
        this.balance = balance;
    }

    // Synchronized method to withdraw money from the account
    public synchronized void withdraw(int amount) {
        // Check if enough funds are available
        if (amount <= balance) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing: " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient balance.");
        }
    }

    // Getter to return the current balance
    public int getBalance() {
        return balance;
    }
}

public class SynchronizedWithdrawalExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a bank account with an initial balance of 1000
        BankAccount account = new BankAccount(1000);

        // Create threads to simulate withdrawals
        Thread t1 = new Thread(() -> {
            account.withdraw(400);  // Attempt to withdraw 700
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            account.withdraw(700);  // Attempt to withdraw 400
        }, "Thread 2");

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Final balance after all withdrawals
        System.out.println("Final account balance: " + account.getBalance());
    }
}
