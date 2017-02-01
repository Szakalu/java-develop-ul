package pl.lodz.uni.math.bank;

import java.math.BigDecimal;

import pl.lodz.uni.math.client.Client;
import pl.lodz.uni.math.exceptions.EmptyBankAccountDescriptionException;
import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;

public class BankAccount {

	private String number;
	private String description;
	private Client client;
	private BigDecimal amount;
	private Integer depositNumber;
	private Integer checkNumber;
	
	public BankAccount(){
		this.description = "No Account";
	}
	
	public BankAccount(String number, String description, Client client){
		if(!checkBankAccountNumberLength(number) || !validBankAccountNumber(number)){
			throw new WrongBankAccountNumberException();
		}
		else if(description == ""){
			throw new EmptyBankAccountDescriptionException();
		}
		else{
			this.number = number;
			this.description = description;
			this.client = client;
			this.amount = new BigDecimal(0);
			this.depositNumber = 10000;
			this.checkNumber = 1000;
		}
	}
	
	private boolean validBankAccountNumber(String number){
		char[] numbersTab = number.toCharArray();
		for (char charInNumberTab : numbersTab) {
			if(Character.isAlphabetic(charInNumberTab)){
				return false;
			}
		}
		return true;
	}
	
	private boolean checkBankAccountNumberLength(String number){
		if(number.length()!=15){
			return false;
		}
		return true;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getDepositNumber() {
		return depositNumber;
	}

	public void setDepositNumber(Integer depositNumber) {
		this.depositNumber = depositNumber;
	}

	public Integer getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(Integer checkNumber) {
		this.checkNumber = checkNumber;
	}
	
	
}
