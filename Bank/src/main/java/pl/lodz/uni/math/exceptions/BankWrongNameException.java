package pl.lodz.uni.math.exceptions;

public class BankWrongNameException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000000010L;

	@Override
	public String getMessage() {
		
		return "Bank name is wrong";
		
	}

}