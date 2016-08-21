package action;

import logic.ProServiceDeleteLogic;
import form.ServiceForm;

public class ProServiceDeleteAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 825543208411411562L;
	private ServiceForm service;
	private ProServiceDeleteLogic logic;

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
	public ProServiceDeleteLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProServiceDeleteLogic logic) {
		this.logic = logic;
	}

}
