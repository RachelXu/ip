package action;

import logic.ProServiceInsertLogic;
import form.ServiceForm;

public class ProServiceInsertAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private ServiceForm service;
	private ProServiceInsertLogic logic;

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
	public ProServiceInsertLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProServiceInsertLogic logic) {
		this.logic = logic;
	}

}
