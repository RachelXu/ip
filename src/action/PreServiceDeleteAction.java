package action;

import logic.LogicDTO;
import logic.PreServiceEditLogic;
import form.ServiceForm;

public class PreServiceDeleteAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private ServiceForm service;
	private PreServiceEditLogic logic;
	private String deleteId;

	public String execute() throws Exception {
		service = new ServiceForm();
		LogicDTO logicDTO = logic.doLogic(deleteId, service);
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
	 * @return the deleteId
	 */
	public String getDeleteId() {
		return deleteId;
	}

	/**
	 * @param deleteId
	 *            the deleteId to set
	 */
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
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
