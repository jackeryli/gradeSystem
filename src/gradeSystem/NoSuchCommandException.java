package gradeSystem;

public class NoSuchCommandException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchCommandException(String errorMessage) {
		super(errorMessage);
	}
}
