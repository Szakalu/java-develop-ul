package pl.lodz.uni.math.bank;

import java.util.ArrayList;

import pl.lodz.uni.math.client.Client;
import pl.lodz.uni.math.exceptions.BankWrongNameException;

public class Bank {
	
	private String name;
	private ArrayList<Client> clientsList;
	
	public Bank(String name){
		if(checkIfAllCharsAreLetters(name)){
			this.name = name;
			clientsList = new ArrayList<Client>();
		}
		else{
			throw new BankWrongNameException();
		}
	}
	
	public void addClient(Client client){
		if(!checkIfClientInBank(client)){
			clientsList.add(client);
		}
	}
	
	public void removeClient(Client client){
		if(checkIfClientInBank(client)){
			clientsList.remove(client);
		}
	}
	
	private boolean checkIfClientInBank(Client client){
		for (Client clientInBank : clientsList) {
			if(clientInBank.equals(client)){
				return true;
			}
		}
		return false;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Client> getClientsList() {
		return clientsList;
	}

	public void setClientsList(ArrayList<Client> clientsList) {
		this.clientsList = clientsList;
	}
	
	
}
