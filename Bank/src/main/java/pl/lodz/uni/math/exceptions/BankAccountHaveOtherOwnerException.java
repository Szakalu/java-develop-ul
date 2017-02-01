package pl.lodz.uni.math.exceptions;

public class BankAccountHaveOtherOwnerException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000000005L;

	@Override
	public String getMessage() {
		
		return "This is not your bank account";
		
	}

}