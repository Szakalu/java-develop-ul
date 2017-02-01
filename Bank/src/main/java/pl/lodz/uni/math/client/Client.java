package pl.lodz.uni.math.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pl.lodz.uni.math.bank.BankAccount;
import pl.lodz.uni.math.exceptions.WrongClientNameException;

public class Client {
	
	private static Logger logger = Logger.getLogger(Client.class.getName());
	
	private Integer id;
	private String name;
	private List<BankAccount> bankAccountsList;
	private Integer wireoutNumber;
	
	public Client(Integer id, String name) {
		if(!checkNameLength(name) || !checkIfAllCharsAreLetters(name)){
			throw new WrongClientNameException();
		}
		else{
			this.id = id;
			this.name = name;
			this.bankAccountsList = new ArrayList<BankAccount>();
			this.wireoutNumber = 1000;
			logger.info("Client created: Id: " + id + " Name: " + name);
		}
	}
	
	public void addAccount(String number, String description){
		BankAccount bankAccount = new BankAccount(number, description, this);
		bankAccountsList.add(bankAccount);
	}
	
	private boolean checkIfAllCharsAreLetters(String name){
		
		char[] charsInNameTab = name.toCharArray();
		
		for (char nameChar : charsInNameTab) {
			if(!Character.isLetter(nameChar)){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkNameLength(String name){
		if(name.length() < 3 || name.length() > 20 ){
			return false;
		}
		return true;
	}
	
	public BankAccount getBankAccount(String number){
		BankAccount bankAccount = null;
		for (BankAccount bankAccountInList : bankAccountsList) {
			if(bankAccountInList.getNumber().equals(number)){
				bankAccount = bankAccountInList;
				return bankAccount;
			}
		}
		return new BankAccount();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BankAccount> getBankAccountsList() {
		return bankAccountsList;
	}

	public void setBankAccountsList(List<BankAccount> bankAccountsList) {
		this.bankAccountsList = bankAccountsList;
	}

	public Integer getWireoutNumber() {
		return wireoutNumber;
	}

	public void setWireoutNumber(Integer wireoutNumber) {
		this.wireoutNumber = wireoutNumber;
	}
	
	
}
