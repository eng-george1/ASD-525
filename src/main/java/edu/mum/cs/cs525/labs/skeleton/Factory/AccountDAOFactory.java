package edu.mum.cs.cs525.labs.skeleton.Factory;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;

public interface AccountDAOFactory {
   AccountDAO factoryMethod(boolean isTesting);
  public   default  AccountDAO createDAO(boolean isTesting) {
      return factoryMethod(isTesting);
  }
}
