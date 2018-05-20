
/**
 * @author Abhilash Nunes
 * @createdOn 21 May 2018
 */
public class NoSuchAgeException extends Exception {
	private String message;

	public NoSuchAgeException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "NoSuchAgeException [message=" + message + "]";
	}
}