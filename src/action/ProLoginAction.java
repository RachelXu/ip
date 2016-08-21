package action;

import logic.LogicDTO;
import logic.ProLoginLogic;
import form.AdminForm;

public class ProLoginAction extends MySuperAction {

	private static final long serialVersionUID = 4092783777260587307L;

	private AdminForm admin;

	private ProLoginLogic logic;

	public String execute() throws Exception {
		LogicDTO dto = logic.doLogic(admin);
		if (dto.isResult()) {
			this.request.getSession().setAttribute("admin", admin);
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			return INPUT;
		}
	}

	public void validate() {
		super.validate();
	}

	/**
	 * @return the admin
	 */
	public AdminForm getAdmin() {
		return admin;
	}

	/**
	 * @param admin
	 *            the admin to set
	 */
	public void setAdmin(AdminForm admin) {
		this.admin = admin;
	}

	/**
	 * @return the logic
	 */
	public ProLoginLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProLoginLogic logic) {
		this.logic = logic;
	}

}
