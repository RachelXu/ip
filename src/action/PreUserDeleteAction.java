package action;

import logic.LogicDTO;
import logic.PreUserDeleteLogic;
import form.UserForm;

public class PreUserDeleteAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private UserForm userDelete;
	private String deleteId;
	private PreUserDeleteLogic logic;

	public String execute() throws Exception {
		userDelete = new UserForm();
		userDelete.initView(false);
		LogicDTO logicDTO = logic.doLogic(deleteId, userDelete);
		if (logicDTO.isResult()) {
			return SUCCESS;
		} else {
			this.addActionError(getText(logicDTO.getErrorCode()));
			return INPUT;
		}
	}

	/**
	 * @return the logic
	 */
	public PreUserDeleteLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreUserDeleteLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the userDelete
	 */
	public UserForm getUserDelete() {
		return userDelete;
	}

	/**
	 * @param userDelete
	 *            the userDelete to set
	 */
	public void setUserDelete(UserForm userDelete) {
		this.userDelete = userDelete;
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

}
