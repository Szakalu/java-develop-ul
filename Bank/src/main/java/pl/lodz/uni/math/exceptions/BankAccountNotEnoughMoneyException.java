package pl.lodz.uni.math.exceptions;

public class BankAccountNotEnoughMoneyException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000000006L;

	@Override
	public String getMessage() {
		
		return "Not enough money";
		
	}

}