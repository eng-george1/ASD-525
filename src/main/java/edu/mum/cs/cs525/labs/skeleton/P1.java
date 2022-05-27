package edu.mum.cs.cs525.labs.skeleton;

public class P1 extends InterestPromotionDecorator {
    P1(InterestStrategy interestStrategy){
        super(interestStrategy);
          }
    @Override
    public double calculateInterest(Account account) {
        return getInterestStrategy().calculateInterest(account) + account.getBalance() * 0.1;
    }
}
