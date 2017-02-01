package pl.lodz.uni.math.transaction;

import java.math.BigDecimal;

import pl.lodz.uni.math.bank.BankAccount;
import pl.lodz.uni.math.exceptions.BankAccountNotEnoughMoneyException;
import pl.lodz.uni.math.exceptions.BankAccountNotExistException;

public class Wireout extends Transaction{
	private String country;
	private String swift;
	private BankAccount toAccount;
	
	
	public Wireout(ValuesForTransaction valuesForTransaction, BankAccount toAccount, String country, String swift ) {
		super(valuesForTransaction.getClient(), valuesForTransaction.getBankAccount(), 
				valuesForTransaction.getHowMuchMoney(), valuesForTransaction.getDescription(), 
				valuesForTransaction.getTransactionType(), valuesForTransaction.getTransactionNumber());
		if(toAccount.getClient() == null){
			throw new BankAccountNotExistException();
		}
		else{
			if(valuesForTransaction.getBankAccount().getAmount().doubleValue() < valuesForTransaction.getHowMuchMoney()){
				throw new BankAccountNotEnoughMoneyException();
			}
			else{
				this.country = country;
				this.swift = swift;
				this.toAccount = toAccount;
				
				BigDecimal setSenderAccountAmount = valuesForTransaction.getBankAccount().getAmount().subtract(new BigDecimal(valuesForTransaction.getHowMuchMoney()));
				valuesForTransaction.getBankAccount().setAmount(setSenderAccountAmount);
				
				BigDecimal setGetterAccountAmount = toAccount.getAmount().add(new BigDecimal(valuesForTransaction.getHowMuchMoney()));
				toAccount.setAmount(setGetterAccountAmount);
				
				super.addToTransactionHistory(this);
			}
		}
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getSwift() {
		return swift;
	}


	public void setSwift(String swift) {
		this.swift = swift;
	}


	public BankAccount getToAccount() {
		return toAccount;
	}


	public void setToAccount(BankAccount toAccount) {
		this.toAccount = toAccount;
	}
	
	

}
