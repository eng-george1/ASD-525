package edu.mum.cs.cs525.labs.skeleton;

public class P2 extends InterestPromotionDecorator {
    P2(InterestStrategy interestStrategy){
        super(interestStrategy);
    }
    @Override
    public double calculateInterest(Account account) {
        return getInterestStrategy().calculateInterest(account) + account.getBalance() * 0.2;
    }
}
