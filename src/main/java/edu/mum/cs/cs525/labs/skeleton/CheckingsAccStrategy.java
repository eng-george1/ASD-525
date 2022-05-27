package edu.mum.cs.cs525.labs.skeleton;

public class CheckingsAccStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(Account account) {
        double balance= account.getBalance();
        if (balance < 1000) return balance * .015;
        else return balance * .025;
    }
}
