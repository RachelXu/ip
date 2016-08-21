package action;

import form.UserForm;

public class PreUserBatchEditAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private UserForm user;

	public String execute() throws Exception {
		user = new UserForm();
		user.initView(false);
		return SUCCESS;
	}

	/**
	 * @return the user
	 */
	public UserForm getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserForm user) {
		this.user = user;
	}

}
