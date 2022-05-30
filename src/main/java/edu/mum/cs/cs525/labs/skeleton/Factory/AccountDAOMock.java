package edu.mum.cs.cs525.labs.skeleton.Factory;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountDAO;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDAOMock implements AccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();

	public void saveAccount(Account account) {
		accountlist.add(account); // add the new
	}

	public void updateAccount(Account account) {
		Account accountexist = loadAccount(account.getAccountNumber());
		if (accountexist != null) {
			accountlist.remove(accountexist); // remove the old
			accountlist.add(account); // add the new
		}
		System.out.println("Mock updateAccount" + account.getAccountNumber());
	}

	public Account loadAccount(String accountNumber) {
		System.out.println("Mock loadAccount" + accountNumber);
		for (Account account : accountlist) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

	public Collection<Account> getAccounts() {
		System.out.println("Mock getAccounts" );
		return accountlist;
	}

}
