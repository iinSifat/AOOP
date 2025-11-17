package BankAccount;

public class BankAccount {

    Double amount;

    public BankAccount(Double amount) {
        this.amount = amount;
    }

    public synchronized void withdraw(double withdraw_amnt){
        if(withdraw_amnt <= amount ){
            System.out.println(Thread.currentThread().getName()+" is withdrawing amount:"+ withdraw_amnt);
            amount-= withdraw_amnt;
            System.out.println(Thread.currentThread().getName() + " has withdrawal."+" Remaining Balance :"+amount);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " tried withdrawal "+ withdraw_amnt+ " But insufficient");
        }
    }

    public double getAmount(){
        return amount;
    }
}
