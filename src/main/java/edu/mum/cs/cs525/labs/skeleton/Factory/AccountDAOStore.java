package edu.mum.cs.cs525.labs.skeleton.Factory;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.AccountDAOImpl;
import edu.mum.cs.cs525.labs.skeleton.Factory.AccountDAOFactory;
import edu.mum.cs.cs525.labs.skeleton.Factory.AccountDAOMock;

public class AccountDAOStore implements AccountDAOFactory {
    @Override
    public  AccountDAO factoryMethod(boolean isTesting) {
        if (isTesting) {
            return new AccountDAOMock();
        } else {
            return new AccountDAOImpl();
        }
    }
}
