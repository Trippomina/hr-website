package hr.app.service.exception;

public class DataModificationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataModificationException() {
		super();
	}

	public DataModificationException(String message) {
		super(message);
	}

	public DataModificationException(String message, Throwable cause) {
		super(message, cause);
	}
}
