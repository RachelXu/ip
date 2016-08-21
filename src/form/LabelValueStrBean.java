package form;

import java.io.Serializable;

public class LabelValueStrBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3017749761169075517L;
	private String label;
	private String value;

	public LabelValueStrBean(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

}
