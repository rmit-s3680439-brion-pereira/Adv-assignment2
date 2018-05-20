
/**
 * @author Brion Pereira
 * @createdOn 20 May 2018
 */
public class NotToBeFriendsException extends Exception {

	private String message;

	public NotToBeFriendsException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "NotToBeFriendsException [message=" + message + "]";
	}
}