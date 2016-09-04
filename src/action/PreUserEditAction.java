package action;

import logic.LogicDTO;
import logic.PreUserEditLogic;
import form.UserForm;

public class PreUserEditAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private UserForm userEdit;
	private String itemId;
	private PreUserEditLogic logic;

	public String execute() throws Exception {
		userEdit = new UserForm();
		userEdit.initView(false);
		LogicDTO logicDTO = logic.doLogic(itemId, userEdit);
		if (logicDTO.isResult()) {
			return SUCCESS;
		} else {
			this.addActionError(getText(logicDTO.getErrorCode()));
			return INPUT;
		}
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the logic
	 */
	public PreUserEditLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreUserEditLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the userEdit
	 */
	public UserForm getUserEdit() {
		return userEdit;
	}

	/**
	 * @param userEdit
	 *            the userEdit to set
	 */
	public void setUserEdit(UserForm userEdit) {
		this.userEdit = userEdit;
	}

}
