package action;

import logic.ProUserEditLogic;
import util.CommonUtil;
import util.Contants;
import form.UserForm;

public class ProUserEditAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private UserForm userEdit;
	private ProUserEditLogic logic;

	public String execute() throws Exception {
		logic.doLogic(userEdit);
		return SUCCESS;

	}

	public void validate() {
		super.validate();
		if (!CommonUtil.isEmpty(userEdit.getRestDay())
				&& !CommonUtil.isNumber(userEdit.getRestDay())) {
			this.addFieldError("field", getText(Contants.E009));
		}
		userEdit.initView(false);
	}

	/**
	 * @return the logic
	 */
	public ProUserEditLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProUserEditLogic logic) {
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
