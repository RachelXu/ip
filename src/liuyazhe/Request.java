package liuyazhe;
import java.io.Serializable;
import java.util.Date;

/**
 * «Î«Û¿‡
 * 
 * @author ÷£‘√
 */
public class Request implements Serializable {

	private static final long serialVersionUID = -7462613856945751168L;
	private byte requestId;
	private String message;
	private Date date;

	/**
	 * @return the requestId
	 */
	public byte getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 *            the requestId to set
	 */
	public void setRequestId(byte requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
