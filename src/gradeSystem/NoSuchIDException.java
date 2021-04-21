package gradeSystem;

public class NoSuchIDException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchIDException(String errorMessage) {
		super(errorMessage);
	}
}
