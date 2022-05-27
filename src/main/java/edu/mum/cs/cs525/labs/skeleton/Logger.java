package edu.mum.cs.cs525.labs.skeleton;

public class Logger implements IObserver {

    private Account account ;

    public Logger(Account acc) {
        this.account = acc;
        acc.registerObserver(this);
    }

    @Override
    public void update() {
        double balance = account.getBalance();
        log("Account "+account.getAccountNumber()+" balance updated to: " + balance);
    }

    private void log(String message) {
        System.out.println("Log: " + message);
    }

}
