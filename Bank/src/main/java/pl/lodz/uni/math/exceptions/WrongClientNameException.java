package pl.lodz.uni.math.exceptions;

public class WrongClientNameException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000000000L;

	@Override
	public String getMessage() {
		
		return "Wrong client name";
		
	}

}
