package WithdrawDeposit;

public class MyThread extends Thread{
    private BankSystem bankSystem;
    double amount;
    String type;

    public MyThread(BankSystem bankSystem, double amount, String type) {
        this.bankSystem = bankSystem;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public void run() {
        if(this.type.equals("Withdraw")){
            bankSystem.withdraw(amount);
        }
        else if(this.type.equals("Deposit")){
            bankSystem.deposit(amount);
        }
        else
            System.out.println("Wrong choice!");

    }
}
