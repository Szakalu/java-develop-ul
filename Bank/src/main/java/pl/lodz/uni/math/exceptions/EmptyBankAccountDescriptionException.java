package pl.lodz.uni.math.exceptions;

public class EmptyBankAccountDescriptionException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000000003L;

	@Override
	public String getMessage() {
		
		return "Bank account description is null or empty";
		
	}

}