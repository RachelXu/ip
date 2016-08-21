package action;

import logic.ProCardDeleteLogic;

public class ProCardDeleteAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private String deleteId;
	private ProCardDeleteLogic logic;

	public String execute() throws Exception {
		logic.doLogic(deleteId);
		return SUCCESS;

	}

	/**
	 * @return the deleteId
	 */
	public String getDeleteId() {
		return deleteId;
	}

	/**
	 * @param deleteId
	 *            the deleteId to set
	 */
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}

	/**
	 * @return the logic
	 */
	public ProCardDeleteLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProCardDeleteLogic logic) {
		this.logic = logic;
	}

}
