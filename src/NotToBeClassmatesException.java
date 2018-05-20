
/**
 * @author Brion Pereira
 * @createdOn 20 May 2018
 */
public class NotToBeClassmatesException extends Exception {

	private String message;

	public NotToBeClassmatesException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "NotToBeClassmatesException [message=" + message + "]";
	}
}