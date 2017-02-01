package pl.lodz.uni.math.transaction;


import java.math.BigDecimal;

import pl.lodz.uni.math.exceptions.BankAccountNotEnoughMoneyException;

public class Check extends Transaction{

	public Check(ValuesForTransaction valuesForTransaction) {
		super(valuesForTransaction.getClient(), valuesForTransaction.getBankAccount(), 
				valuesForTransaction.getHowMuchMoney(), valuesForTransaction.getDescription(), 
				valuesForTransaction.getTransactionType(), valuesForTransaction.getTransactionNumber());
		if(valuesForTransaction.getBankAccount().getAmount().doubleValue() < valuesForTransaction.getHowMuchMoney()){
			throw new BankAccountNotEnoughMoneyException();
		}
		else{
			BigDecimal setAccontAmount = valuesForTransaction.getBankAccount().getAmount().subtract(new BigDecimal(valuesForTransaction.getHowMuchMoney()));
			valuesForTransaction.getBankAccount().setAmount(setAccontAmount);
			super.addToTransactionHistory(this);
		}
	}

}
