package edu.mum.cs.cs525.labs.skeleton;

public class EmailSender implements IObserver {
    private Account account;

    public EmailSender(Account acc) {
        this.account = acc;
        acc.registerObserver(this);
    }

    @Override
    public void update() {
        double balance = account.getBalance();
        sendEmail("Account "+account.getAccountNumber()+" balance updated to: " + balance);
    }

    private void sendEmail(String message) {
        System.out.println("Email: " + message);
    }

}
