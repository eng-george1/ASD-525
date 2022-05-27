package edu.mum.cs.cs525.labs.skeleton;

public class SavingAccStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(Account account) {
        double balance= account.getBalance();
        if (balance < 1000) return balance * .01;
        else if (balance >= 1000 && balance < 5000) return balance * .02;
        else return balance * .04;
    }
}
