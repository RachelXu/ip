package action;

import java.util.List;

import logic.LogicDTO;
import logic.ProUserBatchEditExecLogic;
import util.CommonUtil;
import util.Contants;
import form.UserDetil;
import form.UserForm;

public class ProUserBatchEditExecAction extends MySuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617947585265284786L;
	private UserForm user;
	private UserForm userBatchEdit;
	private ProUserBatchEditExecLogic logic;

	public String execute() throws Exception {
		List<UserDetil> userDetilList = (List<UserDetil>) this.request
				.getSession().getAttribute("userbatchlist");
		LogicDTO dto = logic.doLogic(userBatchEdit, userDetilList);
		this.request.getSession().removeAttribute("userbatchlist");
		if (dto.isResult()) {
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
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
		if (!CommonUtil.isEmpty(userBatchEdit.getRestDay())
				&& !CommonUtil.isNumber(userBatchEdit.getRestDay())) {
			this.addFieldError("field", getText(Contants.E009));
		}
		user.initView(true);
		user.setResultList((List<UserDetil>) this.request.getSession()
				.getAttribute("userbatchlist"));

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
	public ProUserBatchEditExecLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProUserBatchEditExecLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the userBatchEdit
	 */
	public UserForm getUserBatchEdit() {
		return userBatchEdit;
	}

	/**
	 * @param userBatchEdit
	 *            the userBatchEdit to set
	 */
	public void setUserBatchEdit(UserForm userBatchEdit) {
		this.userBatchEdit = userBatchEdit;
	}

}
