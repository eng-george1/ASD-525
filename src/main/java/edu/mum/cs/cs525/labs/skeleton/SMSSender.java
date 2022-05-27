package edu.mum.cs.cs525.labs.skeleton;

public class SMSSender implements IObserver {
    private Account account;

    public SMSSender(Account acc) {
        this.account = acc;
        acc.registerObserver(this);
    }

    @Override
    public void update() {
        double balance = account.getBalance();
        sendSMS("Account "+account.getAccountNumber()+" balance updated to: " + balance);
    }

    private void sendSMS(String message) {
        System.out.println("SMS: " + message);
    }

}
