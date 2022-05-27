package edu.mum.cs.cs525.labs.skeleton;

public abstract class InterestPromotionDecorator implements InterestStrategy {
   private InterestStrategy interestStrategy;

    public InterestPromotionDecorator(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    protected InterestStrategy getInterestStrategy() {
        return interestStrategy;
    }

}
