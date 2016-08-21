package action;

import java.util.List;

import logic.LogicDTO;
import logic.ProUserBatchDeleteExecLogic;
import util.Contants;
import form.UserDetil;
import form.UserForm;

public class ProUserBatchDeleteExecAction extends MySuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617947585265284786L;
	private UserForm user;
	private ProUserBatchDeleteExecLogic logic;
	private String[] deleteCkeck;

	public String execute() throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		if (deleteCkeck == null) {
			this.addFieldError("field", getText(Contants.E014));
			user.initView(true);
			user.setResultList((List<UserDetil>) this.request.getSession()
					.getAttribute("userbatchlist"));
			return INPUT;
		} else {
			dto = logic.doLogic(deleteCkeck);
		}
		if (dto.isResult()) {
			user.initView(true);
			user.setResultList((List<UserDetil>) this.request.getSession()
					.getAttribute("userbatchlist"));
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			user.initView(true);
			user.setResultList((List<UserDetil>) this.request.getSession()
					.getAttribute("userbatchlist"));
			return INPUT;
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
	public ProUserBatchDeleteExecLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProUserBatchDeleteExecLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the deleteCkeck
	 */
	public String[] getDeleteCkeck() {
		return deleteCkeck;
	}

	/**
	 * @param deleteCkeck
	 *            the deleteCkeck to set
	 */
	public void setDeleteCkeck(String[] deleteCkeck) {
		this.deleteCkeck = deleteCkeck;
	}

}
