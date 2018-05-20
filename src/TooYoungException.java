
/**
 * @author Brion Pereira
 * @createdOn 20 May 2018
 */
public class TooYoungException extends Exception {

	private String message;

	public TooYoungException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "TooYoungException [message=" + message + "]";
	}
}