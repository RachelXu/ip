package action;

import logic.ProServiceEditLogic;
import form.ServiceForm;

public class ProServiceEditAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 825543208411411562L;
	private ServiceForm service;
	private ProServiceEditLogic logic;

	public String execute() throws Exception {
		logic.doLogic(service);
		return SUCCESS;
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
	 * @return the logic
	 */
	public ProServiceEditLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProServiceEditLogic logic) {
		this.logic = logic;
	}

}
