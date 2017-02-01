package pl.lodz.uni.math.transaction;

import java.math.BigDecimal;

public class Deposit extends Transaction {

	public Deposit(ValuesForTransaction valuesForTransaction) {
		super(valuesForTransaction.getClient(), valuesForTransaction.getBankAccount(), 
				valuesForTransaction.getHowMuchMoney(), valuesForTransaction.getDescription(), 
				valuesForTransaction.getTransactionType(), valuesForTransaction.getTransactionNumber());
		
		BigDecimal setAccountAmount = valuesForTransaction.getBankAccount().getAmount().add(new BigDecimal(valuesForTransaction.getHowMuchMoney()));
		valuesForTransaction.getBankAccount().setAmount(setAccountAmount);
		super.addToTransactionHistory(this);
	}
	
}
