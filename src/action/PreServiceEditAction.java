package action;

import logic.LogicDTO;
import logic.PreServiceEditLogic;
import form.ServiceForm;

public class PreServiceEditAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private ServiceForm service;
	private PreServiceEditLogic logic;
	private String editId;

	public String execute() throws Exception {
		service = new ServiceForm();
		LogicDTO logicDTO = logic.doLogic(editId, service);
		if (logicDTO.isResult()) {
			return SUCCESS;
		} else {
			this.addActionError(getText(logicDTO.getErrorCode()));
			return INPUT;
		}
	}

	/**
	 * @return the service
	 */
	public ServiceForm getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(ServiceForm service) {
		this.service = service;
	}

	/**
	 * @return the editId
	 */
	public String getEditId() {
		return editId;
	}

	/**
	 * @param editId
	 *            the editId to set
	 */
	public void setEditId(String editId) {
		this.editId = editId;
	}

	/**
	 * @return the logic
	 */
	public PreServiceEditLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreServiceEditLogic logic) {
		this.logic = logic;
	}

}
