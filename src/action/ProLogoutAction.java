package action;

public class ProLogoutAction extends MySuperAction {

	private static final long serialVersionUID = 4092783777260587307L;

	public String execute() throws Exception {

		this.request.getSession().removeAttribute("admin");
		this.request.getSession().invalidate();
		return SUCCESS;

	}

}
