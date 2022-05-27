package edu.mum.cs.cs525.labs.skeleton;

public class P3 extends InterestPromotionDecorator {
    P3(InterestStrategy interestStrategy){
        super(interestStrategy);
    }
    @Override
    public double calculateInterest(Account account) {
        return getInterestStrategy().calculateInterest(account) + account.getBalance() * 0.3;
    }
}
