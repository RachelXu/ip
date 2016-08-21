package liuyazhe;
import java.io.Serializable;
import java.util.Date;

/**
 * ÏìÓ¦Àà
 * 
 * @author Ö£ÔÃ
 */
public class Response implements Serializable {

	private static final long serialVersionUID = -7313770879382170604L;
	private String result;
	private Date date;

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
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
