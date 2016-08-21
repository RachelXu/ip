package action;

import form.AdminForm;

public class PreLoginAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6455616220515348868L;
	private AdminForm admin;

	public String execute() throws Exception {
		return SUCCESS;
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

}
