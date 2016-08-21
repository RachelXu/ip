package action;

import logic.ProMediaDeleteLogic;

public class ProMediaDeleteAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private String deleteId;
	private ProMediaDeleteLogic logic;

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
	public ProMediaDeleteLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProMediaDeleteLogic logic) {
		this.logic = logic;
	}

}
