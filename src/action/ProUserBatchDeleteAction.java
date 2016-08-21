package action;

import logic.LogicDTO;
import logic.ProUserBatchEditLogic;
import util.CommonUtil;
import util.Contants;
import form.UserForm;

public class ProUserBatchDeleteAction extends MySuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617947585265284786L;
	private UserForm user;
	private ProUserBatchEditLogic logic;

	public String execute() throws Exception {
		LogicDTO dto = logic.doLogic(user);
		this.request.getSession().setAttribute("userbatchlist",
				user.getResultList());
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
	public ProUserBatchEditLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProUserBatchEditLogic logic) {
		this.logic = logic;
	}

}
