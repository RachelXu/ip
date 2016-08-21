package action;

import logic.LogicDTO;
import logic.ProUserSearchLogic;
import util.CommonUtil;
import util.Contants;
import form.UserForm;

public class ProUserSearchAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 378340882595762250L;
	private UserForm user;
	private ProUserSearchLogic logic;
	private String pageString;

	public String execute() throws Exception {
		if (CommonUtil.isEmpty(user.getCurrentPage())
				|| user.getCurrentPage() < 1) {
			user.setCurrentPage(1);
		}
		if (!CommonUtil.isEmpty(pageString)) {
			if (Contants.PRIV.equals(pageString)) {
				user.setCurrentPage(user.getCurrentPage() - 1);
			}
			if (Contants.NEXT.equals(pageString)) {
				user.setCurrentPage(user.getCurrentPage() + 1);
			}
		}
		LogicDTO dto = logic.doLogic(user);
		if (dto.isResult()) {
			user.initView(true);
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			user.initView(false);
			return INPUT;
		}
	}

	public void validate() {
		super.validate();
		if (!CommonUtil.isEmpty(user.getRestDay1())
				&& !CommonUtil.isNumber(user.getRestDay1())) {
			this.addFieldError("field", getText(Contants.E009));
		}
		if (!CommonUtil.isEmpty(user.getRestDay2())
				&& !CommonUtil.isNumber(user.getRestDay2())) {
			this.addFieldError("field", getText(Contants.E009));
		}
		if (super.getFieldErrors().size() != 0) {
			user.initView(false);
		} else {
			user.initView(true);
		}
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

	/**
	 * @return the logic
	 */
	public ProUserSearchLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProUserSearchLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the pageString
	 */
	public String getPageString() {
		return pageString;
	}

	/**
	 * @param pageString
	 *            the pageString to set
	 */
	public void setPageString(String pageString) {
		this.pageString = pageString;
	}

}
