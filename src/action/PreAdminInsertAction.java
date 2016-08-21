package action;

import form.AdminForm;

public class PreAdminInsertAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private AdminForm admin1;

	public String execute() throws Exception {
		admin1 = new AdminForm();
		return SUCCESS;

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

}
