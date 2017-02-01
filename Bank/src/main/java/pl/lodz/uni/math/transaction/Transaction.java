package pl.lodz.uni.math.transaction;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.lodz.uni.math.bank.BankAccount;
import pl.lodz.uni.math.client.Client;
import pl.lodz.uni.math.exceptions.BankAccountHaveOtherOwnerException;
import pl.lodz.uni.math.exceptions.BankAccountNotExistException;

public abstract class Transaction {
	
	private Client client;
	private BankAccount bankAccount;
	private BigDecimal howMuchMoney;
	private String description;
	private Date date;
	private TransactionType transactionType;
	private Integer transactionNumber;
	private static List<Transaction> transactionHistory = new ArrayList<Transaction>();
	
	public Transaction(Client client, BankAccount bankAccount, double howMuchMoney,
			String description, TransactionType transactionType, Integer transactionNumber) {
		if(bankAccount.getClient() == null){
			throw new BankAccountNotExistException();
		}
		else if(!bankAccount.getClient().equals(client)){
			throw new BankAccountHaveOtherOwnerException();
		}
		else{
			this.client = client;
			this.bankAccount = bankAccount;
			this.howMuchMoney = new BigDecimal(howMuchMoney);
			this.description = description;
			Date date = new Date();
			this.date = date;
			this.transactionType = transactionType;
			this.transactionNumber = transactionNumber;
		}
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
		return howMuchMoney.doubleValue();
	}

	public void setHowMuchMoney(double howMuchMoney) {
		this.howMuchMoney = new BigDecimal(howMuchMoney);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	public List<Transaction> getTransactionHistory(){
		return transactionHistory;
	}
	
	public void addToTransactionHistory(Transaction transaction){
		transactionHistory.add(transaction);
	}
	
	public List<Transaction> getClientTransactionHistory(Client client){
		List<Transaction> clientTransactionHistory = new ArrayList<Transaction>();
		for (Transaction transaction : transactionHistory) {
			if(transaction.getClient().equals(client)){
				clientTransactionHistory.add(transaction);
			}
		}
		return clientTransactionHistory;
	}

	public Integer getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(Integer transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
	
	
	
	
	
	
}
