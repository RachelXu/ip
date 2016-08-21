package action;

import logic.LogicDTO;
import logic.ProAdminPasswordLogic;
import util.Contants;
import form.AdminForm;

public class ProAdminPasswordAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private AdminForm admin1;
	private ProAdminPasswordLogic logic;

	public String execute() throws Exception {
		AdminForm admin = (AdminForm) session.get("admin");
		LogicDTO dto = logic.doLogic(admin1, admin);
		if (dto.isResult()) {
			this.addFieldError("field", "ÃÜÂëÐÞ¸Ä³É¹¦£¡");
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			return INPUT;
		}

	}

	public void validate() {
		super.validate();
		if (!admin1.getPassword1().equals(admin1.getPassword2())) {
			this.addFieldError("field", getText(Contants.E048));
		}
	}

	/**
	 * @return the admin
	 */
	public AdminForm getAdmin1() {
		return admin1;
	}

	/**
	 * @param admin
	 *            the admin to set
	 */
	public void setAdmin1(AdminForm admin) {
		this.admin1 = admin;
	}

	/**
	 * @return the logic
	 */
	public ProAdminPasswordLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProAdminPasswordLogic logic) {
		this.logic = logic;
	}

}
