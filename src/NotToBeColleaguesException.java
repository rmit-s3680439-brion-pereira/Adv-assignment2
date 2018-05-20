
/**
 * @author Brion Pereira
 * @createdOn 20 May 2018
 */
public class NotToBeColleaguesException extends Exception {

	private String message;

	public NotToBeColleaguesException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "NotToBeColleaguesException [message=" + message + "]";
	}
}
