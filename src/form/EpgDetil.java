package form;

import java.io.Serializable;

public class EpgDetil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4553268654062803320L;
	/** �������� */
	private String name;
	/** ������״̬ */
	private String state;
	/** ��С�����˿� */
	private Integer minPort;
	/** �������˿� */
	private Integer maxPort;
	/** ״̬Flag */
	private boolean stateFlag;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the minPort
	 */
	public Integer getMinPort() {
		return minPort;
	}

	/**
	 * @param minPort
	 *            the minPort to set
	 */
	public void setMinPort(Integer minPort) {
		this.minPort = minPort;
	}

	/**
	 * @return the maxPort
	 */
	public Integer getMaxPort() {
		return maxPort;
	}

	/**
	 * @param maxPort
	 *            the maxPort to set
	 */
	public void setMaxPort(Integer maxPort) {
		this.maxPort = maxPort;
	}

	/**
	 * @return the stateFlag
	 */
	public boolean isStateFlag() {
		return stateFlag;
	}

	/**
	 * @param stateFlag
	 *            the stateFlag to set
	 */
	public void setStateFlag(boolean stateFlag) {
		this.stateFlag = stateFlag;
	}

}
