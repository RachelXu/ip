package action;

import logic.LogicDTO;
import logic.ProAdminInsertLogic;
import util.Contants;
import form.AdminForm;

public class ProAdminInsertAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private AdminForm admin1;
	private ProAdminInsertLogic logic;

	public String execute() throws Exception {
		LogicDTO dto = logic.doLogic(admin1);
		if (dto.isResult()) {
			this.addFieldError("field", "管理员添加成功！");
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
	public ProAdminInsertLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProAdminInsertLogic logic) {
		this.logic = logic;
	}

}
