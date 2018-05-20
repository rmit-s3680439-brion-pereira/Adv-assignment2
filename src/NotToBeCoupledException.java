
/**
 * @author Brion Pereira
 * @createdOn 20 May 2018
 */
public class NotToBeCoupledException extends Exception {

	private String message;

	public NotToBeCoupledException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "NotToBeCoupledException [message=" + message + "]";
	}
}
