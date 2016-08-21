package action;

import form.ServiceForm;

public class PreServiceInsertAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private ServiceForm service;

	public String execute() throws Exception {
		service = new ServiceForm();
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

}
