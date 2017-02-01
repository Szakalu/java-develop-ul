package pl.lodz.uni.math.transaction;

import pl.lodz.uni.math.bank.BankAccount;
import pl.lodz.uni.math.client.Client;

public class ValuesForTransaction {
	private Client client;
	private BankAccount bankAccount;
	private double howMuchMoney;
	private TransactionType transactionType;
	private Integer transactionNumber;
	private String description;
	
	public ValuesForTransaction(Client client, BankAccount bankAccount, double howMuchMoney,
			String description, TransactionType transactionType, Integer transactionNumber) {
		this.client = client;
		this.bankAccount = bankAccount;
		this.howMuchMoney = howMuchMoney;
		this.transactionType = transactionType;
		this.transactionNumber = transactionNumber;
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public double getHowMuchMoney() {
		return howMuchMoney;
	}

	public void setHowMuchMoney(double howMuchMoney) {
		this.howMuchMoney = howMuchMoney;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(Integer transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
