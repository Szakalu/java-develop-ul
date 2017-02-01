package pl.lodz.uni.math.exceptions;

public class WrongBankAccountNumberException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000000002L;

	@Override
	public String getMessage() {
		
		return "Wrong bank account number";
		
	}

}