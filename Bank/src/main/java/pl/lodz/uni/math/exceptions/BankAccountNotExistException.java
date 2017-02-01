package pl.lodz.uni.math.exceptions;

public class BankAccountNotExistException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000000004L;

	@Override
	public String getMessage() {
		
		return "Bank account not exist";
		
	}

}