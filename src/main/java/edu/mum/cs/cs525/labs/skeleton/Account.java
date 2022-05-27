package edu.mum.cs.cs525.labs.skeleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Account implements  IObservable{
	private Customer customer;

	private String accountNumber;
	private List<IObserver> observers = new ArrayList<IObserver>();
	private List<AccountEntry> entryList = new ArrayList<AccountEntry>();
private  InterestStrategy interestStrategy;
	public Account(String accountNumber,InterestStrategy interestStrategy) {
		this.accountNumber = accountNumber;
		this.interestStrategy=interestStrategy;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
		entryList.add(entry);
		notifyAllObservers();
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
		entryList.add(entry);
		notifyAllObservers();
	}

	private void addEntry(AccountEntry entry) {
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		
		entryList.add(fromEntry);
		
		toAccount.addEntry(toEntry);
		notifyAllObservers();
		toAccount.notifyAllObservers();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	public void addInterest() {
		double interest = this.interestStrategy.calculateInterest(this);
		AccountEntry entry = new AccountEntry(interest, "added interest", "", "");
		entryList.add(entry);
	}

	@Override
	public void registerObserver(IObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyAllObservers() {
		observers.forEach(IObserver::update);
	}
}
